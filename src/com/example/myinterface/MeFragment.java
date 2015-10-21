package com.example.myinterface;


<<<<<<< HEAD

import java.util.ArrayList;
import java.util.List;

import model.Search_out;
import model.User;

import com.example.myinterface.HomeFragment.ItemClickListener;
import com.example.sqlite.Younidb;
import com.example.zz.MainActivity;
import com.example.zz.R;
import com.example.zz.first_inside_Adapter;
import com.example.zz.R.id;

import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup; 
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MeFragment extends Fragment {
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
    public TextView denglu;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me, container, false); 
        denglu=(TextView)view.findViewById(R.id.denglu);
        getname=getActivity().getSharedPreferences("user",Activity.MODE_PRIVATE);
		name=getname.getString("name", "");
//        user =(User) getActivity().getIntent().getSerializableExtra(HomeFragment.SER_KEY);
        setname(name);
		Button button1 = (Button) view.findViewById(R.id.button1);//登陆界面
        button1.setOnClickListener(new NewButtonListener()); 
        Button button2 = (Button) view.findViewById(R.id.button2);//我的发布 
        button2.setOnClickListener(new NewButtonListener()); 
        Button button3 = (Button) view.findViewById(R.id.Button01);//我的关注 
        button3.setOnClickListener(new NewButtonListener()); 
        Button button4 = (Button) view.findViewById(R.id.Button02);//我的捐赠
        button4.setOnClickListener(new NewButtonListener());
        return view; 
    }
    public void setname(String s){
    	if(s==null){
        	denglu.setText("你还没登录...");
        }else{
        	denglu.setText("你好,"+s);
        }
    }
    
	  class NewButtonListener implements OnClickListener{  
		   
		    public void onClick(View v) {  
		          
		          
		        switch (v.getId()) {  
		        case R.id.button1:  //登陆按钮
		        	Intent intent1 = new Intent();  
		            intent1.setClass(getActivity(), LoginActivity.class);  
		            getActivity().startActivity(intent1);  
		            break;  
		        case R.id.button2:  //我的发布
		        	Intent intent2 = new Intent();  
		            intent2.setClass(getActivity(), MyPublish.class);  
		            getActivity().startActivity(intent2); 
		            break;  
		        case R.id.Button01: //我的关注 
		        	Intent intent3 = new Intent();  
		            intent3.setClass(getActivity(), MyFollow.class);  
		            getActivity().startActivity(intent3); 
		            break;  
		        case R.id.Button02:  //我的捐赠
		        	Intent intent4 = new Intent();  
		            intent4.setClass(getActivity(), MyDonation.class);  
		            getActivity().startActivity(intent4); 
		            break;   
		            
		        }  
		          
		   
		    }
	  }
	//获得当前fragment的context
		@Override    
		public void onAttach(Activity activity) {        
			super.onAttach(activity);        
			this.context = (MainActivity)activity;    
			}
	  private void lode(String lie ,String container){
		  younidb=Younidb.getInstance(this.context);
			searchoutList=younidb.loadSearch_out(lie,container);//搜索数据库返回当前信息，存入List中
			// TODO Auto-generated method
			if(searchoutList.size()>0){
//				firstinsideList.clear();
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
	
=======
import com.example.tab.R;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MeFragment extends Fragment {
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
        View view= inflater.inflate(R.layout.me, container, false); 
       
        return view;  
    }  
	
	
	 
>>>>>>> 1e0bdc461a22b6b38b9226a987b90cf5a7b32456

}