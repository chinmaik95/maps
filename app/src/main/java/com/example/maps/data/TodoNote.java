package com.example.maps.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "todonote_table")
public class TodoNote {
    @PrimaryKey(autoGenerate=true)
     int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnInfo(name = "title")
     String title;
    @ColumnInfo(name = "subtitle")
     String subTitle;

    public TodoNote(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @NonNull
    @Override
    public String toString() {
        return title +"\n" + subTitle;
    }
}
