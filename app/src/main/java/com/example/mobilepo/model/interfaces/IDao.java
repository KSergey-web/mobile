package com.example.mobilepo.model.interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mobilepo.model.room.Note;

import java.util.List;


@Dao
public interface IDao {
    @Query("DELETE FROM expressions")
    void deleteAllNotes();

    @Delete
    void deleteNote(Note note);

    @Insert
    void insert(Note note);

    @Query("SELECT * FROM expressions")
    List<Note> getAllNotes();
}
