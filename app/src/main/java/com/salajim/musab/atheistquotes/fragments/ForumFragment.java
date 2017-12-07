package com.salajim.musab.atheistquotes.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salajim.musab.atheistquotes.R;
import com.salajim.musab.atheistquotes.activities.ForumActivity;

/**
 * Created by Musab on 11/21/2017.
 */

public class ForumFragment extends Fragment {
    public static final String TAG = "ForumFragment";

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


        return view;
    }
}
