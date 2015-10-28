package com.example.myinterface;

import android.graphics.Bitmap;

public class firstinside {
       private String id;
       private Bitmap showpic;
       private String detailed;
       private String time;
       private String address;
       public firstinside(String id,Bitmap showpic,String detailed,String time,String address){
    	   this.detailed=detailed;
    	   this.id=id;
    	   this.showpic=showpic;
    	   this.time=time;
    	   this.address=address;
       }
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public Bitmap getShowpic() {
		return showpic;
	}
	public String getDetailed() {
		return detailed;
	}
       
}
