package com.salajim.musab.atheistquotes.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salajim.musab.atheistquotes.R;

/**
 * Created by Musab on 11/10/2017.
 */

public class TestimoniesFragment extends Fragment {
    public static final String TAG = "TestimoniesFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.testimonies_fragment, container, false);

        return view;
    }
}
