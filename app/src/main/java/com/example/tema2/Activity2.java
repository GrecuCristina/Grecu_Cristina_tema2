package com.example.tema2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();
    private EditText flname;

    private EditText mark;
    public static final String user_name_added="new_name";
    public static final String user_mark_added="new_mark";
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        flname=findViewById(R.id.idEdt1);
        mark=findViewById(R.id.idEdt2);
        Button btnAddUser=findViewById(R.id.Btn1);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"AiciInsert");
                Intent intent = new Intent();
                if (TextUtils.isEmpty(flname.getText()) || TextUtils.isEmpty(mark.getText())) {
                    Log.i(TAG, "AiciEmpty");
                    setResult(RESULT_CANCELED, intent);
                } else {
                    String name = flname.getText().toString();
                    intent.putExtra(user_name_added, name);
                    String mark1 = mark.getText().toString();
                    Log.i(mark1, "Aici"+mark1);
                    Log.i(name, "Aici name "+name);
                    intent.putExtra(user_mark_added, mark1);

                    Log.i(TAG, "AiciOk");
                    setResult(RESULT_OK, intent);
                }
                finish();

            }
        });
        Button btnDeleteUser=findViewById(R.id.Btn2);
        btnDeleteUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i(TAG,"AiciDelete");
           String name=flname.getText().toString();
           User user =new User();
           user.setName(name);
           Log.i(TAG,"Aici "+user.getName());
        //  UserViewModel.userDB.userDao().delete(user);
            }
        });

    }
   }



