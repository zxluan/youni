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
	public static final String DB_NAME="youni1";//数据库名字
//	private static final int VERSION=1;//数据库版本
	private static  Younidb younidb;
	public String picture = "pic";
	private SQLiteDatabase db;
//	private String[] col = { "id", "pic" }; 
	//将构造方法私有化
	private Younidb(Context context){
		search_DatabaseHelper dbHelper=new search_DatabaseHelper(context,DB_NAME,null,3);
		db=dbHelper.getWritableDatabase();
	}
	//获取Younidb的实例
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
	//从数据库读取捐赠的详细信息等
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
	//从数据库读取捐赠的详细信息等
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
	/**创建数据**/  
//	public Long createData(Bitmap bmp) {  
//		ContentValues initValues = new ContentValues();  
//		Long id = null;  
//		ByteArrayOutputStream os = new ByteArrayOutputStream();  
//		/** 
//		* Bitmap.CompressFormat.JPEG 和 Bitmap.CompressFormat.PNG 
//		* JPEG 与 PNG 的是区别在于 JPEG是有损数据图像，PNG使用从LZ77派生的无损数据压缩算法。 
//		* 这里建议使用PNG格式保存 
//		* 100 表示的是质量为100%。当然，也可以改变成你所需要的百分比质量。 
//		* os 是定义的字节输出流 
//		*  
//		* .compress() 方法是将Bitmap压缩成指定格式和质量的输出流 
//		*/  
//		bmp.compress(Bitmap.CompressFormat.PNG, 100, os);  
//		  
//		initValues.put(picture, os.toByteArray());//以字节形式保存  
//		  
//	//	SQLiteDatabase db = getDatabaseWrit();  
//		id = db.insert("search_out", null, initValues);//保存数据  
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
//		Cursor cursor = db.query("search_out", col, null, null, null, null, null);//数据的查询  
//		HashMap<String, Object> bindData = null;  
//		list = new ArrayList<Map<String, Object>>();  
//			for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {  
//				bindData = new HashMap<String, Object>();  
//				bindData.put("id", cursor.getLong(0));  
//				/**得到Bitmap字节数据**/  
//				byte[] in = cursor.getBlob(1);  
//				/** 
//				* 根据Bitmap字节数据转换成 Bitmap对象 
//				* BitmapFactory.decodeByteArray() 方法对字节数据，从0到字节的长进行解码，生成Bitmap对像。 
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
//		db.delete("search_out", null, null);//数据的删除  
//		db.close();  
//	//	Log.i("search_out", "delete all data.");  
//	}  

	
	


}
