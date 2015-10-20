package com.example.sqlite;

//import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;



import model.Search_need;
import model.Search_out;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Younidb {
	public static final String DB_NAME="youni1";//���ݿ�����
//	private static final int VERSION=1;//���ݿ�汾
	private static  Younidb younidb;
	public String picture = "pic";
	private SQLiteDatabase db;
//	private String[] col = { "id", "pic" }; 
	//�����췽��˽�л�
	private Younidb(Context context){
		search_DatabaseHelper dbHelper=new search_DatabaseHelper(context,DB_NAME,null,3);
		db=dbHelper.getWritableDatabase();
	}
	//��ȡYounidb��ʵ��
	public synchronized static Younidb getInstance(Context context){
		if(younidb == null){
			younidb=new Younidb(context);
		}
		return younidb;
	}
	public void saveSearch_out(Search_out search_out){
		if(search_out!=null){
			ContentValues values=new ContentValues();
			values.put("name", search_out.getName());
			values.put("detailed", search_out.getDetailed());
			values.put("like", search_out.getLike());
			values.put("history", search_out.getHistory());
			values.put("time", search_out.getTime());
			values.put("pic", search_out.getPic());
			db.insert("search_out", null, values);
		}
	}
	//�����ݿ��ȡ��������ϸ��Ϣ��
	public List<Search_out> loadSearch_out(){
		List<Search_out> list =new ArrayList<Search_out>();
		Cursor cursor=db.query("Search_out", null, null, null, null, null, null);
		if(cursor.moveToFirst()){
			do{
				Search_out search_out=new Search_out();
				search_out.setId(cursor.getInt(cursor.getColumnIndex("id")));
				search_out.setName(cursor.getString(cursor.getColumnIndex("name")));
				search_out.setDetailed(cursor.getString(cursor.getColumnIndex("detailed")));
				search_out.setLike(cursor.getString(cursor.getColumnIndex("like")));
				search_out.setHistory(cursor.getString(cursor.getColumnIndex("history")));
				search_out.setTime(cursor.getString(cursor.getColumnIndex("time")));
				search_out.setPic(cursor.getBlob(cursor.getColumnIndex("pic")));
				list.add(search_out);
			}while(cursor.moveToNext());
		}
		
		return list;
		
	}
	public void saveSearch_need(Search_need search_need){
		if(search_need!=null){
			ContentValues values=new ContentValues();
			values.put("name", search_need.getName());
			values.put("detailed", search_need.getDetailed());
			values.put("like", search_need.getLike());
			values.put("history", search_need.getHistory());
			values.put("time", search_need.getTime());
			values.put("pic", search_need.getPic());
			db.insert("search_need", null, values);
		}
	}
	//�����ݿ��ȡ��������ϸ��Ϣ��
	public List<Search_need> loadSearch_need(){
		List<Search_need> list =new ArrayList<Search_need>();
		Cursor cursor=db.query("Search_need", null, null, null, null, null, null);
		if(cursor.moveToFirst()){
			do{
				Search_need search_need=new Search_need();
				search_need.setId(cursor.getInt(cursor.getColumnIndex("id")));
				search_need.setName(cursor.getString(cursor.getColumnIndex("name")));
				search_need.setDetailed(cursor.getString(cursor.getColumnIndex("detailed")));
				search_need.setLike(cursor.getString(cursor.getColumnIndex("like")));
				search_need.setHistory(cursor.getString(cursor.getColumnIndex("history")));
				search_need.setTime(cursor.getString(cursor.getColumnIndex("time")));
				search_need.setPic(cursor.getBlob(cursor.getColumnIndex("pic")));
				list.add(search_need);
			}while(cursor.moveToNext());
		}
		
		return list;
		
	}
	public List<Search_out> loadSearch_out(String h,String s){
		List<Search_out> list =new ArrayList<Search_out>();
		String sra="SELECT  * FROM "+"search_out" +" where "+h+" like '%"+s+"%'";
		Cursor cursor=db.rawQuery(sra, null);
		if(cursor.moveToFirst()){
			do{
				Search_out search_out=new Search_out();
//				 Bitmap bmp =BitmapFactory.decodeByteArray(data, 0, data.length);  
				search_out.setId(cursor.getInt(cursor.getColumnIndex("id")));
				search_out.setName(cursor.getString(cursor.getColumnIndex("name")));
				search_out.setDetailed(cursor.getString(cursor.getColumnIndex("detailed")));
				search_out.setLike(cursor.getString(cursor.getColumnIndex("like")));
				search_out.setHistory(cursor.getString(cursor.getColumnIndex("history")));
				search_out.setTime(cursor.getString(cursor.getColumnIndex("time")));
				search_out.setPic(cursor.getBlob(cursor.getColumnIndex("pic")));
				list.add(search_out);
			}while(cursor.moveToNext());
		}
		
		return list;
		
	}
	/**��������**/  
//	public Long createData(Bitmap bmp) {  
//		ContentValues initValues = new ContentValues();  
//		Long id = null;  
//		ByteArrayOutputStream os = new ByteArrayOutputStream();  
//		/** 
//		* Bitmap.CompressFormat.JPEG �� Bitmap.CompressFormat.PNG 
//		* JPEG �� PNG ������������ JPEG����������ͼ��PNGʹ�ô�LZ77��������������ѹ���㷨�� 
//		* ���ｨ��ʹ��PNG��ʽ���� 
//		* 100 ��ʾ��������Ϊ100%����Ȼ��Ҳ���Ըı��������Ҫ�İٷֱ������� 
//		* os �Ƕ�����ֽ������ 
//		*  
//		* .compress() �����ǽ�Bitmapѹ����ָ����ʽ������������� 
//		*/  
//		bmp.compress(Bitmap.CompressFormat.PNG, 100, os);  
//		  
//		initValues.put(picture, os.toByteArray());//���ֽ���ʽ����  
//		  
//	//	SQLiteDatabase db = getDatabaseWrit();  
//		id = db.insert("search_out", null, initValues);//��������  
//		db.close();  
//	//	Log.i("Image ", "create done.");  
//		return id;  
//	}  
//	  
//	public List<Map<String, Object>> getData() {  
//	  
//		List<Map<String, Object>> list = null;  
//		  
//	//	SQLiteDatabase db = getDatabaseRead();  
//		Cursor cursor = db.query("search_out", col, null, null, null, null, null);//���ݵĲ�ѯ  
//		HashMap<String, Object> bindData = null;  
//		list = new ArrayList<Map<String, Object>>();  
//			for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {  
//				bindData = new HashMap<String, Object>();  
//				bindData.put("id", cursor.getLong(0));  
//				/**�õ�Bitmap�ֽ�����**/  
//				byte[] in = cursor.getBlob(1);  
//				/** 
//				* ����Bitmap�ֽ�����ת���� Bitmap���� 
//				* BitmapFactory.decodeByteArray() �������ֽ����ݣ���0���ֽڵĳ����н��룬����Bitmap���� 
//				**/  
//				Bitmap bmpout = BitmapFactory.decodeByteArray(in, 0, in.length);  
//				bindData.put("pic", bmpout);  
//				  
//				list.add(bindData);  
//			}  
//		cursor.close();  
//		db.close();  
//	//	Log.i("Image ", "get a Bitmap.");  
//		return list;  
//	}  
//	  
//	public void delete() {  
//	//	SQLiteDatabase db = getDatabaseWrit();  
//		db.delete("search_out", null, null);//���ݵ�ɾ��  
//		db.close();  
//	//	Log.i("search_out", "delete all data.");  
//	}  

	
	


}
