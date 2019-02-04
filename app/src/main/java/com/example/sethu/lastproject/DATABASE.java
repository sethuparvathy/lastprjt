package com.example.sethu.lastproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2/4/2019.
 */
public class DATABASE extends SQLiteOpenHelper {
    public static final String Dbname = "MyDb.db";
    public static final String Tablename = "Student";
    public static final String col1 = "id";
    public static final String col2 = "name";
    public static final String col3 = "email";
    public  static final  String col4="mobile";
    public static  final String  col5="username";
    public static final String col6="password";


    public DATABASE(Context context) {
        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table " + Tablename + "(" + col1 + " integer primary key autoincrement, " + col2 + " text," + col3 + " text,"+col4+" text,"+col5+" text,"+col6+" text)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "drop table if exists " + Tablename;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);


    }
    public boolean insertdata(String name,String email,String mobile,String username,String password)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,name);
        contentValues.put(col3,email);
        contentValues.put(col4,mobile);
        contentValues.put(col5,username);
        contentValues.put(col6,password);
        Long status=sqLiteDatabase.insert(Tablename,null,contentValues);
        if (status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }


    public Cursor logdata(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM " + Tablename + " WHERE " + col5 + "='" +username+ "'", null);
        return cur;
    }

}

