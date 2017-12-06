package com.example.dell.ab;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 12/01/2017.
 */


public class Dialog_fragment extends DialogFragment implements View.OnClickListener {
    int width, height;
    int itemclick=-1;
    Spinner spinner;
    View rootView;

MainActivity mainActivity=new MainActivity();
    Button ok,exit;
    ArrayList<String> list;
    ArrayAdapter<String> arrayAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.dialog_fragment, container, false);
        getDialog().setTitle("SELECT INNINGS");

        setspinner();
        ok= rootView.findViewById(R.id.ok);
        exit= rootView.findViewById(R.id.exit);
        ok.setOnClickListener(this);
        exit.setOnClickListener(this);
        setCancelable(false);
        return rootView;

    }


    @SuppressLint("ResourceType")
    public void setspinner() {
        spinner = rootView.findViewById(R.id.spinner);
        list = new ArrayList<String>();
        list.add("1st innings only");
        list.add("2nd innings only");
        list.add("1st and 2nd innings");
        arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               Toast.makeText(getActivity(), ""+i, Toast.LENGTH_SHORT).show();
               itemclick=i;
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });




    }


    @Override
    public void onResume() {
        super.onResume();
        width = getResources().getDimensionPixelSize(R.dimen.width);
        height = getResources().getDimensionPixelSize(R.dimen.height);
        getDialog().getWindow().setLayout(width, height);
    }




    @Override
    public void onClick(View rootView) {
switch (rootView.getId())
{
    case R.id.exit:
        getActivity().finish();

        break;

    case R.id.ok:
if(itemclick==0){

}
else if(itemclick==1)
{

}
else if(itemclick==2)
{

    android.support.v4.app.FragmentManager fragmentManager=getFragmentManager();
    bothinning_fragment bothinning_fragment=new bothinning_fragment();

    bothinning_fragment.show(fragmentManager,"bothfrag");
}


        break;

}

   }}