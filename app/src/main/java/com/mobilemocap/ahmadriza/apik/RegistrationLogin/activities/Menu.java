package com.mobilemocap.ahmadriza.apik.RegistrationLogin.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import com.mobilemocap.ahmadriza.apik.CalculatorActivity;
import com.mobilemocap.ahmadriza.apik.ExerciseActivity;
import com.mobilemocap.ahmadriza.apik.KaloriMakanan;
import com.mobilemocap.ahmadriza.apik.R;
import com.mobilemocap.ahmadriza.apik.RegistrationLogin.fragments.HomeFragment;
import com.mobilemocap.ahmadriza.apik.Utama;

public class Menu extends AppCompatActivity {
    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);


        //set event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGrid){}

    private void setSingleEvent(GridLayout mainGrid) {
        //loop semua child item dari main grid
        for(int i = 0;i<mainGrid.getChildCount();i++)
        {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(finalI == 0) //open activity one
                    {
                        Intent intent = new Intent(Menu.this, Utama.class);
                        startActivity(intent);
                    }
                    else if (finalI == 1)  //open activity two
                    {
                        Intent intent = new Intent(Menu.this, KaloriMakanan.class);
                        startActivity(intent);
                    }
                    else if (finalI == 2)  //open activity three
                    {
                        Intent intent = new Intent(Menu.this, CalculatorActivity.class);
                        startActivity(intent);
                    }
                    else if (finalI == 3)  //open activity four
                    {
                        Intent intent = new Intent(Menu.this, ExerciseActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(Menu.this, "Please set activity", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
