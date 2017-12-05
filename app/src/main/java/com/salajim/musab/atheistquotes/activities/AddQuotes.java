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
import com.salajim.musab.atheistquotes.models.Quotes;
import com.salajim.musab.atheistquotes.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddQuotes extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.quoteEditText) EditText mQuotesEditText;
    @Bind(R.id.authorEditText) EditText mAuthorEditTetx;
    @Bind(R.id.submitBtn) Button mSubmitBtn;

    List<Quotes> quotes;

    DatabaseReference databaseQuotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quotes);
        ButterKnife.bind(this);

        databaseQuotes = FirebaseDatabase.getInstance().getReference("top");

        mSubmitBtn.setOnClickListener(this);

        quotes = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        addTopQuotes();
    }

    private void addTopQuotes() {
        String quote = mQuotesEditText.getText().toString().trim();
        String author = mAuthorEditTetx.getText().toString().trim();

        if(!TextUtils.isEmpty(quote)) {

            String id = databaseQuotes.push().getKey();

            Quotes quotes = new Quotes(quote, author, id);

            databaseQuotes.child(id).setValue(quotes);

            mQuotesEditText.setText("");
            mAuthorEditTetx.setText("");

            Toast.makeText(this, "Quote Submitted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Fields cannot be empty!", Toast.LENGTH_SHORT).show();
        }
    }
}
