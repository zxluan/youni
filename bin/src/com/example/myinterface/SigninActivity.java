package com.example.myinterface;


import com.example.sqlite.MyDataDB;
import com.example.youni.R;

import model.User;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SigninActivity extends Activity  {
	private MyDataDB myDataDB;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signin);
		myDataDB=MyDataDB.getInstance(this);
		Button sign_in = (Button)findViewById(R.id.button1);
		sign_in.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText edit_name=(EditText)findViewById(R.id.register_name);
				String  get_name=edit_name.getText().toString();
				
				EditText edit_phone=(EditText)findViewById(R.id.register_phone);
				String  get_phone=edit_phone.getText().toString();
				
				EditText edit_email=(EditText)findViewById(R.id.register_email);
				String  get_email=edit_email.getText().toString();
				
				EditText edit_password=(EditText)findViewById(R.id.register_password);
				String  get_password=edit_password.getText().toString();
				
				EditText edit_address=(EditText)findViewById(R.id.register_address);
				String  get_address=edit_address.getText().toString();
				
				User user=new User();
				user.setUserName(get_name);
				user.setUserPhone(get_phone);
				user.setUserEmail(get_email);
				user.setUserPassword(get_password);
				user.setUserAddress(get_address);
				
				myDataDB.saveUser(user);
				
				Intent intent = new Intent();
				intent.setClass(SigninActivity.this, LoginActivity.class);
				startActivity(intent);
			}
		});
	}
}