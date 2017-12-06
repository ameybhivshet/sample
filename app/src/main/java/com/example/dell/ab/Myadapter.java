package com.example.dell.ab;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dell on 11/28/2017.
 */

public class Myadapter extends BaseAdapter {
   Context context;
  ArrayList<Datamapper> arrayList;
String data,index;

Datamapper datamapper;
    LayoutInflater inflater;

public Myadapter(Context context, ArrayList<Datamapper> arrayList)

    {
this.arrayList=arrayList;
       // this.data=dataarray;
        this.context=context;


        Log.d("holder",""+data);
    }





    @Override
    public int getCount() {
        return arrayList.size() ;
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }



   public class Viewholder
   {
      TextView textdisplay;
      TextView index;
    }






    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

View v=view;
        Viewholder holder;


    if (v == null) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.listdisplay, viewGroup, false);
        holder = new Viewholder();

        holder.textdisplay = v.findViewById(R.id.texttobedisplayedinlistview);
        holder.index = v.findViewById(R.id.indextext);


        v.setTag(holder);
    } else {
        holder = (Viewholder) v.getTag();
    }


    //  else
    // {
    //    textView=v.findViewById(R.id.texttobedisplayedinlistview);
    // }


        datamapper=arrayList.get(i);

       data= datamapper.getdata();
    index=datamapper.getindex();


    holder.index.setText("" + index);
    holder.textdisplay.setText("" + data);
        Log.d("holderdata", "" + data);
        Log.d("holderdata", "" + index);
    Log.d("holderdata", "" + arrayList.get(i));
    return v;
}





}
