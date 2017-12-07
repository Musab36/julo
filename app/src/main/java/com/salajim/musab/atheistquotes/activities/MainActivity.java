package com.salajim.musab.atheistquotes.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.salajim.musab.atheistquotes.fragments.FavoriteFragment;
import com.salajim.musab.atheistquotes.fragments.ForumFragment;
import com.salajim.musab.atheistquotes.R;
import com.salajim.musab.atheistquotes.adapters.SectionsPagerAdapter;
import com.salajim.musab.atheistquotes.fragments.TopFragment;

public class MainActivity extends AppCompatActivity {
public static final String TAG = "MainActivity";
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPgare(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPgare(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TopFragment(), "Quotes");
        adapter.addFragment(new ForumFragment(), "Forum");
        adapter.addFragment(new FavoriteFragment(), "Testimonies");

        viewPager.setAdapter(adapter);
    }

}
