package com.example.myinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Search_out;

import com.example.sqlite.Younidb;
import com.example.zz.MainActivity;
import com.example.zz.R;
import com.example.zz.first_inside_Adapter;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class showFragment extends Fragment {        
	private Context context;
	private firstinside info;
	private String to;
	private Younidb younidb;
	private List<String>dataList=new ArrayList<String>();
	private List<Search_out> searchoutList;
	private List<firstinside> firstinsideList=new ArrayList<firstinside>();
	@Override    
	public View onCreateView(LayoutInflater inflater, ViewGroup container,            
			Bundle savedInstanceState) {         
		View v = inflater.inflate(R.layout.first, container, false);        
		ListView listView = (ListView)v.findViewById(R.id.detailed_view);        
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();                
//		for (int i = 0; i < MyData.titleArray.length; i++) {            
//			HashMap<String, String> temp = new HashMap<String, String>();            
//			temp.put("title", MyData.titleArray[i]);            
//			list.add(temp); 
		initfirstinsides();
		listView.setOnItemClickListener(new ItemClickListener());        
		first_inside_Adapter adapter = new first_inside_Adapter(this.context,R.layout.first_inside,firstinsideList);  
	    listView.setAdapter(adapter); 
        return v;    
			}
	
	 
//设置监听器！！！！        

@Override   
public void onAttach(Activity activity) {        
	super.onAttach(activity);        
	this.context = (MainActivity)activity;    
	}    
//监听器！！！    
class ItemClickListener implements OnItemClickListener {       
	@Override        
	public void onItemClick(AdapterView<?> arg0, View arg1, int position,long arg3) {
		info= firstinsideList.get(position);
		to=info.getDetailed();
		//这里调用的是Activity里面的方法！！！ 
//	((MainActivity)showFragment.this.context).showDetail(to); 
	}
}
private void initfirstinsides() {
	younidb=Younidb.getInstance(this.context);
	searchoutList=younidb.loadSearch_out();
	// TODO Auto-generated method stub
	if(searchoutList.size()>0){
		dataList.clear();
		for(Search_out search_out:searchoutList){
			dataList.add(search_out.getName());
			firstinside fi1=new firstinside(search_out.getName(),R.drawable.showpic,search_out.getDetailed());
			firstinsideList.add(fi1);
			
		}
	}         
      
  }
}