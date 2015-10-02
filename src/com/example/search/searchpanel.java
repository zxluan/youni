package com.example.search;
//import com.example.phone1.R;
//import com.example.phone1.search;

import com.example.youni.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
//import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class searchpanel extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		Button search=(Button)findViewById(R.id.button1);
		search.setOnClickListener(new OnClickListener(){
	    	public  void onClick(View v){
	    		Intent intent = new Intent(searchpanel.this,search.class);
	    		startActivity(intent);
	    	}
	    });
	}

	//@Override
	//public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		//return true;
	//}

}

