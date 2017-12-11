package com.salajim.musab.atheistquotes.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salajim.musab.atheistquotes.R;
import com.salajim.musab.atheistquotes.models.Questions;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Musab on 12/11/2017.
 */

public class ForumQuestionsAdapter extends RecyclerView.Adapter<ForumQuestionsAdapter.MyViewHolder> {
    private ArrayList<Questions> mQuestions = new ArrayList<>();
    private Context mContext;

    public ForumQuestionsAdapter(Context context, ArrayList<Questions> questions) {
        mContext = context;
        mQuestions = questions;
    }

    @Override
    public ForumQuestionsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.questions, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForumQuestionsAdapter.MyViewHolder holder, int position) {
        holder.bindQuestions(mQuestions.get(position));
    }

    @Override
    public int getItemCount() {
        return mQuestions.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.nameTextView) TextView mNameTextView;
        @Bind(R.id.questionTextView) TextView mQuestionTextView;
        private Context mContext;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindQuestions(Questions questions) {

            mNameTextView.setText(questions.getName() + "Says:");
            mQuestionTextView.setText(questions.getQuestion());

        }
    }
}
