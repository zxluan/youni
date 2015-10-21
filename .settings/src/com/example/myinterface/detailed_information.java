package com.example.myinterface;

//import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.List;

import com.example.sqlite.Younidb;
import com.example.zz.R;
import com.example.zz.R.id;
import com.example.zz.R.layout;

import model.Search_out;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class detailed_information extends Activity {
	private TextView id;
	private TextView detailed;
	private ImageView pictures;
	private Younidb younidb;
	private List<Search_out> searchoutList;
	private List<String>dataList=new ArrayList<String>();
	  protected void onCreate(Bundle savedInstanceState){
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.detailed_infomation_layout);
		  pictures=(ImageView)findViewById(R.id.showpict);
		  id=(TextView)findViewById(R.id.detailed_id);
		  detailed=(TextView)findViewById(R.id.detailed_show);
		  Search_out search_out2 =(Search_out)getIntent().getSerializableExtra(HomeFragment.SER_KEY);
		  younidb=Younidb.getInstance(this);
		searchoutList=younidb.loadSearch_out("detailed",search_out2.getDetailed());
		// TODO Auto-generated method stub
		if(searchoutList.size()>0){
			dataList.clear();
			for(Search_out search_out:searchoutList){
				dataList.add(search_out.getName());
//				firstinside fi1=new firstinside(search_out.getName(),R.drawable.showpic,search_out.getDetailed());
//				firstinsideList.add(fi1);
				Bitmap bmp = BitmapFactory.decodeByteArray(search_out.getPic(), 0, search_out.getPic().length); //用BitmapFactory生成bitmap
				pictures.setImageBitmap(bmp);
				id.setText(search_out.getName());
		        detailed.setText(search_out.getDetailed());
		  
			}
		}else{
//			firstinside fi1=new firstinside("无",R.drawable.showpic,"无内容");
//			firstinsideList.add(fi1);
			id.setText("无");
			detailed.setText("无");
		}
		  
		 
	  }
}
