package com.ruyonga.devquotes.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "quotes_table")
public class Quote {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "quote")
    private String mQuote;

    @ColumnInfo(name = "author")
    private String mAuthor;

    public Quote(@NonNull String mQuote, @NonNull String mAuthor) {
        this.mQuote = mQuote;
        this.mAuthor = mAuthor;
    }

    public String getQuote() {
        return mQuote;
    }

    public String getAuthor() {
        return mAuthor;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
