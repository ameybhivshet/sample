package com.example.dell.ab;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Dell on 11/28/2017.
 */

public class Activity2 extends AppCompatActivity {
    ListView listView;

    Myadapter adapter;
    ArrayList<Datamapper> arrayList=new ArrayList<Datamapper>();
    SQLiteDatabase sqLiteDatabase;
    SQLitehelper sqLitehelper = new SQLitehelper(this);
    Datamapper datamapper;
    String index,data;
    //public Activity2(String dataarray, Myadapter adapter) {
//this.dataarray=dataarray;
//this.myadapter=adapter;
//}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listactivity);
        listView = findViewById(R.id.listview);
        Log.d("am", " " + listView);
        //  dataarray=getIntent().getExtras().getString("data");


        sqLiteDatabase = sqLitehelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(sqLitehelper.TABLE_NAME, null, null, null, null, null, null);

        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                index = cursor.getString(0);
                data = cursor.getString(1);
                datamapper = new Datamapper(index, data);

                arrayList.add(datamapper);


                adapter = new Myadapter(this, arrayList);


                listView.setAdapter(adapter);
            }

        }

        cursor.close();
      sqLiteDatabase.close();

    }
}


