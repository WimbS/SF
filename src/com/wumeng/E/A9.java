package com.wumeng.E;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class A9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(true){
			int num = input.nextInt();
			if(num == 0)
				return ;
			HashMap <String,Integer> map = new HashMap<String,Integer>();
			for(int i=0;i<num;i++){
				String tmp = input.next();
				if(map.containsKey(tmp)){
					map.put(tmp, map.get(tmp)+1);
				}else{
					map.put(tmp, 1);
				}
			}                                      
			String maxKey = null;
			int value = 0 ;
			ArrayList list = new ArrayList();
			Iterator ite = map.entrySet().iterator();
			while(ite.hasNext()){
				Map.Entry entry =(Map.Entry)ite.next();
				value = Integer.parseInt(entry.getValue().toString());
				list.add(entry.getValue());
				Collections.sort(list);          
				if(value == Integer.parseInt(list.get(list.size()-1).toString())){
					maxKey = entry.getKey().toString();
				}
			}
			
			System.out.println(maxKey);
		}
	}
}


