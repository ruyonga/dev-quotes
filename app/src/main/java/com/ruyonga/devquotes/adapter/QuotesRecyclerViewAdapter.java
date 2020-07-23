package com.ruyonga.devquotes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ruyonga.devquotes.R;
import com.ruyonga.devquotes.entity.Quote;

import java.util.List;

public class QuotesRecyclerViewAdapter extends RecyclerView.Adapter<QuotesRecyclerViewAdapter.QuotesViewHolder> {

    private final LayoutInflater mInflater;
    private List<Quote> mQuotes;

    public QuotesRecyclerViewAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public QuotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.quotes_list_item, parent, false);
        return new QuotesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesViewHolder holder, int position) {
        if (mQuotes != null) {
            Quote current = mQuotes.get(position);
            holder.quoteAuthorItemView.setText(current.getAuthor());
            holder.quoteItemView.setText(current.getQuote());
        } else {
            holder.quoteItemView.setText(R.string.empty_quotes);
        }
    }

   public void setWords(List<Quote> quotes) {
        mQuotes = quotes;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mQuotes != null)
            return mQuotes.size();
        else return 0;
    }

    public class QuotesViewHolder extends RecyclerView.ViewHolder {
        private final TextView quoteItemView;
        private final TextView quoteAuthorItemView;

        private QuotesViewHolder(View itemView) {
            super(itemView);
            quoteAuthorItemView = itemView.findViewById(R.id.author);
            quoteItemView = itemView.findViewById(R.id.quote);

        }
    }
}
