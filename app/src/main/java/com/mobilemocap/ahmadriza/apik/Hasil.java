package com.mobilemocap.ahmadriza.apik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class Hasil extends AppCompatActivity {

    TextView txtCategory;
    TextView txtCalories;
    Button btnBack;

    String kategori="",kalori="";

    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        //init view
        txtCategory = (TextView) findViewById(R.id.txtCategory);
        txtCalories = (TextView) findViewById(R.id.txtCalories);
        btnBack = (Button) findViewById(R.id.btnBack);


        //get passed data
        Bundle  extras = getIntent().getExtras();
        if (extras!=null){
            kategori = extras.getString("KATEGORI_TUBUH");
            kalori = extras.getString("KEBUTUHAN_KALORI");
        }

        if (kategori.equals("Kurus")){
            kategori = getResources().getString(R.string.kurus);
            txtCategory.setTextColor(getResources().getColor(R.color.warning));
        }else if (kategori.equals("Gemuk")){
            kategori = getResources().getString(R.string.gemuk);
            txtCategory.setTextColor(getResources().getColor(R.color.danger));
        }else{
            kategori = getResources().getString(R.string.normal);
            txtCategory.setTextColor(getResources().getColor(R.color.colorAccent));
        }

        txtCategory.setText(kategori);
        txtCalories.setText(kalori);

        //Ad stuff
        MobileAds.initialize(this,getResources().getString(R.string.result_banner_ad_id));
        mAdView = (AdView) findViewById(R.id.ad_view_result);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Utama.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });

    }




//    private String textBuilder(){
//        String result="";
//        result= getResources().getString(R.string.body_cat_res)+"\n"+
//                getResources().getString(R.string.kategori_tubuh)+": "+kategori+"\n"+
//                getResources().getString(R.string.kebutuhan_kalori)+": "+kalori+"\n"+
//                getResources().getString(R.string.hitung_bla)+"\n"+
//                getResources().getString(R.string.app_link);
//        return result;
//    }

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

