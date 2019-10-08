package com.e.a.sharedpreferences_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Next_Activity extends AppCompatActivity {

    private TextView tv_name_NA,tv_email_NA,tv_mobileNumber_NA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        inti();


    }

    private void inti(){

        tv_name_NA=findViewById(R.id.tv_name_NA_id);
        tv_email_NA=findViewById(R.id.tv_email_NA_id);
        tv_mobileNumber_NA=findViewById(R.id.tv_mobilenumber_NA_id);

        SharedPreferences sharedPreferences=getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        String name_st=sharedPreferences.getString(MainActivity.Name,null);
        String email_st=sharedPreferences.getString(MainActivity.Email,null);
        String phone_st=sharedPreferences.getString(MainActivity.Phone,null);
        tv_name_NA.setText(name_st);
        tv_email_NA.setText(email_st);
        tv_mobileNumber_NA.setText(phone_st);

    }
}
