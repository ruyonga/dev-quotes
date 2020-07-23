package com.ruyonga.devquotes.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ruyonga.devquotes.entity.Quote;

import java.util.List;

@Dao
public interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Quote quote);

    @Query("DELETE FROM quotes_table")
    void deleteAll();

    @Query("SELECT * from quotes_table ORDER By quote ASC")
    LiveData<List<Quote>> getAlphabetizedQuotes();

    @Query("SELECT * FROM quotes_table WHERE author = :author")
    LiveData<List<Quote> > loadAllQuotesByAuthor(String author);

}
