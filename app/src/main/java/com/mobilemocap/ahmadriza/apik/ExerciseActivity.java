package com.mobilemocap.ahmadriza.apik;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobilemocap.ahmadriza.apik.RegistrationLogin.ProfileActivity_;
import com.mobilemocap.ahmadriza.apik.WorkoutAndExercise.Exercise.ExerciseCategories;
import com.mobilemocap.ahmadriza.apik.WorkoutAndExercise.Workout.WorkoutCategories;


import java.util.ArrayList;
import java.util.List;

public class ExerciseActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //Return to specific tab
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String data;

        if(bundle != null){
            data = bundle.getString("tabSelected");
            Log.d("TAB", data);


            if (data.contains("0")) { // Workouts
                viewPager.setCurrentItem(0, true);
            }

            if (data.contains("1")) { // Exercice
                viewPager.setCurrentItem(1, true);
            }

            if (data.contains("2")) { //Chat
                viewPager.setCurrentItem(2, true);
            }
        }










    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> fragments = new ArrayList<>();
        private final List<String> fragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fragment) {
            super(fragment);
        }

        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            fragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitles.get(position);
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.home, menu);

        return true;
    }



    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new WorkoutCategories(), "Workouts");
        adapter.addFragment(new ExerciseCategories(), "Exercises");


        viewPager.setAdapter(adapter);
    }

    //@SuppressWarnings("StatementWithEmptyBody")

}

