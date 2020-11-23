package com.example.myquizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.myquizapp.core.CustomViewPager;
import com.example.myquizapp.core.MainPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private CustomViewPager viewPager;
    private MainPagerAdapter pagerAdapter;
    private BottomNavigationView bottomNav;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews() {
        bottomNav = findViewById(R.id.bottom_navigation);
        viewPager = findViewById(R.id.main_viewpager);
        viewPager.disableScroll(true);
        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        bottomNav.setOnNavigationItemSelectedListener(this);
    }

    @SuppressLint("NewApi")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int page = 0;

        switch (item.getItemId()) {
            case R.id.nav_history:
                page = 1;
                toolbar.setTitle(R.string.app_history);
                break;
            case R.id.nav_settings:
                page = 2;
                toolbar.setTitle(R.string.app_settings);
                break;
        }
        viewPager.setCurrentItem(page);
        return true;
    }

}