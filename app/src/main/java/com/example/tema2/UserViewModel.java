package com.example.tema2;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private String TAG=this.getClass().getSimpleName();
    private UserDao userDao;
    public  UserRoomDatabase userDB;
    private LiveData<List<User>> mAllUsers;
    ///constructor
    public UserViewModel(@NonNull Application application) {
        super(application);
        userDB=UserRoomDatabase.getDatabase(application);
        userDao=userDB.userDao();
        mAllUsers=userDao.getAllUsers();

    }
    public void insert(User user) {
        new InsertAsyncTask(userDao).execute(user);
    }
    public void delete(User user) { new DeleteAsyncTask(userDao).execute(user);
    }

    LiveData<List<User>>getAllUsers(){
        return mAllUsers;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG,"User Model Destroyed");
    }
    /*
    private class OperationsAsyncTask extends AsyncTask<User, Void, Void> {

        UserDao mAsyncTaskDao;

        OperationsAsyncTask(UserDao dao) {
            this.mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(User... notes) {
            return null;
        }
    }
    */

    private class InsertAsyncTask extends AsyncTask<User,Void,Void>
    {

        UserDao mUserDao;

        public InsertAsyncTask(UserDao mUserDao) {
            this.mUserDao = mUserDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            mUserDao.insert(users[0]);
            return null;
        }
    }
    private class DeleteAsyncTask extends AsyncTask<User,Void,Void>
    {

        UserDao mUserDao;

        public DeleteAsyncTask(UserDao mUserDao) {
            this.mUserDao = mUserDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            mUserDao.delete(users[0]);
            return null;
        }
    }


    }

