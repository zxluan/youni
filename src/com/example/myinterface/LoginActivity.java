package com.example.myinterface;

//import com.example.sqlite.Younidb;
import java.util.ArrayList;
import java.util.List;

import model.User;

import com.example.sqlite.MyDataDB;
import com.example.zz.MainActivity;
import com.example.zz.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
//import android.view.Menu;
import android.content.Intent;
import android.content.SharedPreferences;

public class LoginActivity extends Activity {
	   private MyDataDB myDataDB;
       private List<User> list=new ArrayList<User>();
       private List<String> dataList=new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		Button button = (Button)findViewById(R.id.button2);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this, SigninActivity.class);
				startActivity(intent);
			}
		});
		
		myDataDB=MyDataDB.getInstance(this);
		
		Button login = (Button)findViewById(R.id.button1);
		login.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText user_name=(EditText)findViewById(R.id.editText2);
				String ususer_name=user_name.getText().toString();
				EditText user_password=(EditText)findViewById(R.id.editText3);
				String ususer_password=user_password.getText().toString();
				boolean flag=true;
				list=myDataDB.loadUsers();
				if(list.size()>0){
					dataList.clear();
					for(User user:list){
						dataList.add(user.getUserName());
						if((ususer_name.equals(user.getUserName()))&&(ususer_password.equals(user.getUserPassword()))){
							Intent intent = new Intent();
							intent.setClass(LoginActivity.this,MainActivity.class);
							startActivity(intent);
							SharedPreferences.Editor editor=getSharedPreferences("user",MODE_PRIVATE).edit();
							editor.putString("name",ususer_name);
							editor.commit();
							Toast.makeText(getApplicationContext(), "µÇÂ¼³É¹¦",
									Toast.LENGTH_SHORT).show();
							flag=false;
							}else{
								continue;
							}
					}
					if(flag==true){
					   Toast.makeText(getApplicationContext(), "µÇÂ¼Ê§°Ü£ºÃÜÂëÕË»§´íÎó",
										Toast.LENGTH_SHORT).show();
					}
				}
				
				
			}
		});
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

}
