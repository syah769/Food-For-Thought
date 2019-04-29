package com.mobilemocap.ahmadriza.apik;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.mobilemocap.ahmadriza.apik.Adapter.MakananAdapter;
import com.mobilemocap.ahmadriza.apik.DBHelper.DataAdapter;
import com.mobilemocap.ahmadriza.apik.Model.Makanan;

import java.util.ArrayList;

public class SearchMakanan extends AppCompatActivity {

    public static final int ITEM_SUM = 6;
    public static final String KEY_KALORI = "KALORI_TOTAL";
    public static final String KEY_NAMA = "NAMA_MAKANAN";

    ListView listMakanan;
    EditText txtSearch;

    double[] calories;
    String[] nama;

    DataAdapter db;
    ArrayList<Makanan> makananArrayList;
    MakananAdapter makananAdapter;
    String key ;
    int jenis;
    Bundle globalExtras;

    //var to add activity
    String newNama;
    double newKalori;
    public static final String KEY_NEW_NAMA="NEW_NAMA";
    public static final String KEY_NEW_KALORI="NEW_KALORI";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_makanan);

        listMakanan = (ListView)findViewById(R.id.listview_makanan);
        txtSearch = (EditText) findViewById(R.id.txtSearch);

        //get passed data
        globalExtras = getIntent().getExtras();
        jenis = globalExtras.getInt("JENIS",1);
        calories=globalExtras.getDoubleArray(KEY_KALORI);
        nama = globalExtras.getStringArray(KEY_NAMA);



//        DB init
        db = new DataAdapter(this);
        db.createDatabase();
        db.open();

        //get passed add activity data
        if ((newNama=globalExtras.getString(KEY_NEW_NAMA))!=null&&(newKalori=globalExtras.getDouble(KEY_NEW_KALORI))!=0.0){
            Makanan newMakanan = new Makanan(1,newNama,jenis,newKalori);
            db.addMakanan(newMakanan);//add new entry to database
        }

        //load list
        makananArrayList= db.getAllMakanan(jenis,"");


        if (makananArrayList!=null){
            makananAdapter = new MakananAdapter(this,makananArrayList);
            listMakanan.setAdapter(makananAdapter);
        }else{
            Log.e("LOAD","empty result!!");
            listMakanan.setAdapter(null);
        }


        /**
         * when searchbar diketik
         */
        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                makananArrayList = db.getAllMakanan(jenis,txtSearch.getText().toString());
                updateView();
            }
        });

        listMakanan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Makanan cMakanan = makananArrayList.get(position);
                Intent intent = new Intent(getApplicationContext(),KaloriMakanan.class);
                Bundle extras = new Bundle();

                calories[jenis-1]=cMakanan.getKalori();//getkalori dari item yg dipilih
                nama[jenis-1]=cMakanan.getNama();

                extras.putStringArray(KEY_NAMA,nama);
                extras.putDoubleArray(KEY_KALORI,calories);
                intent.putExtras(extras);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getApplicationContext(),AddMakanan.class);
                mIntent.putExtras(globalExtras);
                startActivity(mIntent);
            }
        });

    }

    public void updateView(){
        if (makananArrayList != null){
            makananAdapter = new MakananAdapter(this,makananArrayList);
            listMakanan.setAdapter(makananAdapter);
        }else{
            listMakanan.setAdapter(null);
            Log.e("LOAD","empty result!!");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

}
