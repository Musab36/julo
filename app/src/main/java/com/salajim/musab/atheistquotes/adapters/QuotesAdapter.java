package com.salajim.musab.atheistquotes.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.salajim.musab.atheistquotes.R;
import com.salajim.musab.atheistquotes.models.Quotes;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Musab on 11/21/2017.
 */

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder> {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    private ArrayList<Quotes> mQuotes = new ArrayList<>();
    private Context mContext;
    FirebaseDatabase database;
    DatabaseReference mRef;

    public QuotesAdapter(Context context, ArrayList<Quotes> quotes) {
        mContext = context;
        mQuotes = quotes;
    }

    @Override
    public QuotesAdapter.QuotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        QuotesViewHolder viewHolder = new QuotesViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(QuotesAdapter.QuotesViewHolder holder, int position) {
        holder.bindQuotes(mQuotes.get(position));
    }

    @Override
    public int getItemCount() {
        return mQuotes.size();
    }

    public class QuotesViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.authorQuote) TextView mAuthorQuote;
        @Bind(R.id.authorName) TextView mAuthorName;

        private Context mContext;

        public QuotesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindQuotes(Quotes quotes) {
            //Picasso.with(mContext)
                   // .load(quotes.getImage())
                   // .resize(MAX_WIDTH, MAX_HEIGHT)
                   // .centerCrop()
                    //.into(mAuthorImage);

            mAuthorQuote.setText(quotes.getQuote());
            mAuthorName.setText(quotes.getAuthor());
        }

    }

}
