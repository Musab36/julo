package com.salajim.musab.atheistquotes.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.salajim.musab.atheistquotes.R;
import com.salajim.musab.atheistquotes.models.Questions;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ForumActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = ForumActivity.class.getSimpleName();
    @Bind(R.id.nameEditText) EditText mNameEditText;
    @Bind(R.id.questionEditText) EditText mQuestion;
    @Bind(R.id.submitQuizBtn) Button mSubmitQuizBtn;

    List<Questions> questions;
    DatabaseReference databaseQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        ButterKnife.bind(this);

        databaseQuiz = FirebaseDatabase.getInstance().getReference("questions");
        mSubmitQuizBtn.setOnClickListener(this);

        questions = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        if(v == mSubmitQuizBtn) {
            addQuestions();
        }
    }

    private void addQuestions() {
        String name = mNameEditText.getText().toString().trim();
        String question = mQuestion.getText().toString().trim();

        if(!TextUtils.isEmpty(name)) {

            String id = databaseQuiz.push().getKey();

            Questions questions = new Questions(id, name, question);

            databaseQuiz.child(id).setValue(questions);

            mNameEditText.setText("");
            mQuestion.setText("");

            Toast.makeText(this, "Question Submitted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        }
    }
}
