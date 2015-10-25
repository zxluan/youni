package com.example.myinterface;

import java.util.ArrayList;
import java.util.List;

import model.Search_out;
import model.User;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.example.sqlite.Younidb;
import com.example.sqlite.search_reason;
import com.example.zz.R;
import com.example.zz.first_inside_Adapter;

public class MyFollow extends Activity{
	private ListView listView;
    private Younidb younidb;
    private search_reason sr;
	private List<String>dataList=new ArrayList<String>();
	private List<Search_out> searchoutList;
	private List<Search_out> searchoutList2;
	private List<firstinside> firstinsideList=new ArrayList<firstinside>();
	private first_inside_Adapter adapter;
	private SharedPreferences getname;
//	private Context context;
	private String name;
	private firstinside info;
	private String to;
	public  final static String SER_KEY = "com.tutor.objecttran.ser"; 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_follow);
		listView=(ListView)findViewById(R.id.follow);
		getname=getSharedPreferences("user",MODE_PRIVATE);
		name=getname.getString("name", "");
		firstinsideList.clear();
		lode("name",name);
        adapter = new first_inside_Adapter(MyFollow.this,R.layout.first_inside,firstinsideList); //适配器的绑定
		listView.setAdapter(adapter); 
		listView.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				info= firstinsideList.get(position);
				to=info.getDetailed();
				Search_out search_out1 = new Search_out();  
				search_out1.setDetailed(to); 
				Intent intent = new Intent();  
	            intent.setClass(MyFollow.this, detailed_information.class);
	            Bundle mBundle = new Bundle();  
		        mBundle.putSerializable(SER_KEY,search_out1);  
		        intent.putExtras(mBundle);
				startActivity(intent);
			}
	  });
			
	    }
	      private void lode(String hang,String container) {
				younidb=Younidb.getInstance(this);
				searchoutList=younidb.loadSearch_out(hang,container);
				// TODO Auto-generated method stub
				if(searchoutList.size()>0){
					dataList.clear();
					for(Search_out search_out:searchoutList){
						if(!search_out.getHistory().equals("")){
						    sr=new search_reason();
						    firstinsideList=sr.search_reson(searchoutList, dataList);
						}else{
							 Toast.makeText(getApplicationContext(), "无关注",
										Toast.LENGTH_SHORT).show();
						}
					}
				}
			}
	}