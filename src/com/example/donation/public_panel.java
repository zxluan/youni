package com.example.donation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import model.Search_out;

import com.example.sqlite.*;
//import com.example.youni.Firstpanel;
import com.example.youni.R;

import android.app.Activity;
//import android.content.Intent;
//import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;



public class public_panel extends Activity {
//    private search_DatabaseHelper dbhelper;
    private Younidb younidb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pubilc);
//        dbhelper=new search_DatabaseHelper(this,"youni.db",null,1);
        younidb=Younidb.getInstance(this);
        Button checkp=(Button)findViewById(R.id.button1);
		checkp.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				SQLiteDatabase db=dbhelper.getWritableDatabase();
				Search_out so=new Search_out();
				EditText editText=(EditText)findViewById(R.id.editText2);
				String detailed=editText.getText().toString();
				SimpleDateFormat formatter=new SimpleDateFormat("yyyy年MM月dd日HH时mm分", Locale.getDefault()); 
				Date curDate=new Date(System.currentTimeMillis());//获取当前时间
				String str=formatter.format(curDate);
				so.setDetailed(detailed);
				so.setName("LUAN");
				so.setTime(str);
				younidb.saveSearch_out(so);
			}
			
		});
    }

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//         Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//       / return true;
//    }

    //@Override
    //public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();
        //if (id == R.id.action_settings) {
            //return true;
       // }
      //  return super.onOptionsItemSelected(item);
   // }
}
