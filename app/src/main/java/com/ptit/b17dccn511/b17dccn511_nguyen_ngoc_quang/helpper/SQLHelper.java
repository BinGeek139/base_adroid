package com.ptit.b17dccn511.b17dccn511_nguyen_ngoc_quang.helpper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.ptit.b17dccn511.b17dccn511_nguyen_ngoc_quang.model.Model3_B17DCCN511;
import com.ptit.b17dccn511.b17dccn511_nguyen_ngoc_quang.model.Model4_B17DCCN511;

import java.util.ArrayList;
import java.util.List;

public class SQLHelper extends SQLiteOpenHelper  {
    private static final String DATABASE_NAME = "B17DCCN511_CSDL2.db";
    private static final int DATABASE_VERSION = 1;
    private static final String sql = "CREATE TABLE model3("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "text1 TEXT," +
            "text2 TEXT," +
            "text3 TEXT)";
    private static final  String sql1 = "CREATE TABLE model4("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "text1 TEXT," +
            "text2 TEXT," +
            "text3 TEXT," +
            "text4 TEXT)";
    private static final  String sql2 = "CREATE TABLE broker2("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "id1 INTEGER ,"+
            "id2 INTEGER )";


    public SQLHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
        db.execSQL(sql1);
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + "model3" + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + "model4" + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + "broker2" + "'");
        onCreate(db);
    }
    public void themModel3(Model3_B17DCCN511 data){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO model3(text1,text2,text3) VALUES(?,?,?)";
        String[] args = {
                String.valueOf(data.getText1()),
                String.valueOf(data.getText2()),
                String.valueOf(data.getText3())
        };
        database.execSQL(sql,args);
    }

    public List<Model3_B17DCCN511> getAll(){
        SQLiteDatabase database = getReadableDatabase();
        List<Model3_B17DCCN511> list = new ArrayList<>();
        Cursor cursor = database.query("model3",
                null,
                null,
                null,
                null, null, null);

        while (cursor != null && cursor.moveToNext()) {
            list.add(new Model3_B17DCCN511(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)));
        }
        if (cursor != null) cursor.close();
        return list;
    }
    public List<Model4_B17DCCN511> getAll2(){
        SQLiteDatabase database = getReadableDatabase();
        List<Model4_B17DCCN511> list = new ArrayList<>();
        Cursor cursor = database.query("model4",
                null,
                null,
                null,
                null, null, null);

        while (cursor != null && cursor.moveToNext()) {
            list.add(new Model4_B17DCCN511(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)));
        }
        if (cursor != null) cursor.close();
        return list;
    }
    public void themModel4(Model4_B17DCCN511 data){

        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO model4(text1,text2,text3,text3) VALUES(?,?,?,?)";
        String[] args = {
                String.valueOf(data.getText1()),
                String.valueOf(data.getText2()),
                String.valueOf(data.getText3()),
                String.valueOf(data.getText4())
        };
        database.execSQL(sql,args);
    }

    public void themModelBroker(Model4_B17DCCN511 data,Model3_B17DCCN511 data2){

        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO broker2(id1,id2) VALUES(?,?)";
        String[] args = {
                String.valueOf(data.getId()),
                String.valueOf(data2.getId())
        };
        database.execSQL(sql,args);
    }

    public List<Model4_B17DCCN511> getData(Model3_B17DCCN511 model){
        SQLiteDatabase database = getReadableDatabase();
        List<Model4_B17DCCN511> list = new ArrayList<>();
        Cursor cursor=database.rawQuery("Select * from model4 inner join broker2 on model4.id = broker2.id2 where id2 = "+model.getId(), null);
        while (cursor != null && cursor.moveToNext()) {
            list.add(new Model4_B17DCCN511(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)));
        }
        return list;



    }

    public List<Model4_B17DCCN511> thongke1(){
        SQLiteDatabase database = getReadableDatabase();
        List<Model4_B17DCCN511> list = new ArrayList<>();
        Cursor cursor = database.query("model4",
                null,
                null,
                null,
                null, null, null);

        while (cursor != null && cursor.moveToNext()) {
            list.add(new Model4_B17DCCN511(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)));
        }
        if (cursor != null) cursor.close();
        return list;
    }

    public List<Model4_B17DCCN511> thongKe2(){
        SQLiteDatabase database = getReadableDatabase();
        List<Model4_B17DCCN511> list = new ArrayList<>();
        Cursor cursor = database.query("model4",
                null,
                null,
                null,
                null, null, null);

        while (cursor != null && cursor.moveToNext()) {
            list.add(new Model4_B17DCCN511(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)));
        }
        if (cursor != null) cursor.close();
        return list;
    }
}
