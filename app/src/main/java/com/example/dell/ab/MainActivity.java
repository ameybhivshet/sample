package com.example.dell.ab;

import android.app.DialogFragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textView,count;
    Button a, b, c, d;
    String deleteelement;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
Intent intent;
int counter=0;
    String dataarray;
    SQLitehelper sqLitehelper;
    SQLiteDatabase database;

    Myadapter adapter;
ArrayList<String> arrayList=new ArrayList<String>();
    ArrayList<String> temparraylist=new ArrayList<String>();
    char overtext[] = new char[30];
    int i = -1;
;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        count = findViewById(R.id.count);

        sqLitehelper = new SQLitehelper(this);
        int version = sqLitehelper.getReadableDatabase().getVersion();
        sqLitehelper.onUpgrade(sqLitehelper.getReadableDatabase(), version, version + 1);

        Log.d("ver", "" + version);


        android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
        Dialog_fragment dialogFragment=new Dialog_fragment();

       dialogFragment.show(fragmentManager,"selectfragment");

    }


    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    public void a(View view) {
counter++;
        i++;
        overtext[i] = 'A';

        Log.d("zz"," "+textView);

        if (textView.getText().toString().isEmpty()) {


            textView.setText(" " + overtext[i]);

        } else {
            textView.setText("" + textView.getText().toString() + "," + overtext[i]);
        }
   count.setText(""+counter);

      endover();
    }

    public void b(View view) {
        i++;
        counter++;
        overtext[i] = 'B';
        if (textView.getText().toString().isEmpty()) {
            textView.setText("" + overtext[i]);

        } else {
            textView.setText("" + textView.getText().toString() + "," + overtext[i]);
        }
        count.setText(""+counter);

       endover();
    }

    public void c(View view) {
        i++;
        counter++;
        overtext[i] = 'C';
        if (textView.getText().toString().isEmpty()) {
            textView.setText("" + overtext[i]);

        } else {
            textView.setText("" + textView.getText().toString() + "," + overtext[i]);
        }
        count.setText(""+counter);

   endover();
    }


    public void d(View view) {
        i++;
        counter++;
        overtext[i] = 'D';
        if (textView.getText().toString().isEmpty()) {
            textView.setText("" + overtext[i]);

        } else {
            textView.setText("" + textView.getText().toString() + "," + overtext[i]);
        }
        count.setText(""+counter);

      endover();

    }


    public void undo(View view) {



        /* array initially -1

        if(i>=0)

        {

deleteelement=arary[i];


        i--;
        temp=textview.gettext().tostring().trim();
         texview.settext(temp.substring(0,temp.length()-2));
         texview.settext(array[0]);

         for(j=1;j<=i;j++)

         {
         textview.settext("" + textView.getText().toString() + ","+array[j]);


         }

}
if(deleteelement.contains("wk")
{

reduce wicket and overs

}
if(deleteelement.contains("0" )&&((!deleteelement.contains("wd")||(!deletement.contains("nb")))
{
reduce overs;
}
if(delete elelment.contains("1,2,3,4,5,6")&&((!deleteelement.contains("wd")||(!deletement.contains("nb")))
{
reduce overs,runs;
}
if(deleteelement.contains("wd")||deleteelement.contains("nb"))
{
if(deleteelement.contains("0,1,2,3,4,5,6")
reduce runs;
}


if(deleteelement=b,lb,p)
{
reduce overs,runss;

as good as normal runs
}



after every over there shld be a dialogfrgment that checks if you want to continue


if yes then endover code shld execute no that undo shld be allowed
but if balls=6 and click again dialog popup






*/


        if (i >= 0)

        {




                deleteelement = String.valueOf(overtext[i]);

                i--;
                counter--;

textView.setText("");

            for (int j = 0; j <= i; j++)

            {

                if(textView.getText().toString().isEmpty())
                {

                   textView.setText(""+overtext[j]);
               }
               else {
                    textView.setText("" + textView.getText().toString() + "," + overtext[j]);

                }
            }


        }
        count.setText(""+counter);




    }


    public void sh(View view)
    {


      //  Log.d("am"," "+textView);
     //   Log.d("am"," "+activity2.listView);



        intent = new Intent(this, Activity2.class);

        //intent.putExtra("db",database);
        startActivity(intent);




    }

public void endover()
{


    if(counter==6) {

        dataarray = textView.getText().toString();



        arrayList.add(dataarray);


//intent.putExtra("data",dataarray);

        database=sqLitehelper.getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(sqLitehelper.COLUMN_FIRST_NAME, String.valueOf(arrayList.get(0)));


        Log.d("sqldata",String.valueOf(arrayList.get(0)));
        database.insert(sqLitehelper.TABLE_NAME, null, contentValues);
        database.close();


       //intent.putExtra("array", arrayList);

arrayList.clear();
        counter=0;
        dataarray="";
        i=-1;
        textView.setText("" +dataarray);

    }

}


}