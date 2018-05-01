package com.goufaning.bysj.utils;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;


public class OutTopics {
	protected int[][] wordCountByTopicAndTerm;
	int K;
	int V;
	String I2WPath;
	
	public OutTopics(int[][] wordCountByTopicAndTerm, int K, int V, String I2WPath){
		this.wordCountByTopicAndTerm = wordCountByTopicAndTerm;
		this.K = K;
		this.V = V;
		this.I2WPath = I2WPath;
	}
	
	public void outTopics(){
		/**输出结果**/
		Map<String, String> mapW2I = new HashMap();
		try {
//			mapW2I = DataUtil.readWord2Int(I2WPath);
			mapW2I = DataUtil.readWord(I2WPath);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    
		for (int k = 0; k < K; k++) {
			System.out.println("==============================");
			System.out.print("Topic " + k + "\r\n");
			System.out.println("==============================");
//			Arrays.sort(wordCountByTopicAndTerm[k]);
			Map<String, Integer> map = new TreeMap<String, Integer>();
//			for (int w = V-1; w >= V - 10; w--)
//				System.out.println(mapW2I.get(w+"")+":"+wordCountByTopicAndTerm[k][w]);
			for (int w = 0; w < wordCountByTopicAndTerm[k].length; w++) {
				map.put(w+"", wordCountByTopicAndTerm[k][w]);
			}
			//这里将map.entrySet()转换成list
			List<Entry<String,Integer>> list = new ArrayList<Entry<String,Integer>>(map.entrySet());
			//然后通过比较器来实现排序
			Collections.sort(list,new Comparator<Entry<String,Integer>>() {
	        //降序排序
	        public int compare(Entry<String, Integer> o1,
	                Entry<String, Integer> o2) {
	            	return o2.getValue().compareTo(o1.getValue());
	        	}
			});
			int count = 0;
	  		for(Entry<String,Integer> mapping:list){
	  			count++;
		        System.out.println(mapW2I.get(mapping.getKey())+":"+mapping.getValue());
		        if(count > 20){
		        	break;
		        }
	  		}
		}
	}
	
	public void outTopics2(){
		/**输出结果**/
		List<String> vocab = null;
		try {
			vocab = DataUtil.readWord2(I2WPath);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    
		for (int k = 0; k < K; k++) {
			System.out.println("==============================");
			System.out.print("Topic " + k + "\r\n");
			System.out.println("==============================");
//			Arrays.sort(wordCountByTopicAndTerm[k]);
			Map<String, Integer> map = new TreeMap<String, Integer>();
//			for (int w = V-1; w >= V - 10; w--)
//				System.out.println(mapW2I.get(w+"")+":"+wordCountByTopicAndTerm[k][w]);
			for (int w = 0; w < wordCountByTopicAndTerm[k].length; w++) {
				map.put(w+"", wordCountByTopicAndTerm[k][w]);
			}
			//这里将map.entrySet()转换成list
			List<Entry<String,Integer>> list = new ArrayList<Entry<String,Integer>>(map.entrySet());
			//然后通过比较器来实现排序
			Collections.sort(list,new Comparator<Entry<String,Integer>>() {
	        //降序排序
	        public int compare(Entry<String, Integer> o1,
	                Entry<String, Integer> o2) {
	            	return o2.getValue().compareTo(o1.getValue());
	        	}
			});
			int count = 0;
	  		for(Entry<String,Integer> mapping:list){
	  			count++;
		        System.out.println(vocab.get(Integer.parseInt(mapping.getKey()))+":"+mapping.getValue());
		        if(count > 20){
		        	break;
		        }
	  		}
		}
	}
}

