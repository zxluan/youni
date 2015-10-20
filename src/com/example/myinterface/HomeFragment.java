package com.example.myinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Search_out;







//import com.example.myinterface.MeFragment.NewButtonListener;
import com.example.search.searchpanel;
import com.example.sqlite.Younidb;
//import com.example.youni.Firstpanel;
import com.example.zz.MainActivity;
//import com.example.youni.Firstpanel;
import com.example.zz.R;
import com.example.zz.first_inside_Adapter;
//import com.example.zz.R.drawable;
//import com.example.zz.R.id;
//import com.example.zz.R.layout;









import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
//import android.annotation.SuppressLint;
//import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
//import android.widget.SimpleAdapter;


public class HomeFragment extends Fragment {
	private Younidb younidb;
	private Context context;
	public  final static String SER_KEY = "com.tutor.objecttran.ser"; 
	private List<String>dataList=new ArrayList<String>();
	private List<Search_out> searchoutList;
	private List<firstinside> firstinsideList=new ArrayList<firstinside>();
	private firstinside info;
	private String to;
	private ListView listView;
	private first_inside_Adapter adapter;
	private String[] values = new String[] { "Item1","Item2","Item3","Item4" };  
	private int[] images = new int[] { R.drawable.showpic,  R.drawable.showpic, R.drawable.showpic,R.drawable.showpic }; 
    
	
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
        View view = inflater.inflate(R.layout.home, container, false);  
        Button button1 = (Button) view.findViewById(R.id.search);
        listView =(ListView) view.findViewById(R.id.detailed_view); 
        button1.setOnClickListener(new NewButtonListener()); 
        listView.setOnItemClickListener(new ItemClickListener()); 
        initfirstinsides();
        adapter = new first_inside_Adapter(getActivity(),R.layout.first_inside,firstinsideList); 
		listView.setAdapter(adapter); 
		setHasOptionsMenu(true);
        return view;  
	}
	
	  class NewButtonListener implements OnClickListener{  
		   
	        @Override  
	        public void onClick(View arg0) {  
	            // TODO Auto-generated method stub  
	        	Intent intent = new Intent();  
	            intent.setClass(getActivity(), searchpanel.class);  
	            getActivity().startActivity(intent); 
	        }  
	          
	    } 
	  
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
//		  List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();  
//	        for (int i = 0; i < values.length; i++) {  
//	            Map<String, Object> listItem = new HashMap<String, Object>();  
//	            listItem.put("values", values[i]);  
//	            listItem.put("images", images[i]);  
//	            listItems.add(listItem);  
//	        }  
		
//		listView.setOnItemClickListener(new OnItemClickListener()
	}
	class ItemClickListener implements OnItemClickListener{
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
//			// TODO Auto-generated method stub
			info= firstinsideList.get(position);
			to=info.getDetailed();
//		   younidb.loadSearch_out(detailed, to);
			Search_out search_out1 = new Search_out();  
			search_out1.setDetailed(to); 
//			((MainActivity)HomeFragment.this.context).showDetail(to);
			  
	        Intent intent = new Intent();  
            intent.setClass(getActivity(), detailed_information.class);  
            
	        Bundle mBundle = new Bundle();  
	        mBundle.putSerializable(SER_KEY,search_out1);  
	        intent.putExtras(mBundle);
			getActivity().startActivity(intent); 
		}
	}
	@Override    
	public void onAttach(Activity activity) {        
		super.onAttach(activity);        
		this.context = (MainActivity)activity;    
		}
	private void initfirstinsides() {
		younidb=Younidb.getInstance(this.context);
		searchoutList=younidb.loadSearch_out();
		// TODO Auto-generated method
		if(searchoutList.size()>0){
			dataList.clear();
			for(Search_out search_out:searchoutList){
				if(search_out.getPic().length >0){
				dataList.add(search_out.getName());
				Bitmap bmp = BitmapFactory.decodeByteArray(search_out.getPic(), 0, search_out.getPic().length); //用BitmapFactory生成bitmap
				firstinside fi1=new firstinside(search_out.getName(),bmp,search_out.getDetailed());
				firstinsideList.add(fi1);
				}else{
					Bitmap bb=null;
					firstinside fi1=new firstinside(search_out.getName(),bb,search_out.getDetailed());
					firstinsideList.add(fi1);
				}
			}
		}
	}

public boolean onCreateOptionsMenu(Menu menu) {
	
	// Inflate the menu; this adds items to the action bar if it is present.
	getActivity().getMenuInflater().inflate(R.menu.main, menu);
//	super.onCreateOptionsMenu(menu, inflater);
	return true;
//	menu.add(0, 1, 1, "刷新");
	}
public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()){
		case R.id.action_settings:
			firstinsideList.clear();
	        initfirstinsides();
	        first_inside_Adapter adapter=new first_inside_Adapter(getActivity(),R.layout.first_inside,firstinsideList);
//			ListView listView =(ListView)findViewById(R.id.detailed_view);
			listView.setAdapter(adapter);
	        break;
	    default:
	    	break;
		}
		return super.onOptionsItemSelected(item);
}


}

	


