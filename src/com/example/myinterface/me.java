package com.example.myinterface;

//import com.example.youni.Firstpanel;
import com.example.youni.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
//import android.view.Menu;
//import android.view.View;
//import android.view.View.OnClickListener;
import android.widget.Button;

public class me extends Activity {
    Button button =null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.me);
		button =(Button)findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent=new Intent(me.this,com.example.myinterface.LoginActivity.class);
				startActivity(intent);
			}
		});
	}

	//@Override
	//public boolean onCreateOptionsMenu(Menu menu) {
		/// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		//return true;
	//}

}
