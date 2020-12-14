package com.example.mobilepo.model.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.mobilepo.model.interfaces.IDao;

@Database(entities = {Note.class}, version = 3)
public abstract  class DB extends RoomDatabase {
    public abstract IDao Dao();
}


