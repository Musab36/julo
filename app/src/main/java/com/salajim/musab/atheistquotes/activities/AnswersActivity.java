package com.salajim.musab.atheistquotes.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.salajim.musab.atheistquotes.R;
import com.salajim.musab.atheistquotes.models.Questions;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AnswersActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.fab) FloatingActionButton fab;

    ArrayList<Questions> mQuestions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);
        ButterKnife.bind(this);

        mQuestions = Parcels.unwrap(getIntent().getParcelableExtra("questions"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        fab.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == fab) {
            Intent intent = new Intent(AnswersActivity.this, AddAnswer.class);
            startActivity(intent);
        }
    }
}
