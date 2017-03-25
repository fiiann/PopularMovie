package com.albasyir.jundana.popularmovies;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.albasyir.jundana.popularmovies.ui.Movie_Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_icon);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            getSupportFragmentManager().
                    beginTransaction().
                    add(R.id.continer, Movie_Fragment.newInstance(0)).
                    commit();
        }

        TabLayout tablayout = (TabLayout) findViewById(R.id.tablayout);
        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        getSupportFragmentManager().
                                beginTransaction().
                                replace(R.id.continer, Movie_Fragment.newInstance(tab.getPosition())).
                                commit();
                        break;
                    case 1:
                        getSupportFragmentManager().
                                beginTransaction().
                                replace(R.id.continer, Movie_Fragment.newInstance(tab.getPosition())).
                                commit();
                        break;
                    case 2:
                        getSupportFragmentManager().
                                beginTransaction().
                                replace(R.id.continer, Movie_Fragment.newInstance(tab.getPosition())).
                                commit();
                        break;
                    case 3:
                        getSupportFragmentManager().
                                beginTransaction().
                                replace(R.id.continer, Movie_Fragment.newInstance(tab.getPosition())).
                                commit();
                        break;
                    case 4:
                        getSupportFragmentManager().
                                beginTransaction().
                                replace(R.id.continer, Movie_Fragment.newInstance(tab.getPosition())).
                                commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
