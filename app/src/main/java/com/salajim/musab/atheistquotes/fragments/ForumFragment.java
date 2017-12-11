package com.salajim.musab.atheistquotes.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.salajim.musab.atheistquotes.R;
import com.salajim.musab.atheistquotes.activities.ForumActivity;
import com.salajim.musab.atheistquotes.adapters.ForumQuestionsAdapter;
import com.salajim.musab.atheistquotes.models.Questions;

import java.util.ArrayList;

/**
 * Created by Musab on 11/21/2017.
 */

public class ForumFragment extends Fragment {
    public static final String TAG = "ForumFragment";

    FirebaseDatabase database;
    DatabaseReference mRef;
    private ArrayList<Questions> mQuestions = new ArrayList<>();
    private ForumQuestionsAdapter mAdapter;

    RecyclerView recyclerView;

    private FloatingActionButton fab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forum_fragment, container, false);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ForumActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        database = FirebaseDatabase.getInstance();
        mRef = database.getReference("questions");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    mQuestions.add(dataSnapshot1.getValue(Questions.class));
                }

                mAdapter = new ForumQuestionsAdapter(getActivity(), mQuestions);
                recyclerView.setAdapter(mAdapter);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return view;
    }
}
