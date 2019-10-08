package com.e.a.sharedpreferences_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    SharedPreferences sharedPreferences;

    private EditText et_name_MA, et_email_MA, et_mobile_number_MA;
    private TextView tv_name_MA, tv_email_MA, tv_mobileNumber_MA;
    private Button bt_save_MA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        init();
        setListener();
        setData();
    }

    private void setListener() {
        bt_save_MA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = et_name_MA.getText().toString();
                String email = et_email_MA.getText().toString();
                String mobile = et_mobile_number_MA.getText().toString();


                if (name.isEmpty()) {
                    et_name_MA.setError("Enter name");
                } else if (email.isEmpty()) {
                    et_email_MA.setError("Enter the Email");
                } else if (mobile.isEmpty()) {
                    et_mobile_number_MA.setError("Enter the Mobile number");
                }else {

                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString(Name, name);
                    editor.putString(Email, email);
                    editor.putString(Phone, mobile);
                    editor.apply();

                    Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                    setData();
                }

            }
        });
    }

    public void setData() {
        String name_s = sharedPreferences.getString(Name, null);
        String email_s = sharedPreferences.getString(Email, null);
        String mobile_s = sharedPreferences.getString(Phone, null);

        tv_name_MA.setText(name_s);
        tv_email_MA.setText(email_s);
        tv_mobileNumber_MA.setText(mobile_s);
    }


    public void next_Activity(View view) {


        Intent intent = new Intent(MainActivity.this, Next_Activity.class);
        startActivity(intent);
    }

    private void init() {
        tv_name_MA = findViewById(R.id.tv_name_MA_id);
        tv_email_MA = findViewById(R.id.tv_email_MA_id);
        tv_mobileNumber_MA = findViewById(R.id.tv_mobilenumber_MA_id);
        et_name_MA = findViewById(R.id.et_name_MA_id);
        et_email_MA = findViewById(R.id.et_email_MA_id);
        et_mobile_number_MA = findViewById(R.id.et_mobilenumber_MA_id);
        bt_save_MA = findViewById(R.id.bt_save_MA_id);
    }

}
