package com.wumeng.E;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class A1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
//		BigInteger sum = new BigInteger("1");
//		while(input.hasNext()){
//			int num = input.nextInt();
//			for(long i=1;i<=num;i++){
//				sum = sum.multiply(i);
//			}
//			System.out.println(sum);
//		}
		
//		int n = input.nextInt();
//		HashMap <Integer,String>map = new HashMap<Integer,String>();
//		map.put(0, "zero");
//		map.put(1, "one");
//		map.put(2, "two");
//		map.put(3, "three");
//		map.put(4, "four");
//		map.put(5, "five");
//		map.put(6, "six");
//		map.put(7, "seven");
//		map.put(8, "eight");
//		map.put(9, "nine");
//		while(n-->0){
//			StringBuffer sb = new StringBuffer();
//			String now = input.next();
//			String str = String.valueOf(now);
//			for(int i=0;i<str.length();i++){
//				if('0'<=str.charAt(i)&&str.charAt(i)<='9'){
//					sb.append(map.get(Integer.parseInt(String.valueOf(str.charAt(i)))));
//				}
//				if(i<str.length()-1){
//					sb.append("-");
//				}else{
//					continue;
//				}
//			}
//			System.out.println(sb.toString());
//		}
//		while(input.hasNext()){
//			BigInteger num1 = input.nextBigInteger();
//			BigInteger num2 = input.nextBigInteger();
//			if(num1.compareTo(num2)>0){
//				System.out.println("1");
//			}
//		}
		while(input.hasNext()){
			BigInteger n = input.nextBigInteger();
			//BigInteger sum = getTac(n);
			//System.out.println(sum);
			BigInteger m = input.nextBigInteger();
			BigInteger sum = n.add(m);
			System.out.println(sum);
		}		
	}
	
	public static BigInteger getTac(BigInteger num){
		if(num.compareTo(new BigInteger("1")) <= 0){
			return new BigInteger("1");
		}
		return num.multiply(getTac(num.subtract(new BigInteger("1"))));
	}
}
