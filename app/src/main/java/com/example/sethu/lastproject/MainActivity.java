package com.example.sethu.lastproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;
    String s1,s2;
    DATABASE database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.login);
        b2=(Button)findViewById(R.id.register);
        e1=(EditText)findViewById(R.id.username);
        e2=(EditText)findViewById(R.id.password);

        database=new DATABASE(this);
        database.getWritableDatabase();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                Cursor cur=database.logdata(s1);
                if (cur.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(),"invalid username",Toast.LENGTH_LONG).show();
                }
                else
                {
                    while (cur.moveToNext())
                    {
                        String id=cur.getString(0);
                        String name=cur.getString(1);
                       String dbpassword=cur.getString(5);
                        if (dbpassword.equals(s2))
                        {
                            SharedPreferences.Editor editor=getSharedPreferences("Mydata",MODE_PRIVATE).edit();
                            editor.putString("name",name);
                            editor.apply();

                            Intent i=new Intent(getApplicationContext(),Welcome.class);
                            startActivity(i);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"wrong password",Toast.LENGTH_LONG).show();
                        }
                    }

                }





            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e=new Intent(getApplication(),REGISTER.class);
                startActivity(e);

            }
        });
    }

}
