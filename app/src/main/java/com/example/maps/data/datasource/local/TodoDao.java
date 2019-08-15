package com.example.maps.data.datasource.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.maps.data.TodoNote;

import java.util.List;

@Dao
public interface TodoDao {
    @Insert
    void insert(TodoNote todoNote);

    @Query("SELECT * from todonote_table")
    List<TodoNote> getAllWords();
}
