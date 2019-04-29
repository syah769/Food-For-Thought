package com.mobilemocap.ahmadriza.apik.DBHelper;

/**
 * Created by Ahmad Riza on 04/07/2017.
 */
import java.io.IOException;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.mobilemocap.ahmadriza.apik.Model.Makanan;

public class DataAdapter
{
    protected static final String TAG = "DataAdapter";
    private final String TABLE_NAME="Makanan";
    private final String KEY_ID ="id";
    private final String KEY_NAME ="nama";
    private final String KEY_KALORI ="kalori";
    private final String KEY_JENIS ="jenis";

    private final Context mContext;
    private SQLiteDatabase mDb;
    private DatabaseHelper mDatabaseHelper;



    public DataAdapter(Context context)
    {
        this.mContext = context;
        mDatabaseHelper = new DatabaseHelper(mContext);
    }

    public DataAdapter createDatabase() throws SQLException
    {
        try
        {
            Log.e(TAG,"creating db .......");
            mDatabaseHelper.createDataBase();
        }
        catch (IOException mIOException)
        {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public DataAdapter open() throws SQLException
    {
        try
        {
            mDatabaseHelper.openDataBase();
            mDatabaseHelper.close();
            mDb = mDatabaseHelper.getReadableDatabase();
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "open >>"+ mSQLException.toString());
            throw mSQLException;
        }
        Log.e(TAG,"success open");
        return this;
    }

    public void close()
    {
        mDatabaseHelper.close();
    }

    public ArrayList<Makanan> getAllMakanan(int jenis, String key){
        String where =" WHERE " + KEY_JENIS + "=" + jenis;
        if (!key.equals("")){
            where+=" AND "+KEY_NAME+" LIKE '%"+key+"%'";
        }

        String sql = "SELECT * FROM "+TABLE_NAME+where+" ORDER BY "+KEY_NAME+" ASC";

        try {
            Cursor cursor = mDb.rawQuery(sql,null);
            if (cursor==null) return null;

            ArrayList<Makanan> makananArrayList = new ArrayList<Makanan>();
            cursor.moveToFirst();
            do {
                int cId = cursor.getInt(0);
                String cNama = cursor.getString(1);
                int cJenis = cursor.getInt(2);
                double cKalori = cursor.getDouble(3);
                Makanan cMakanan = new Makanan(cId, cNama, cJenis, cKalori);
                makananArrayList.add(cMakanan);
            }while (cursor.moveToNext());
            return makananArrayList;
        }catch (Exception e){
            Log.e(TAG, "getTestData >>"+ e.toString());
            return null;
        }
    }

    /**
     * add new KaloriMakanan
     * @param newMakanan
     */
    public void addMakanan (Makanan newMakanan){
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,newMakanan.getNama());
        values.put(KEY_JENIS,newMakanan.getJenis());
        values.put(KEY_KALORI,newMakanan.getKalori());
        //insert row
        try {
            mDb.insert(TABLE_NAME,null,values);
        }catch (SQLException e){
            Log.e(TAG, "setTestData >>"+ e.toString());
            throw e;
        }
    }

}