package com.mobilemocap.ahmadriza.apik.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mobilemocap.ahmadriza.apik.Model.Makanan;
import com.mobilemocap.ahmadriza.apik.R;

import java.util.ArrayList;

/**
 * Created by Ahmad Riza on 03/07/2017.
 */

public class MakananAdapter extends ArrayAdapter<Makanan>{

    private static final String LOG_TAG = MakananAdapter.class.getSimpleName();

    public MakananAdapter(Activity context, ArrayList<Makanan> makanans) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, makanans);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check view

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.senarai_item, parent,false
            );
        }

        //get the link object at current position
        Makanan cMakanan = getItem(position);

        //find the textView
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.txtNama);
        //get name then set text
        nameTextView.setText(cMakanan.getNama());

        //then for no hp
        TextView kaloriTextView = (TextView) listItemView.findViewById(R.id.txtKalori);
        //get no then set text
        String kalori = String.valueOf(cMakanan.getKalori())+"/g";
        kaloriTextView.setText(kalori);
        return listItemView;
    }
}
