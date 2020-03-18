package com.example.tema2;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = User.class,version = 1)
public abstract class UserRoomDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    private static volatile UserRoomDatabase userRoomInstance;

    ///mai jos se creeaza BD, in caz ca nu exista deja

    static UserRoomDatabase getDatabase(final Context context) {
        if (userRoomInstance == null) {
            synchronized (UserRoomDatabase.class) {
                if (userRoomInstance == null) {
                    userRoomInstance = Room.databaseBuilder(context.getApplicationContext(),
                            UserRoomDatabase.class, "user_database")
                            .build();
                }
            }
        }
        return userRoomInstance;
    }

}
