package com.example.youni;

import java.util.ArrayList;
import java.util.List;
//import com.example.myinterface.me;


//import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;


public class Firstpanel extends Activity{
	private List<firstinside> firstinsideList=new ArrayList<firstinside>();
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_layout);
		initfirstinsides();
		first_inside_Adapter adapter=new first_inside_Adapter(Firstpanel.this,R.layout.first_inside,firstinsideList);
		ListView listView =(ListView)findViewById(R.id.detailed_view);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				Intent intent=new Intent (Firstpanel.this,detailed_information.class);
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
		// TODO Auto-generated method stub
		firstinside fi1=new firstinside("luan1",R.drawable.showpic,"详细信息1");
		firstinsideList.add(fi1);
		firstinside fi2=new firstinside("luan2",R.drawable.showpic,"详细信息2");
		firstinsideList.add(fi2);
		firstinside fi3=new firstinside("luan3",R.drawable.showpic,"详细信息3");
		firstinsideList.add(fi3);
		firstinside fi4=new firstinside("luan4",R.drawable.showpic,"详细信息4");
		firstinsideList.add(fi4);
		firstinside fi5=new firstinside("luan5",R.drawable.showpic,"详细信息5");
		firstinsideList.add(fi5);
		firstinside fi6=new firstinside("luan6",R.drawable.showpic,"详细信息6");
		firstinsideList.add(fi6);
		firstinside fi7=new firstinside("luan7",R.drawable.showpic,"详细信息7");
		firstinsideList.add(fi7);
		firstinside fi8=new firstinside("luan8",R.drawable.showpic,"详细信息8");
		firstinsideList.add(fi8);
	}
	

}
