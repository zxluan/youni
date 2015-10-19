package com.example.myinterface;


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
	
	
	 

}