package com.ruyonga.devquotes;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AddQuote extends AppCompatActivity {

    public static final String EXTRA_QUOTE_REPLY = "com.ruyonga.devquotes.devquotes.QUOTE_REPLY";
    public static final String EXTRA_AUTHOR_REPLY = "com.ruyonga.devquotes.devquotes.AUTHOR_REPLY";

    EditText addQuote, addAuthor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quote);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addAuthor = findViewById(R.id.edit_author);
        addQuote = findViewById(R.id.edit_word);
        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(addQuote.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String quote = addQuote.getText().toString();
                String author = addAuthor.getText().toString();
                replyIntent.putExtra(EXTRA_QUOTE_REPLY, quote);
                replyIntent.putExtra(EXTRA_AUTHOR_REPLY, author);

                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}