package com.example.myinterface;

<<<<<<< HEAD
//import com.example.sqlite.Younidb;
import com.example.zz.R;

import android.os.Bundle;
import android.app.Activity;
//import android.view.Menu;

public class LoginActivity extends Activity {
//	private Younidb younidb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
//		younidb=Younidb.getInstance(this);
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
=======
import java.util.ArrayList;
import java.util.List;




import com.example.sqlite.MyDataDB;
import com.example.youni.R;

import model.User;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
        private MyDataDB myDataDB;
        private List<User> list=new ArrayList<User>();
        private List<String> dataList=new ArrayList<String>();
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
							intent.setClass(LoginActivity.this,me.class);
							startActivity(intent);
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
>>>>>>> 1e0bdc461a22b6b38b9226a987b90cf5a7b32456

}
