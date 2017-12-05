package com.salajim.musab.atheistquotes.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.salajim.musab.atheistquotes.models.Quotes;
import com.salajim.musab.atheistquotes.R;
import com.salajim.musab.atheistquotes.activities.AddNewQuotes;
import com.salajim.musab.atheistquotes.adapters.QuotesAdapter;

import java.util.ArrayList;

/**
 * Created by Musab on 11/10/2017.
 */

public class NewFragment extends Fragment {
    public static final String TAG = "NewFragment";

    private FloatingActionButton fab;

    private ArrayList<Quotes> mQuotes = new ArrayList<>();
    private QuotesAdapter mAdapter;
    FirebaseDatabase database;
    DatabaseReference mRef;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_fragment, container, false);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddNewQuotes.class);
                startActivity(intent);
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        return view;
    }
}
