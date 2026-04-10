package com.example.userregistrationapp;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public class UserDatabase extends RoomDatabase {

}
