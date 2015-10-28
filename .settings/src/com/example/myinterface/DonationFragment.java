package com.example.myinterface;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

//import com.example.myinterface.MyDialogFragment.NewButtonListener;
import com.example.zz.MainActivity;
import com.example.zz.R;




public class DonationFragment extends Fragment{
	private String how_money;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
        View view = inflater.inflate(R.layout.donation, container, false);  
        Button button1 = (Button) view.findViewById(R.id.button1);
        EditText money=(EditText)view.findViewById(R.id.editText3);
        how_money=money.getText().toString();
//        Button ok = (Button) view.findViewById(R.id.ok);
//        ok.setOnClickListener(new ok()); 
        button1.setOnClickListener(new NewButtonListener()); 
        return view;  
    }  

	
	 class NewButtonListener implements OnClickListener{  
		 public void onClick(View v) { 
			 if(how_money==null){
				 Toast.makeText(getActivity().getApplicationContext(), "«Î ‰»ÎΩ∂Ó",
							Toast.LENGTH_SHORT).show();
			 }else{
			 MyDialogFragment Dialog = new MyDialogFragment();  
		        Dialog.show(getFragmentManager(), "Dialog");  
			 }
		 }
	 }
//	 class ok implements OnClickListener{  
//		 public void onClick(View v) {  
//			    Intent intent = new Intent();  
//	            intent.setClass(getActivity(), MainActivity.class);  
//	            getActivity().startActivity(intent); 
//		 }
//	 }
}
