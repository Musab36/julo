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
import com.salajim.musab.atheistquotes.models.Answers;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddAnswer extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.nameEditText) EditText mNameEditText;
    @Bind(R.id.answerEditText) EditText mAnswerEditText;
    @Bind(R.id.sendButton) Button mSend;

    List<Answers> answerse;
    DatabaseReference databaseAnswers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_answer);
        ButterKnife.bind(this);

        databaseAnswers = FirebaseDatabase.getInstance().getReference("answers");

        answerse = new ArrayList<>();
        mSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mSend) {
            addAnswers();
        }
    }

    private void addAnswers() {
        String name = mNameEditText.getText().toString().trim();
        String answer = mAnswerEditText.getText().toString().trim();

        if(!TextUtils.isEmpty(name)) {

            String id = databaseAnswers.push().getKey();

            Answers answers = new Answers(id, name, answer);

            databaseAnswers.child(id).setValue(answers);

            mNameEditText.setText("");
            mAnswerEditText.setText("");

            Toast.makeText(this, "Answer submitted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Fields cannot be empty!", Toast.LENGTH_SHORT).show();
        }
    }
}
