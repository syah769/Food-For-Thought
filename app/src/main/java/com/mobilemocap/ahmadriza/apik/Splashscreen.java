package com.mobilemocap.ahmadriza.apik;


import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.mobilemocap.ahmadriza.apik.RegistrationLogin.activities.LoginActivity;



public class Splashscreen extends AppCompatActivity {

    //TODO fix whitescreen

    private static int splashInterval = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent i = new Intent(Splashscreen.this, LoginActivity.class);
                startActivity(i); // menghubungkan activity splashscren ke main activity dengan intent
                this.finish();
            }

            private void finish() {
                // TODO Auto-generated method stub

            }
        }, splashInterval*1000);

    };

}


