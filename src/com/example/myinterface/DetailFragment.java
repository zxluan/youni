package com.example.myinterface;

import java.util.ArrayList;
import java.util.List;

import model.Search_out;

import com.example.sqlite.Younidb;
import com.example.zz.MainActivity;
import com.example.zz.R;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {
	private TextView id;
	private TextView detailed;
	private Younidb younidb;
	private Context context;
	private List<String>dataList=new ArrayList<String>();
	private List<Search_out> searchoutList;
	@Override    
	public View onCreateView(LayoutInflater inflater, ViewGroup container,            
			Bundle savedInstanceState) {        
		View v = inflater.inflate(R.layout.detailed_infomation_layout, container, false);        
		id=(TextView)v.findViewById(R.id.detailed_id);
		detailed=(TextView)v.findViewById(R.id.detailed_show);
		
//这里获取到刚刚设置的参数~        
       Bundle b = this.getArguments();        
		String index = b.getString("detailed");   
		younidb=Younidb.getInstance(this.context);
		searchoutList=younidb.loadSearch_out("detailed",index);
		if(searchoutList.size()>0){
			dataList.clear();
			for(Search_out search_out:searchoutList){
				dataList.add(search_out.getName());
				id.setText(search_out.getName());
		  detailed.setText(search_out.getDetailed());
			}
		}else{
			id.setText("无");
			detailed.setText("无");
			}
		return v;    
		}
	public void onAttach(Activity activity) {        
		super.onAttach(activity);        
		this.context = (MainActivity)activity;    
		}
	}