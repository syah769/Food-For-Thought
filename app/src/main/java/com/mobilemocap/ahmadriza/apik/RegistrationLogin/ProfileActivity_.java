package com.mobilemocap.ahmadriza.apik.RegistrationLogin;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.mobilemocap.ahmadriza.apik.ExerciseActivity;
import com.mobilemocap.ahmadriza.apik.MainActivity;
import com.mobilemocap.ahmadriza.apik.R;
import com.mobilemocap.ahmadriza.apik.RegistrationLogin.fragments.ProfileFragment;

public class ProfileActivity_ extends AppCompatActivity {


    private TextView name;

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), ExerciseActivity.class);
        myIntent.putExtra("tabSelected", "0");  // pass your values and retrieve them in the other Activity using keyName
        startActivity(myIntent);

        //startActivityForResult(myIntent, 0);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_);
        bindViews();
        init();


        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout_content_chat, new ProfileFragment())
                .commit();


    }
    private void bindViews() {
        name = (TextView) findViewById(R.id.chat_username);
        //imBackButton = (ImageButton) findViewById(R.id.btReturnHome);
    }

    private void init() {
        // set the toolbar
        //setSupportActionBar(mToolbar);

        // Creating New Variable to remove @example.com
        name.setText("User Profile");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);

        //Setting toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }




}

