package com.example.dell.ab;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Dell on 12/05/2017.
 */

public class bothinning_fragment extends Dialog_fragment {

    int width, height;
    Button back;
    View rootview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview=inflater.inflate(R.layout.both_fragment,container,false);
        getDialog().setTitle("Match Data");
        back=rootview.findViewById(R.id.back);
        setCancelable(false);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Intent intent = new Intent(getActivity(), MainActivity.class);
                //startActivity(intent);
                android.support.v4.app.FragmentManager fragmentManager=getFragmentManager();
                Dialog_fragment dialogFragment=new Dialog_fragment();

                dialogFragment.show(fragmentManager,"selectfragment");
            }
        });
        return rootview;
    }



    @Override
    public void onResume() {
        super.onResume();
        width = getResources().getDimensionPixelSize(R.dimen.bwidth);
        height = getResources().getDimensionPixelSize(R.dimen.bheight);
        getDialog().getWindow().setLayout(width, height);
    }







}
