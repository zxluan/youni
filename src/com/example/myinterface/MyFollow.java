package com.example.myinterface;

import java.util.ArrayList;
import java.util.List;

import model.Search_out;
import model.User;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.sqlite.Younidb;
import com.example.zz.R;
import com.example.zz.first_inside_Adapter;

public class MyFollow extends Activity{

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_follow);
	}
}