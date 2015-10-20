package com.example.youni;

//import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.List;

import com.example.sqlite.Younidb;

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
	private TextView time;
	private ImageView showp;
	private Younidb younidb;
	private List<Search_out> searchoutList;
	private List<String>dataList=new ArrayList<String>();
	  protected void onCreate(Bundle savedInstanceState){
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.detailed_infomation_layout);
		  id=(TextView)findViewById(R.id.detailed_id);
		  detailed=(TextView)findViewById(R.id.detailed_show);
		  showp=(ImageView)findViewById(R.id.showpict);
		  time=(TextView)findViewById(R.id.time_show);
		  Search_out search_out2 =(Search_out)getIntent().getSerializableExtra(Firstpanel.SER_KEY);
		  younidb=Younidb.getInstance(this);
		searchoutList=younidb.loadSearch_out("detailed",search_out2.getDetailed());
		// TODO Auto-generated method stub
		if(searchoutList.size()>0){
			dataList.clear();
			for(Search_out search_out:searchoutList){
				dataList.add(search_out.getName());
				Bitmap bmp = BitmapFactory.decodeByteArray(search_out.getPic(), 0, search_out.getPic().length); 
				showp.setImageBitmap(bmp);
				id.setText(search_out.getName());
		        detailed.setText(search_out.getDetailed());
		        time.setText(search_out.getTime());
			}
		}else{
			id.setText("нч");
			detailed.setText("нч");
		}
		  
		 
	  }
}
