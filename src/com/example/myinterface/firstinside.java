package com.example.myinterface;

<<<<<<< HEAD
import android.graphics.Bitmap;

=======
<<<<<<< HEAD
import android.graphics.Bitmap;

public class firstinside {
       private String id;
       private Bitmap showpic;
       private String detailed;
       public firstinside(String id,Bitmap showpic,String detailed){
=======
>>>>>>> 064793302faf8e6eda077b63484d3b2cf6ee8a4b
public class firstinside {
       private String id;
       private Bitmap showpic;
       private String detailed;
<<<<<<< HEAD
       public firstinside(String id,Bitmap showpic,String detailed){
=======
       public firstinside(String id,int showpic,String detailed){
>>>>>>> 1e0bdc461a22b6b38b9226a987b90cf5a7b32456
>>>>>>> 064793302faf8e6eda077b63484d3b2cf6ee8a4b
    	   this.detailed=detailed;
    	   this.id=id;
    	   this.showpic=showpic;
       }
	public String getId() {
		return id;
	}
<<<<<<< HEAD
	public Bitmap getShowpic() {
=======
<<<<<<< HEAD
	public Bitmap getShowpic() {
=======
	public int getShowpic() {
>>>>>>> 1e0bdc461a22b6b38b9226a987b90cf5a7b32456
>>>>>>> 064793302faf8e6eda077b63484d3b2cf6ee8a4b
		return showpic;
	}
	public String getDetailed() {
		return detailed;
	}
       
}
