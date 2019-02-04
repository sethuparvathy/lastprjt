package com.example.sethu.lastproject;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        t1=(TextView)findViewById(R.id.welcome);
        SharedPreferences sharedPreferences=getSharedPreferences("Mydata",MODE_PRIVATE);
        String name=sharedPreferences.getString("name",null);
        t1.setText("welcome "+name);
    }
}
