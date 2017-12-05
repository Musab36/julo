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
import com.salajim.musab.atheistquotes.activities.AddQuotes;
import com.salajim.musab.atheistquotes.adapters.QuotesAdapter;
import com.salajim.musab.atheistquotes.models.Quotes;

import java.util.ArrayList;

/**
 * Created by Musab on 11/10/2017.
 */

public class TopFragment extends Fragment {
 public static final String TAG = "TopFragment";

    FirebaseDatabase database;
    DatabaseReference mRef;
     private ArrayList<Quotes> mQuotes = new ArrayList<>();
    private QuotesAdapter mAdapter;

    RecyclerView recyclerView;
    private FloatingActionButton fab;

    public TopFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_fragment, container, false);

        fab = (FloatingActionButton) view.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddQuotes.class);
                startActivity(intent);
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        database = FirebaseDatabase.getInstance();
        mRef = database.getReference("top");

        mRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    mQuotes.add(dataSnapshot1.getValue(Quotes.class));
                }

                mAdapter = new QuotesAdapter(getActivity(), mQuotes);
                recyclerView.setAdapter(mAdapter);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }
}
