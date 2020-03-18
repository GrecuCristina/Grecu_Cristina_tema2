package com.example.tema2;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey
    @NonNull
    private String id;

    @NonNull
    @ColumnInfo(name="name")
    private String name;

    @NonNull
    @ColumnInfo(name="mark")
    private String mark;

    public User() {

    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    @NonNull
   public String getMark() {
        return this.mark;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setMark(@NonNull String mark) {
        this.mark = mark;
    }

    public User(String id, String name, String mark)
    {
        this.id=id;
        this.mark=mark;
        this.name=name;
    }



}
