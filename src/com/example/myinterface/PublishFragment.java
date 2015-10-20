package com.example.myinterface;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import model.Search_out;



//import com.example.myinterface.PersonFragment.NewButtonListener;
import com.example.sqlite.*;
//import com.example.youni.Firstpanel;
import com.example.zz.R;
//import com.example.zz.R.id;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;



public class PublishFragment extends Fragment {
//    private search_DatabaseHelper dbhelper;
    private Younidb younidb;
    private EditText editText;
    private EditText address;
    private static int i=1;
    private Uri imageUri;
    public static final int TAKE_PHOTO = 1;
    public static final int CROP_PHOTO = 2;
//	private static final int RESULT_OK = 1;
    private ImageView picture;
    private byte[] base64;
    @Override
    
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.publish, container, false);
        Button checkp=(Button)view.findViewById(R.id.button1);
        editText=(EditText)view.findViewById(R.id.editText2);
        ImageButton photo=(ImageButton)view.findViewById(R.id.imageButton1);
        address=(EditText)view.findViewById(R.id.editText3);
        picture=(ImageView)view.findViewById(R.id.takephoto);
        checkp.setOnClickListener(new NewButtonListener()); 
        photo.setOnClickListener(new photo());
//        EditText editText=(EditText)view.findViewById(R.id.editText2);
//        editText.setOnClickListener(new NewEditTextListener()); 
        return view; 
    }
    
    class photo implements OnClickListener{
		@Override
		public void onClick(View v) {
			File takepic = new File(Environment. getExternalStorageDirectory(), "tempImage"+i+".jpg");//获取图片，转化为File对象
			try {
				if (takepic.exists()) {
					takepic.delete();
				}
				takepic.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				}
				imageUri = Uri.fromFile(takepic);
				Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
				intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
				startActivityForResult(intent, Activity.DEFAULT_KEYS_DIALER); // 启动相机程序
				}
			}
public void onActivityResult(int requestCode, int resultCode, Intent data) {
	switch (requestCode) {
	case TAKE_PHOTO:
	if (resultCode ==  Activity.RESULT_OK) {
	Intent intent = new Intent("com.android.camera.action.CROP");
	intent.setDataAndType(imageUri, "image/*");
	intent.putExtra("scale", true);
	intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
	startActivityForResult(intent, CROP_PHOTO); // 启动裁剪程序
	}
	break;
	case CROP_PHOTO:
		if (resultCode ==  Activity.RESULT_OK) {
    		try {
    		Bitmap bitmap = BitmapFactory.decodeStream (getActivity().getContentResolver().openInputStream(imageUri));
    		ByteArrayOutputStream bos = new ByteArrayOutputStream();  
    	    try	{ 
    		     bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);  
    	         bos.close();  
    	     } catch (IOException e) {  
    	     e.printStackTrace();  
    	     }  
    	     base64=bos.toByteArray(); 
    		picture.setImageBitmap(bitmap); // 将裁剪后的照片显示出来
    		} 
    		catch (FileNotFoundException e) {
    		e.printStackTrace();
    		}
		}
			break;
		default:
			break;
	}
}
    
    
    class NewButtonListener implements OnClickListener{  
		   
        @Override  
        public void onClick(View arg0) {  
            // TODO Auto-generated method stub  
        	Search_out so=new Search_out();
			// editText的监听在上面  我不知道里面加的是什么内容  可以在这里新建一个EditText的监听  里面加连数据库内容
			String detailed=editText.getText().toString();
			String address1=address.getText().toString();
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy年MM月dd日HH时mm分", Locale.getDefault()); 
			Date curDate=new Date(System.currentTimeMillis());//获取当前时间
			String str=formatter.format(curDate);
			so.setDetailed(detailed);
			so.setName("LUAN");
			so.setTime(str);
			so.setPic(base64);
			so.setAddress(address1);
			younidb.saveSearch_out(so);
			editText.setText("");
			address.setText("");
        }  
          
    } 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        younidb=Younidb.getInstance(this.getActivity().getApplicationContext());
    }
}
