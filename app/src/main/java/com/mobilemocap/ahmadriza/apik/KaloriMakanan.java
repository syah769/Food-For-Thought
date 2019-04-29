package com.mobilemocap.ahmadriza.apik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class KaloriMakanan extends AppCompatActivity {

    public final int KATEGORI_POKOK=0;
    public final int KATEGORI_LAUK=1;
    public final int KATEGORI_SAYUR=2;
    public final int KATEGORI_SIAP_SAJI =3;
    public final int KATEGORI_BUAH=4;
    public final int KATEGORI_MAKANAN_RINGAN=5;
    public final static  String TAG = KaloriMakanan.class.getSimpleName();
    double result;
    String [] nama;
    double[] kalori;
    int[] berat;

    TextView lblPokok;
    TextView lblLauk;
    TextView lblRingan;
    TextView lblSayur;
    TextView lblBuah;
    TextView lblSiapSaji;
    TextView lblKalori;
    EditText txtPokok;
    EditText txtLauk;
    EditText txtRingan;
    EditText txtSayur;
    EditText txtBuah;
    EditText txtSiapSaji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan);

        //init view
        lblPokok = (TextView)findViewById(R.id.lblPokok);
        lblLauk = (TextView)findViewById(R.id.lblLauk);
        lblRingan = (TextView)findViewById(R.id.lblRingan);
        lblBuah = (TextView)findViewById(R.id.lblBuah);
        lblSayur = (TextView)findViewById(R.id.lblSayur);
        lblSiapSaji = (TextView)findViewById(R.id.lblSiapSaji);
        lblKalori = (TextView)findViewById(R.id.lblKalori);
        txtPokok = (EditText) findViewById(R.id.txtPokok);
        txtLauk = (EditText) findViewById(R.id.txtLauk);
        txtRingan = (EditText) findViewById(R.id.txtRingan);
        txtBuah = (EditText) findViewById(R.id.txtBuah);
        txtSayur = (EditText) findViewById(R.id.txtSayur);
        txtSiapSaji = (EditText) findViewById(R.id.txtSiapSaji);


        berat = new int[SearchMakanan.ITEM_SUM];
        //get passed extra
        Bundle extras = getIntent().getExtras();
        if (extras==null){
            Log.e(TAG,"extra is null");
            this.kalori= new double[SearchMakanan.ITEM_SUM];
            this.nama = new String[SearchMakanan.ITEM_SUM];

            for (int i=0;i<nama.length;i++){
                nama[i]="";
            }
        }else {
            kalori=extras.getDoubleArray(SearchMakanan.KEY_KALORI);
            nama = extras.getStringArray(SearchMakanan.KEY_NAMA);
        }

        //setView
        updateView();

        //action listener
        lblPokok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SearchMakanan.class);
                Bundle extras = new Bundle();
                extras.putDoubleArray(SearchMakanan.KEY_KALORI,kalori);
                extras.putStringArray(SearchMakanan.KEY_NAMA,nama);
                extras.putInt("JENIS",KATEGORI_POKOK+1);
                i.putExtras(extras);
                startActivity(i);
            }
        });

        lblLauk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SearchMakanan.class);
                Bundle extras = new Bundle();
                extras.putDoubleArray(SearchMakanan.KEY_KALORI,kalori);
                extras.putStringArray(SearchMakanan.KEY_NAMA,nama);
                extras.putInt("JENIS",KATEGORI_LAUK+1);
                i.putExtras(extras);
                startActivity(i);
            }
        });

        lblBuah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SearchMakanan.class);
                Bundle extras = new Bundle();
                extras.putDoubleArray(SearchMakanan.KEY_KALORI,kalori);
                extras.putStringArray(SearchMakanan.KEY_NAMA,nama);
                extras.putInt("JENIS",KATEGORI_BUAH+1);
                i.putExtras(extras);
                startActivity(i);
            }
        });

        lblSayur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SearchMakanan.class);
                Bundle extras = new Bundle();
                extras.putDoubleArray(SearchMakanan.KEY_KALORI,kalori);
                extras.putStringArray(SearchMakanan.KEY_NAMA,nama);
                extras.putInt("JENIS",KATEGORI_SAYUR+1);
                i.putExtras(extras);
                startActivity(i);
            }
        });


        lblRingan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SearchMakanan.class);
                Bundle extras = new Bundle();
                extras.putDoubleArray(SearchMakanan.KEY_KALORI,kalori);
                extras.putStringArray(SearchMakanan.KEY_NAMA,nama);
                extras.putInt("JENIS",KATEGORI_MAKANAN_RINGAN+1);
                i.putExtras(extras);
                startActivity(i);
            }
        });


        lblSiapSaji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SearchMakanan.class);
                Bundle extras = new Bundle();
                extras.putDoubleArray(SearchMakanan.KEY_KALORI,kalori);
                extras.putStringArray(SearchMakanan.KEY_NAMA,nama);
                extras.putInt("JENIS", KATEGORI_SIAP_SAJI +1);
                i.putExtras(extras);
                startActivity(i);
            }
        });

        txtPokok.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateResult();
            }
        });
        txtLauk.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateResult();
            }
        });
        txtRingan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateResult();
            }
        });
        txtBuah.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateResult();
            }
        });
        txtSayur.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateResult();
            }
        });
        txtSiapSaji.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateResult();
            }
        });

    }

    private void updateView(){
        String tempNama ="";

        if ( !(tempNama=nama[KATEGORI_POKOK]).equals("") )lblPokok.setText(tempNama);
        if ( !(tempNama=nama[KATEGORI_LAUK]).equals("") )lblLauk.setText(tempNama);
        if ( !(tempNama=nama[KATEGORI_SAYUR]).equals("") )lblSayur.setText(tempNama);
        if ( !(tempNama=nama[KATEGORI_BUAH]).equals("") )lblBuah.setText(tempNama);
        if ( !(tempNama=nama[KATEGORI_MAKANAN_RINGAN]).equals("") )lblRingan.setText(tempNama);
        if ( !(tempNama=nama[KATEGORI_SIAP_SAJI]).equals("") ) lblSiapSaji.setText(tempNama);

    }

    private void updateResult(){
        //TODO FIX THIS
        String tempWeight="";
        if ( !(tempWeight=txtPokok.getText().toString()).equals("") )berat[KATEGORI_POKOK]=Integer.parseInt(tempWeight);
        if ( !(tempWeight=txtLauk.getText().toString()).equals("") )berat[KATEGORI_LAUK]=Integer.parseInt(tempWeight);
        if ( !(tempWeight=txtBuah.getText().toString()).equals("") )berat[KATEGORI_BUAH]=Integer.parseInt(tempWeight);
        if ( !(tempWeight=txtSayur.getText().toString()).equals("") )berat[KATEGORI_SAYUR]=Integer.parseInt(tempWeight);
        if ( !(tempWeight=txtRingan.getText().toString()).equals("") )berat[KATEGORI_MAKANAN_RINGAN]=Integer.parseInt(tempWeight);
        if ( !(tempWeight= txtSiapSaji.getText().toString()).equals("") )berat[KATEGORI_SIAP_SAJI]=Integer.parseInt(tempWeight);

        result = (
                          (kalori[KATEGORI_POKOK] * berat[KATEGORI_POKOK])
                        + (kalori[KATEGORI_LAUK] * berat[KATEGORI_LAUK])
                        + (kalori[KATEGORI_SAYUR] * berat[KATEGORI_SAYUR])
                        + (kalori[KATEGORI_BUAH] * berat[KATEGORI_BUAH])
                        + (kalori[KATEGORI_MAKANAN_RINGAN] * berat[KATEGORI_MAKANAN_RINGAN])
                        + (kalori[KATEGORI_SIAP_SAJI] * berat[KATEGORI_SIAP_SAJI])

                    );

        String resText = String.format("%.0f",result);
        lblKalori.setText(resText);
    }

}
