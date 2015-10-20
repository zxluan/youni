package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class search_DatabaseHelper extends SQLiteOpenHelper{
	public static final String CREATE_SEARCH_OUT="Create table search_out("
<<<<<<< HEAD
           + "id integer primary key autoincrement ,"
		   + "name text,"
           + "detailed text,"
		   + "like text,"
           + "history text,"
           + "pic blob,"
		   + "address text,"
		   + "time text)";//Search_out��
	public static final String CREATE_SEARCH_NEED="Create table search_need("
	           + "id integer primary key autoincrement ,"
=======
           + "id integer primary key autoincrement, "
		   + "name text not null,"
           + "detailed text,"
		   + "like text,"
           + "history text,"
		   + "pic blob,"
		   + "address text,"
		   + "time text)";//Search_out��
	public static final String CREATE_SEARCH_NEED="Create table search_need("
	           + "id integer primary key autoincrement,"
>>>>>>> 1e0bdc461a22b6b38b9226a987b90cf5a7b32456
			   + "name text,"
	           + "detailed text,"
			   + "like text,"
	           + "history text,"
<<<<<<< HEAD
	           + "pic blob,"
			   + "address text,"
=======
			   + "pic blob,"
	           + "address text,"
>>>>>>> 1e0bdc461a22b6b38b9226a987b90cf5a7b32456
			   + "time text)";//Search_need��
	public search_DatabaseHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}//�����Ա����
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_SEARCH_OUT);
		db.execSQL(CREATE_SEARCH_NEED);
	}//����
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if exists search_out");
		db.execSQL("drop table if exists search_need");
		onCreate(db);
	}
	
}
