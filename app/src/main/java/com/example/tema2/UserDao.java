package com.example.tema2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao

public interface UserDao {
    @Insert
    void insert(User user);

    @Query("SELECT * FROM users")
    LiveData<List<User>> getAllUsers();

    @Delete
    public void delete(User user);

    @Query("SELECT * FROM users where name= :name")
    User getUser(String name);



}
