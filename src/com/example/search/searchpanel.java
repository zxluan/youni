package com.example.search;
//import com.example.phone1.R;
//import com.example.phone1.search;

import java.util.ArrayList;
import java.util.List;

import model.Search_out;

import com.example.myinterface.detailed_information;
import com.example.myinterface.firstinside;
//import com.example.myinterface.HomeFragment.ItemClickListener;
import com.example.sqlite.Younidb;
//import com.example.youni.Firstpanel;
//import com.example.youni.detailed_information;
//import com.example.sqlite.Younidb;
//import com.example.sqlite.search_DatabaseHelper;
//import com.example.youni.Firstpanel;
//import com.example.youni.Firstpanel;
import com.example.zz.R;
import com.example.zz.first_inside_Adapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
//import android.content.Intent;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class searchpanel extends Activity {
    private Younidb younidb;
    public  final static String SER_KEY = "com.tutor.objecttran.ser"; 
    private ListView showsearch;
    private firstinside info;
	private String to;
//    private search_DatabaseHelper dbHelper;
    private List<Search_out> searchoutList;
    private List<firstinside> firstinsideList=new ArrayList<firstinside>();
	private List<String>dataList=new ArrayList<String>();
	static String tab_field02 = "detailed";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		Button search=(Button)findViewById(R.id.button1);
		showsearch=(ListView)findViewById(R.id.lv_server);
        showsearch.setOnItemClickListener(new OnItemClickListener(){
        	public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
        		info= firstinsideList.get(position);
				to=info.getDetailed();
//				younidb.loadSearch_out(detailed, to);
				Search_out search_out1 = new Search_out();  
				search_out1.setDetailed(to); 
				Intent intent=new Intent (searchpanel.this,detailed_information.class);
//		        Intent mIntent = new Intent(this,ObjectTranDemo1.class);  
		        Bundle mBundle = new Bundle();  
		        mBundle.putSerializable(SER_KEY,search_out1);  
		        intent.putExtras(mBundle);  
				startActivity(intent);
        	}
        });
		search.setOnClickListener(new OnClickListener(){
	    	public  void onClick(View v){
	    		initfirstinsides();
				first_inside_Adapter adapter=new first_inside_Adapter(searchpanel.this,R.layout.first_inside,firstinsideList);
	    		ListView listView =(ListView)findViewById(R.id.lv_server);
	    		listView.setAdapter(adapter);
			}
				
	    	
	    });

	}
	private void  initfirstinsides (){
		EditText editText=(EditText)findViewById(R.id.et_search);
		String search=editText.getText().toString();
		younidb=Younidb.getInstance(this);
		searchoutList=younidb.loadSearch_out(tab_field02,search);
		// TODO Auto-generated method stub
		if(searchoutList.size()>0){
			dataList.clear();
			for(Search_out search_out:searchoutList){
				dataList.add(search_out.getName());
				Bitmap bmp = BitmapFactory.decodeByteArray(search_out.getPic(), 0, search_out.getPic().length); //用BitmapFactory生成bitmap
				firstinside fi1=new firstinside(search_out.getName(),bmp,search_out.getDetailed(),search_out.getTime(),search_out.getAddress());
				firstinsideList.add(fi1);
			}
		}else{
			Bitmap bb=null;
			firstinside fi1=new firstinside("无",bb,"无内容","无内容","无内容");
			firstinsideList.add(fi1);
		}
	}

	//@Override
	//public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		//return true;
	//}

}

