package com.example.tema2;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private final LayoutInflater layoutInflater;
    private Context mContext;
    private List<User> mUsers;

   public UserListAdapter(Context context){
       layoutInflater=LayoutInflater.from(context);
       mContext=context;

   }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView=layoutInflater.inflate(R.layout.list_item,parent,false);
    UserViewHolder viewHolder=new UserViewHolder(itemView);

    return viewHolder;
   }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        if(mUsers!=null){
            User user=mUsers.get(position);
            holder.setData("name: "+user.getName()+" nota:"+user.getMark(),position);
            ///holder.setData(user.getMark(),position);
        }
        else
        {
            holder.userItemView.setText(R.string.no_user);
        }
    }
    @Override
    public int getItemCount()
    {
        if(mUsers!=null)
            return mUsers.size();
        else
            return 0;
    }
    public void setUsers(List<User>users){
       mUsers=users;
       notifyDataSetChanged();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

       private TextView userItemView;
       private int mPosition;

       public UserViewHolder(View itemView){
            super(itemView);
            userItemView= itemView.findViewById(R.id.idLIUser);
        }

        public void setData(String user, int position){
           userItemView.setText(user);
           mPosition=position;
        }
    }



}