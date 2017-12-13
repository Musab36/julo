package com.salajim.musab.atheistquotes.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.salajim.musab.atheistquotes.R;
import com.salajim.musab.atheistquotes.models.Questions;

import org.parceler.Parcels;

import java.util.ArrayList;

public class AnswersActivity extends AppCompatActivity {
    ArrayList<Questions> mQuestions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

        mQuestions = Parcels.unwrap(getIntent().getParcelableExtra("questions"));
        int startingPosition = getIntent().getIntExtra("position", 0);
    }
}
