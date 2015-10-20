package com.example.myinterface;


import com.example.tab.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup; 

public class publish extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View publish = inflater.inflate(R.layout.publish, container, false);
       
        return publish;
    }
}