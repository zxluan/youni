package com.example.myinterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import model.Search_out;

import com.example.myinterface.PersonFragment.NewButtonListener;
import com.example.sqlite.*;
//import com.example.youni.Firstpanel;
import com.example.zz.R;
import com.example.zz.R.id;

import android.app.Activity;
import android.content.Intent;
//import android.content.Intent;
//import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.example.zz.R.layout;



public class PublishFragment extends Fragment {
//    private search_DatabaseHelper dbhelper;
    private Younidb younidb;
    @Override
    
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.publish, container, false);
        Button checkp=(Button)view.findViewById(R.id.button1);
        checkp.setOnClickListener(new NewButtonListener()); 
//        EditText editText=(EditText)view.findViewById(R.id.editText2);
//        editText.setOnClickListener(new NewEditTextListener()); 
        return view; 
    }
    
    
    
    class NewButtonListener implements OnClickListener{  
		   
        @Override  
        public void onClick(View arg0) {  
            // TODO Auto-generated method stub  
        	Search_out so=new Search_out();
			EditText editText=(EditText)findViewById(R.id.editText2);
			// editText的监听在上面  我不知道里面加的是什么内容  可以在这里新建一个EditText的监听  里面加连数据库内容
			String detailed=editText.getText().toString();
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy年MM月dd日HH时mm分", Locale.getDefault()); 
			Date curDate=new Date(System.currentTimeMillis());//获取当前时间
			String str=formatter.format(curDate);
			so.setDetailed(detailed);
			so.setName("LUAN");
			so.setTime(str);
			younidb.saveSearch_out(so);
        }  
          
    } 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.pubilsh);
       
//        dbhelper=new search_DatabaseHelper(this,"youni.db",null,1);
        younidb=Younidb.getInstance(this);
//        Button checkp=(Button)findViewById(R.id.button1);
//		checkp.setOnClickListener(new OnClickListener(){
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
////				SQLiteDatabase db=dbhelper.getWritableDatabase();
//				Search_out so=new Search_out();
//				EditText editText=(EditText)findViewById(R.id.editText2);
//				String detailed=editText.getText().toString();
//				SimpleDateFormat formatter=new SimpleDateFormat("yyyy年MM月dd日HH时mm分", Locale.getDefault()); 
//				Date curDate=new Date(System.currentTimeMillis());//获取当前时间
//				String str=formatter.format(curDate);
//				so.setDetailed(detailed);
//				so.setName("LUAN");
//				so.setTime(str);
//				younidb.saveSearch_out(so);
//			}
//			
//		});
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
