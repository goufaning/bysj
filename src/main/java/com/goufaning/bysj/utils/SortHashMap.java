package com.goufaning.bysj.utils;
import java.util.*;
import java.util.Map.Entry;

public class SortHashMap {
	
	//按值降序排列hashmap
	public static List<Entry<Integer,Double>> sortDescHM(HashMap map, final boolean bAsc){
		//这里将map.entrySet()转换成list
	    List<Entry<Integer,Double>> list = new ArrayList<Entry<Integer,Double>>(map.entrySet());
	    //然后通过比较器来实现排序
	    Collections.sort(list,new Comparator<Entry<Integer,Double>>() {
	      public int compare(Entry<Integer,Double> o1,
	              Entry<Integer,Double> o2) {
	    	  if(!bAsc){//降序排序
	    		  return o2.getValue().compareTo(o1.getValue());
	    	  }
	    	  return o1.getValue().compareTo(o2.getValue());//升序排序
	      }
	    });
	    return list;
	}
	
	//按值降序排列hashmap
	public static List<Entry<Integer,Float>> sortDescHMFloat(HashMap map, final boolean bAsc){
		//这里将map.entrySet()转换成list
	    List<Entry<Integer,Float>> list = new ArrayList<Entry<Integer,Float>>(map.entrySet());
	    //然后通过比较器来实现排序
	    Collections.sort(list,new Comparator<Entry<Integer,Float>>() {
	      public int compare(Entry<Integer,Float> o1,
	              Entry<Integer,Float> o2) {
	    	  if(!bAsc){//降序排序
	    		  return o2.getValue().compareTo(o1.getValue());
	    	  }
	    	  return o1.getValue().compareTo(o2.getValue());//升序排序
	      }
	    });
	    return list;
	}
	
	/**
	 * 按值排列hashmap
	 * @param map
	 * @param bAsc 是否升序
	 * @return
	 */
	public static List<Entry<String,Integer>> sortHM(HashMap<String,Integer> map, final boolean bAsc){
		//这里将map.entrySet()转换成list
	    List<Entry<String,Integer>> list = new ArrayList<Entry<String,Integer>>(map.entrySet());
	    //然后通过比较器来实现排序
	    Collections.sort(list,new Comparator<Entry<String,Integer>>() {
	      public int compare(Entry<String,Integer> o1,
	              Entry<String,Integer> o2) {
	    	  if(!bAsc){//降序排序
	    		  return o2.getValue().compareTo(o1.getValue());
	    	  }
	    	  return o1.getValue().compareTo(o2.getValue());//升序排序
	      }
	    });
	    return list;
	}
		
	//按值降序排列hashmap
	public static List<Entry<Integer,Integer>> sortDescIntHM(HashMap<Integer, Integer> map, final boolean bAsc){
		//这里将map.entrySet()转换成list
	    List<Entry<Integer,Integer>> list = new ArrayList<Entry<Integer,Integer>>(map.entrySet());
	    //然后通过比较器来实现排序
	    Collections.sort(list,new Comparator<Entry<Integer,Integer>>() {
	      public int compare(Entry<Integer,Integer> o1,
	              Entry<Integer,Integer> o2) {
	    	  if(!bAsc){//降序排序
	    		  return o2.getValue().compareTo(o1.getValue());
	    	  }
	    	  return o1.getValue().compareTo(o2.getValue());//升序排序
	      }
	    });
	    return list;
	}
}
