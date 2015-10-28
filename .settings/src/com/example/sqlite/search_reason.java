package com.example.sqlite;

import java.util.ArrayList;
import java.util.List;

import model.Search_out;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.myinterface.firstinside;

public class  search_reason {
      public List<firstinside> search_reson(List<Search_out> searchoutList,List<String>dataList){
    	  List<firstinside> firstinsideList=new ArrayList<firstinside>();
    	  if(searchoutList.size()>0){
  			dataList.clear();
  			for(Search_out search_out:searchoutList){
  				dataList.add(search_out.getName());
  				Bitmap bmp = BitmapFactory.decodeByteArray(search_out.getPic(), 0, search_out.getPic().length); //”√BitmapFactory…˙≥…bitmap
  				firstinside fi1=new firstinside(search_out.getName(),bmp,search_out.getDetailed(),search_out.getTime(),search_out.getAddress());
  				firstinsideList.add(fi1);
  			}
  		}
    	  return firstinsideList;
      }
}
