package com.ruyonga.devquotes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ruyonga.devquotes.entity.Quote;

import java.util.List;

public class QuoteViewModel extends AndroidViewModel {
    private QuotesRepository mRepository;
    private LiveData<List<Quote>> mAllWords;

    public QuoteViewModel(@NonNull Application application) {
        super(application);
        mRepository = new QuotesRepository(application);
        mAllWords = mRepository.getAllQuotes();
    }

    LiveData<List<Quote>> getAllQuotes() {
        return mAllWords;
    }

    public void insert(Quote quote) {
        mRepository.insert(quote);
    }
}
