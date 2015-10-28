package com.example.myinterface;

//import com.example.myinterface.DonationFragment.NewButtonListener;
import com.example.zz.MainActivity;
import com.example.zz.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;



public class MyDialogFragment extends DialogFragment  
{  
  
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState)  
    {  
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);  
        View view = inflater.inflate(R.layout.dialog, container);  
//        Button button1 = (Button) view.findViewById(R.id.ok);
//        button1.setOnClickListener(new NewButtonListener()); 
        return view;  
    }  
  
    
//    class NewButtonListener implements OnClickListener{  
//		 public void onClick(View v) {  
//			    Intent intent = new Intent();  
//	            intent.setClass(getActivity(), MainActivity.class);  
//	            getActivity().startActivity(intent); 
//		 }
//	 }
}  