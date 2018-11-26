package com.wumeng.E;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class A2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int model = input.nextInt();
		HashMap <String,Integer>map = new HashMap<String,Integer>();
		while(m-->0){
			String str = input.next();
			int num = input.nextInt();
			map.put(str,num);
		}		
		ArrayList<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>();
		list.addAll(map.entrySet());
		ValueComparator1 vc = new ValueComparator1();
		Collections.sort(list,vc);
	}
	private static class ValueComparator1 implements Comparator<Map.Entry<String,Integer>>{
		public int compare(Map.Entry<String,Integer> m,Map.Entry<String,Integer> n){
			return n.getValue()-m.getValue();
		}
	}
	private static class ValueComparator11 implements Comparator<Map.Entry<String,Integer>>{
		public int compare(Map.Entry<String,Integer> m,Map.Entry<String,Integer> n){
			return m.getValue()-n.getValue();
		}
	}
}
