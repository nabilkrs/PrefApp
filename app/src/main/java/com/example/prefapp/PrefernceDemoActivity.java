package com.example.prefapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class PrefernceDemoActivity extends Activity {
TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btnPrefs = (Button) findViewById(R.id.btnPrfs);
        Button btnGetPrefs = (Button) findViewById(R.id.btnGetPreferences);
        textView=(TextView)findViewById(R.id.txtPrefs);
        View.OnClickListener listener = new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.btnPrfs:
                        Intent intent = new Intent(PrefernceDemoActivity.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.btnGetPreferences:
                        displaySharedPreferences();
                        break;
                    default:break;
                }
            }
        };
        btnPrefs.setOnClickListener(listener);
        btnGetPrefs.setOnClickListener(listener);


    }
    private void displaySharedPreferences(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(PrefernceDemoActivity.this);
        String username=prefs.getString("username","Default NickName");
        String passw = prefs.getString("password","Default Password");
        boolean checkBox = prefs.getBoolean("checkBox",false);
        String listPrefs = prefs.getString("listpref","Default list prefs");
        StringBuilder builder = new StringBuilder();
        builder.append("Username : "+username+"\n");
        builder.append("Password : "+passw+"\n");
        builder.append("Keep me logged in: "+String.valueOf(checkBox)+"\n");
        builder.append("List preference:"+listPrefs);
        textView.setText(builder.toString());



    }


}
