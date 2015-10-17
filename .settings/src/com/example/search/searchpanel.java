package com.example.search;

import java.util.ArrayList;
import java.util.List;
import model.Search_out;
import com.example.sqlite.Younidb;
import com.example.youni.R;
import com.example.youni.first_inside_Adapter;
import com.example.youni.firstinside;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
//import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class searchpanel extends Activity {
    private Younidb younidb;
//    private String base64;
//	private byte[] bytes;
    private List<Search_out> searchoutList;
    private List<firstinside> firstinsideList=new ArrayList<firstinside>();
	private List<String>dataList=new ArrayList<String>();
	static String tab_field02 = "detailed";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		Button search=(Button)findViewById(R.id.button1);
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
			firstinsideList.clear();
			dataList.clear();
			for(Search_out search_out:searchoutList){
				dataList.add(search_out.getName());
//				base64=search_out.getPic();
//				bytes = Base64.decode(base64, Base64.DEFAULT);
				Bitmap bmp = BitmapFactory.decodeByteArray(search_out.getPic(), 0, search_out.getPic().length); //用BitmapFactory生成bitmap
				firstinside fi1=new firstinside(search_out.getName(),bmp,search_out.getDetailed()+search_out.getTime());
				firstinsideList.add(fi1);
			}
		}else{
			Bitmap bb=null;
			firstinside fi1=new firstinside("无",bb,"无内容");
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

