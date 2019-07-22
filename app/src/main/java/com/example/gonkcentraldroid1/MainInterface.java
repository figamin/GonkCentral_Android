package com.example.gonkcentraldroid1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


/**
 * Ian Anderson
 * 7/21/19
 */

public class MainInterface extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maininterface);
        makeTabBar();
        TabAdapter tadapter = new TabAdapter(getSupportFragmentManager(), 4);
        TabLayout tlayout = findViewById(R.id.tlayout);
        ViewPager vpager = findViewById(R.id.viewPager);
        vpager.setAdapter(tadapter);
        tlayout.setupWithViewPager(vpager);
        tlayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });
    }

    private void makeTabBar()
    {
        Toolbar tbar = findViewById(R.id.toolbar);
        setSupportActionBar(tbar);
        getSupportActionBar().setTitle("Gonk Central Alpha");
    }
}
