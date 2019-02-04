package com.example.sethu.lastproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class REGISTER extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3,e4,e5;
    String s1,s2,s3,s4,s5;
    DATABASE database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        b1=(Button)findViewById(R.id.reg);
        b2=(Button)findViewById(R.id.backlogin);
        e1=(EditText)findViewById(R.id.name);
        e2=(EditText)findViewById(R.id.email);
        e3=(EditText)findViewById(R.id.mobile);
        e4=(EditText)findViewById(R.id.usn);
        e5=(EditText)findViewById(R.id.pswd);
        database=new DATABASE(this);
        database.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                s5=e5.getText().toString();
                Log.d("name",s1);
                Log.d("email",s2);
                Log.d("mobile",s3);
                Log.d("usn",s4);
                Log.d("pswd",s5);
                boolean status=database.insertdata(s1,s2,s3,s4,s5);
                if (status==true)
                {
                    Toast.makeText(getApplicationContext(),"registered",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                }


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });
    }
}
