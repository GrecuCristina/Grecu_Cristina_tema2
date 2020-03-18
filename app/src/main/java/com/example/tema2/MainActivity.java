package com.example.tema2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;
import java.util.Observable;

import java.util.UUID;
import java.util.OptionalDouble;

public class MainActivity extends AppCompatActivity {

    private static final int NEW_USER_ACTIVITY_REQUEST_CODE = 1;
    private UserViewModel userViewModel;
    private String TAG = this.getClass().getSimpleName();
   private UserListAdapter userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_user_list);



        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        userListAdapter = new UserListAdapter(this);
        recyclerView.setAdapter(userListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Button btn1=findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });


        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getAllUsers().observe(this,new Observer<List<User>>(){


            @Override
            public void onChanged(List<User> users) {
                userListAdapter.setUsers(users);

            }
        });




    }
    public void openActivity2(){

        Intent intent = new Intent(MainActivity.this,Activity2.class);

        startActivityForResult(intent,NEW_USER_ACTIVITY_REQUEST_CODE);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(TAG,"AiciOnActivityResult");
        if (requestCode == NEW_USER_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {

            // Code to insert user
            final String note_id = UUID.randomUUID().toString();
            User user = new User(note_id, data.getStringExtra(Activity2.user_name_added),data.getStringExtra(Activity2.user_mark_added));
            userViewModel.insert(user);
            ///userViewModel.delete(user);

            Toast.makeText(
                    getApplicationContext(),
                    R.string.saved,
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }



}
