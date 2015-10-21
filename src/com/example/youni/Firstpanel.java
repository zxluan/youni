package com.example.youni;

import java.util.ArrayList;
import java.util.List;

import model.Search_out;

import com.example.sqlite.Younidb;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
//import android.graphics.drawable.BitmapDrawable;
//import android.graphics.drawable.Drawable;
import android.os.Bundle;
//import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
//import android.widget.ImageView;
import android.widget.ListView;


public class Firstpanel extends Activity{
	private Younidb younidb;
	public  final static String SER_KEY = "com.tutor.objecttran.ser"; 
	private List<String>dataList=new ArrayList<String>();
	private List<Search_out> searchoutList;
	private List<firstinside> firstinsideList=new ArrayList<firstinside>();
	private firstinside info;
	private String to;
//	private String base64;
//	private byte bytes[];
//	private ImageView firstshow;
//	private Bitmap bitmap;
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_layout);
		initfirstinsides();
		first_inside_Adapter adapter=new first_inside_Adapter(Firstpanel.this,R.layout.first_inside,firstinsideList);
		ListView listView =(ListView)findViewById(R.id.detailed_view);
//		firstshow=(ImageView)findViewById(R.id.show);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				info= firstinsideList.get(position);
				to=info.getDetailed();
//				younidb.loadSearch_out(detailed, to);
				Search_out search_out1 = new Search_out();  
				search_out1.setDetailed(to); 
				Intent intent=new Intent (Firstpanel.this,detailed_information.class);
//		        Intent mIntent = new Intent(this,ObjectTranDemo1.class);  
		        Bundle mBundle = new Bundle();  
		        mBundle.putSerializable(SER_KEY,search_out1);  
		        intent.putExtras(mBundle);  
				startActivity(intent);
				
			}
			
		});
		Button me=(Button)findViewById(R.id.me);
		me.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Firstpanel.this,com.example.myinterface.me.class);
				startActivity(intent);
			}
			
		});
		Button search=(Button)findViewById(R.id.search);
		search.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Firstpanel.this,com.example.search.searchpanel.class);
				startActivity(intent);
			}
			
		});
		Button public1=(Button)findViewById(R.id.publish);
		public1.setOnClickListener(new OnClickListener(){
            @Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Firstpanel.this,com.example.donation.public_panel.class);
				startActivity(intent);
			}
			
		});
		Button donation=(Button)findViewById(R.id.donation);
		donation.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Firstpanel.this,com.example.donation.juanzi.class);
				startActivity(intent);
			}
			
		});
	}
	private void initfirstinsides() {
		younidb=Younidb.getInstance(this);
		searchoutList=younidb.loadSearch_out();
		// TODO Auto-generated method stub
		if(searchoutList.size()>0){
			dataList.clear();
			for(Search_out search_out:searchoutList){
				dataList.add(search_out.getName());
				Bitmap bmp = BitmapFactory.decodeByteArray(search_out.getPic(), 0, search_out.getPic().length); //用BitmapFactory生成bitmap
//			    firstshow.setImageBitmap(bmp);  
//				Drawable fshow =new BitmapDrawable(bmp);
				firstinside fi1=new firstinside(search_out.getName(),bmp,search_out.getDetailed()+search_out.getTime());
				firstinsideList.add(fi1);
				
			}
		}
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
//		menu.add(0, 1, 1, "刷新");
		}
	public boolean onOptionsItemSelected(MenuItem item){
			switch (item.getItemId()){
			case R.id.action_settings:
				firstinsideList.clear();
		        initfirstinsides();
		        first_inside_Adapter adapter=new first_inside_Adapter(Firstpanel.this,R.layout.first_inside,firstinsideList);
				ListView listView =(ListView)findViewById(R.id.detailed_view);
				listView.setAdapter(adapter);
		        break;
		    default:
		    	break;
			}
			return super.onOptionsItemSelected(item);
	}
	

}
