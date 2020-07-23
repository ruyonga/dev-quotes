package com.ruyonga.devquotes;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.ruyonga.devquotes.database.QuoteDao;
import com.ruyonga.devquotes.database.QuoteRoomDatabase;
import com.ruyonga.devquotes.entity.Quote;

import java.util.List;

public class QuotesRepository {
    private QuoteDao mQuoteDao;
    private LiveData<List<Quote>> mAllQuotes;

    QuotesRepository(Application application) {
        QuoteRoomDatabase db = QuoteRoomDatabase.getDatabase(application);
        mQuoteDao = db.quoteDao();
        mAllQuotes = mQuoteDao.getAlphabetizedQuotes();

    }

    LiveData<List<Quote>> getAllQuotes() {
        return mAllQuotes;
    }

    void insert(Quote quote) {
        QuoteRoomDatabase.databaseWriteExecutor.execute(() -> mQuoteDao.insert(quote));
    }
}
