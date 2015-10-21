package com.example.sqlite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyData extends SQLiteOpenHelper {
    public static final String CREATE_mydata ="create table mydata("
              +"user_name   text primary key, "
    		  +"user_phone  text NOT NULL, "
              +"user_email   text NOT NULL, "
    		  +"user_password text NOT NULL, "
              +"user_address  text NOT NULL)";
    public MyData(Context context,String name, CursorFactory factory,int version){
    	      super(context,name,factory,version);
    }
    
    public void onCreate(SQLiteDatabase db){
    	db.execSQL(CREATE_mydata);
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
    	
    }
}
