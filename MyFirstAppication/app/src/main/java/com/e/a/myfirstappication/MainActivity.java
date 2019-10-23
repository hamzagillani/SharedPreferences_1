package com.e.a.myfirstappication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        listen();

    }

    private void listen() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);



                Toast.makeText(MainActivity.this,"Click on the Button",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        button=findViewById(R.id.bt_chagne_background);
    }
}
