package com.example.sqlite;

import java.util.ArrayList;
import java.util.List;



import model.User;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MyDataDB {
        public static final String DB_NAME="my_data";
        public static final int VERSION =1;
        private static MyDataDB myDataDB;
        private SQLiteDatabase db;
        
        //构造方法私有化
        private MyDataDB(Context context){
           	MyData dbHelper =new MyData(context,DB_NAME,null,VERSION);
        	db =dbHelper.getWritableDatabase();
        }
        
        //获取MyDataDB实例
        public synchronized static MyDataDB getInstance(Context context){
        	if (myDataDB==null){
        		myDataDB=new MyDataDB(context);
        	}
        	 return myDataDB;
        }
       
        //将User实例存储到数据库
        public void saveUser(User user){
        	if (user !=null){
        		ContentValues values = new ContentValues();
        		values.put("user_name", user.getUserName());
        		values.put("user_phone",user.getUserPhone() );
        		values.put("user_email", user.getUserEmail());
        		values.put("user_password", user.getUserPassword());
        		values.put("user_address", user.getUserAddress());
        		db.insert("mydata", null, values);
        	}
        }
        //从数据库读取所有用户信息
        	public List<User> loadUsers(){
        		List<User> list=new ArrayList<User>();
        		Cursor cursor = db.query("mydata", null, null, null, null, null, null);
        		if(cursor.moveToFirst()){
        			do {
        				User user1=new User();
        				user1.setUserName(cursor.getString(cursor.getColumnIndex("user_name")));
        				user1.setUserPhone(cursor.getString(cursor.getColumnIndex("user_phone")));
        				user1.setUserEmail(cursor.getString(cursor.getColumnIndex("user_email")));
        				user1.setUserPassword(cursor.getString(cursor.getColumnIndex("user_password")));
        				user1.setUserAddress(cursor.getString(cursor.getColumnIndex("user_address")));
        				list.add(user1);
        			}while (cursor.moveToNext());
        		}
        		return list;
        	}
        }
        

