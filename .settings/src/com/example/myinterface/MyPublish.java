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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.myinterface.HomeFragment.ItemClickListener;
import com.example.sqlite.Younidb;
import com.example.zz.MainActivity;
import com.example.myinterface.detailed_information;
import com.example.myinterface.firstinside;
import com.example.zz.R;
import com.example.zz.first_inside_Adapter;

public class MyPublish extends Activity{
	private Younidb younidb;
	private List<String>dataList=new ArrayList<String>();
	private List<Search_out> searchoutList;
	private List<firstinside> firstinsideList=new ArrayList<firstinside>();
    private User user;
    private ListView listView;
	private first_inside_Adapter adapter;
	private SharedPreferences getname;
	private Context context;
	private String name;
	private firstinside info;
	private String to;
	public  final static String SER_KEY = "com.tutor.objecttran.ser"; 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_publish);
		listView =(ListView)findViewById(R.id.listView1); //在我的发布的ListView的获取实例
		getname=getSharedPreferences("user",MODE_PRIVATE);
		name=getname.getString("name", "");
		firstinsideList.clear();
		lode("name",name);
        adapter = new first_inside_Adapter(MyPublish.this,R.layout.first_inside,firstinsideList); //适配器的绑定
		listView.setAdapter(adapter); 
		listView.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				info= firstinsideList.get(position);
				to=info.getDetailed();
				Search_out search_out1 = new Search_out();  
				search_out1.setDetailed(to); 
				Intent intent = new Intent();  
	            intent.setClass(MyPublish.this, detailed_information.class);
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
				dataList.add(search_out.getName());
				Bitmap bmp = BitmapFactory.decodeByteArray(search_out.getPic(), 0, search_out.getPic().length); //用BitmapFactory生成bitmap
				firstinside fi1=new firstinside(search_out.getName(),bmp,search_out.getDetailed()+search_out.getTime());
				firstinsideList.add(fi1);
			}
		}
	}
}
