package com.salajim.musab.atheistquotes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Musab on 11/13/2017.
 */

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.MyViewHolder> {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    private ArrayList<Quotes> mQuotes = new ArrayList<>();
    private Context mContext;

    public QuotesAdapter(Context context, ArrayList<Quotes> quotes) {
        mContext = context;
        mQuotes = quotes;
    }

    @Override
    public QuotesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(QuotesAdapter.MyViewHolder holder, int position) {
        holder.bindQuotes(mQuotes.get(position));
    }

    @Override
    public int getItemCount() {
        return mQuotes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.author_image) ImageView mAuthorImageView;
        @Bind(R.id.author_name) TextView mAuthorName;
        @Bind(R.id.quote) TextView mQuote;

        private Context mContext;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindQuotes(Quotes quotes) {
            Picasso.with(mContext)
                    .load(quotes.getImageUrl())
                    .resize(MAX_WIDTH, MAX_HEIGHT)
                    .centerCrop()
                    .into(mAuthorImageView);

            mAuthorName.setText(quotes.getAuthor());
            mQuote.setText(quotes.getQuote());
        }
    }
}
