package com.mobilemocap.ahmadriza.apik;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Locale;

public class Utama extends AppCompatActivity {

    Button btnCekKalori;
    Button btnHitung;
    Button btnAbout;

    int backPresssed = 0;

    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);


        if (Locale.getDefault().getLanguage().equals("en")){
            ImageView backGround = (ImageView) findViewById(R.id.bg);
            backGround.setImageResource(R.drawable.bg_home_eng);
        }

        ///<AdMob
        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, getResources().getString(R.string.home_banner_ad_id));

        // Gets the ad view defined in layout/ad_fragment.xml with ad unit ID set in
        // values/strings.xml.
        mAdView = (AdView) findViewById(R.id.ad_view);

        // Create an ad request. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."

//        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        AdRequest adRequest = new AdRequest.Builder().build();

        // Start loading the ad in the background.
        mAdView.loadAd(adRequest);
        //>

        //dialog
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom);
        final ImageView imgIcn = (ImageView) dialog.findViewById(R.id.icn);
        final Button btnClose = (Button) dialog.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        imgIcn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse(getResources().getString(R.string.app_link));
                Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
                startActivity(intent);
            }
        });


        //inisialisasi
        btnCekKalori=(Button)findViewById(R.id.btnCekKalori);

        btnAbout = (Button) findViewById(R.id.btnAbout);


        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), com.mobilemocap.ahmadriza.apik.RegistrationLogin.activities.Menu.class);
                startActivity(i);
            }
        });

        btnCekKalori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),FormUser.class);
                startActivity(i);
            }

        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        backPresssed=0;
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    //Tombol Back kalo di pencet
    @Override
    public void onBackPressed(){

        backPresssed++;
        if (backPresssed >1) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);
        }else{
            Toast.makeText(this,getResources().getString(R.string.ask_back),Toast.LENGTH_SHORT).show();
        }
    }

    /** Called when leaving the activity */
    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }


    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}

