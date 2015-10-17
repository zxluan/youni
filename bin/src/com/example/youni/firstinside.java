package com.example.youni;

import android.graphics.Bitmap;

public class firstinside {
       private String id;
       private Bitmap showpic;
       private String detailed;
       public firstinside(String id,Bitmap showpic,String detailed){
    	   this.detailed=detailed;
    	   this.id=id;
    	   this.showpic=showpic;
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
