package com.example.myinterface;

//import android.annotation.SuppressLint;
import java.io.ByteArrayOutputStream;
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
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class detailed_information extends Activity {
	private TextView id;
	private TextView time;
	private TextView address;
	private ImageView like;
	private TextView detailed;
	private ImageView pictures;
	private Younidb younidb;
	private List<Search_out> searchoutList;
	private List<String>dataList=new ArrayList<String>();
	private String d;
	private BitmapDrawable mDrawable;
	  protected void onCreate(Bundle savedInstanceState){
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.detailed_infomation_layout);
		  pictures=(ImageView)findViewById(R.id.showpict);
		  
		  like=(ImageView)findViewById(R.id.imageButton1);
		  id=(TextView)findViewById(R.id.detailed_id);
		  time=(TextView)findViewById(R.id.time_d);
		  address=(TextView)findViewById(R.id.address_d);
		  detailed=(TextView)findViewById(R.id.detailed_show);
		  like.setOnClickListener(new OnClickListener(){
			  public void onClick(View v) {
				  String de=detailed.getText().toString();
				  String n=id.getText().toString();
				  searchoutList=younidb.loadSearch_out("name",n);
				  if(searchoutList.size()>0){
						dataList.clear();
						for(Search_out search_out:searchoutList){
							dataList.add(search_out.getName());
							d=search_out.getHistory();
						}
				  younidb.changeSearch_out(d+de, n);
				  Toast.makeText(getApplicationContext(), "收藏成功",
							Toast.LENGTH_SHORT).show();
			      }
			  }
		  });
		  Search_out search_out2 =(Search_out)getIntent().getSerializableExtra(HomeFragment.SER_KEY);
		  younidb=Younidb.getInstance(this);
		searchoutList=younidb.loadSearch_out("detailed",search_out2.getDetailed());
		// TODO Auto-generated method stub
		if(searchoutList.size()>0){
			dataList.clear();
			for(Search_out search_out:searchoutList){
				dataList.add(search_out.getName());
				Bitmap bmp = BitmapFactory.decodeByteArray(search_out.getPic(), 0, search_out.getPic().length); //用BitmapFactory生成bitmap
				pictures.setImageBitmap(bmp);
				id.setText(search_out.getName());
		        detailed.setText(search_out.getDetailed());
		        time.setText(search_out.getTime());
		        address.setText(search_out.getAddress());
		        
			}
		}else{
			id.setText("无");
			detailed.setText("无");
		}
		  
		 
	  }
}
