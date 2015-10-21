package com.example.donation;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import model.Search_out;

import com.example.sqlite.*;
//import com.example.youni.Firstpanel;
import com.example.youni.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
//import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;



public class public_panel extends Activity {
    private Younidb younidb;
    private static int i=1;
    private Uri imageUri;
    public static final int TAKE_PHOTO = 1;
    public static final int CROP_PHOTO = 2;
    private ImageView picture;
    private byte[] base64;
//    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pubilc);
//        dbhelper=new search_DatabaseHelper(this,"youni.db",null,1);
        younidb=Younidb.getInstance(this);
        Button checkp=(Button)findViewById(R.id.button1);
		checkp.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				SQLiteDatabase db=dbhelper.getWritableDatabase();
				Search_out so=new Search_out();
				EditText editText=(EditText)findViewById(R.id.editText2);
				String detailed=editText.getText().toString();
				SimpleDateFormat formatter=new SimpleDateFormat("yyyy年MM月dd日HH时mm分", Locale.getDefault()); 
				Date curDate=new Date(System.currentTimeMillis());//获取当前时间
				String str=formatter.format(curDate);
				so.setDetailed(detailed);
				so.setName("LUAN");
				so.setTime(str);
				so.setPic(base64);
				younidb.saveSearch_out(so);
			}
			
		});
		ImageButton photo=(ImageButton)findViewById(R.id.imageButton1);
		picture=(ImageView)findViewById(R.id.takephoto);
		photo.setOnClickListener(new OnClickListener(){
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
				});
		}
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	switch (requestCode) {
    	case TAKE_PHOTO:
    	if (resultCode == RESULT_OK) {
    	Intent intent = new Intent("com.android.camera.action.CROP");
    	intent.setDataAndType(imageUri, "image/*");
    	intent.putExtra("scale", true);
    	intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
    	startActivityForResult(intent, CROP_PHOTO); // 启动裁剪程序
    	}
    	break;
    	case CROP_PHOTO:
    		if (resultCode == RESULT_OK) {
	    		try {
	    		Bitmap bitmap = BitmapFactory.decodeStream (getContentResolver().openInputStream(imageUri));
//	    		Search_out so=new Search_out();
//	    		ByteArrayOutputStream stream = new ByteArrayOutputStream();
//	    		bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream );
//	    	    byte bytes[] = stream.toByteArray();
//	    		base64 = Base64.encodeToString(bytes, Base64.DEFAULT);
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

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//         Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//       / return true;
//    }

    //@Override
    //public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();
        //if (id == R.id.action_settings) {
            //return true;
       // }
      //  return super.onOptionsItemSelected(item);
   // }
}
