package com.originals.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button addbutton ,subbutton;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String counter = "counterKey";
    public static String TAG= "MainActivity";
    int getSavedValue;
    private TextView tv;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.text);
        addbutton = (Button) findViewById(R.id.add);
        subbutton = (Button) findViewById(R.id.sub);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        getSavedValue = sharedpreferences.getInt(counter, 0);
            tv.setText(" " + getSavedValue);

      Log.i(TAG, "getSavedValue: "+getSavedValue);



        addbutton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                increase();
                }
            });


        subbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            decrease();
            }
        });

}

    // increases value by 1
    public void  increase(){
        getSavedValue++;
        tv.setText(" " + getSavedValue);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(counter, getSavedValue);
        editor.apply();
    }
    // decrease value by 1
    public void  decrease(){
        getSavedValue--;
        tv.setText(" " + getSavedValue);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(counter, getSavedValue);
        editor.apply();
    }
}