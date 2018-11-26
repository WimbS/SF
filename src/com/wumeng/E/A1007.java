package com.wumeng.E;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.management.RuntimeErrorException;
//平面最近点对的问题(平面几何)
//分治思想
//最近点对问题：给定平面上的N个点，找出距离最近的两个点。分治法：
//             1 ）如果数组长度(即点的个数，一般≤3)在一定范围内时直接求出最近点，蛮力求解，递归退出条件；
//             2）求出这些点的X坐标的中位数mid
//             3）以mid为界将所有点分为两组，分表放在表T1、T2中
//             4）将T1、T2表转换为数组S1、S2，并将S1、S2分别按X坐标升序排列
//             5）求S1中的点的最近距离
//             6） 求S2中点的最近距离
//             7）求4、5中的两距离的最小值，记为d1
//             8）在S1、S2中搜集距离中线(x=mid)小于d1的点，分别存放于表T3、T4中
//             9）将表T3、T4转换为数组类型S3、S4，并将S3、S4分别按Y坐标升序排列
//             10）求S3、S4两者之间可能的最近距离(与d1作比较)

public class A1007 {
	
	public static Node[] closestNode(Node[] s){
		
		Node []result = new Node[2];
		
		double dpmin = Integer.MIN_VALUE;
		double tmpmin = Integer.MAX_VALUE;
		
		if(s.length<=20){
			for(int i=0;i<s.length;i++){
				for(int j=i+1;j<s.length;j++){
					tmpmin = Math.sqrt(Math.pow(s[i].getX()-s[j].getX(),2)+Math.pow(s[i].getY()-s[j].getY(),2));
					if(tmpmin < dpmin){
						result[0] = s[i];
						result[1] = s[j];
					}
				}
			}
			return result;
		}
		
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		for(int i=0;i<s.length;i++){
			if(minX>s[i].getX()){
				minX = s[i].getX();
			}
		}
		
		for(int i=0;i<s.length;i++){
			if(maxX<s[i].getX()){
				maxX = s[i].getX();
			}
		}
		
		int midX = (minX+maxX)/2;
		
		ArrayList <Node>list1 = new ArrayList<Node>();
		ArrayList <Node>list2 = new ArrayList<Node>();
		for(int i=0;i<s.length;i++){
			if(i<=midX){
				list1.add(s[i]);
			}
			if(i>midX){
				list2.add(s[i]);
			}
		}
		
		Node [] S1 = new Node[list1.size()];
		Node [] S2 = new Node[list2.size()];
		
		list1.toArray();
		list2.toArray();
		
		mergeSort(S1,"x");
		mergeSort(S2,"x");
		
		Node[] result1 = new Node[2];
		result1 = closestNode(S1);
		
		Node[] result2 = new Node[2];
		result2 = closestNode(S2);
		
		double d1 = Math.sqrt(Math.min(Math.pow(result1[0].getX() - result1[1].getX(), 2) + Math.pow(result1[0].getY() - result1[1].getY(), 2), 
				Math.pow(result2[0].getX() - result2[1].getX(), 2) + Math.pow(result2[0].getY() - result2[1].getY(), 2)));
		
		if(Math.pow(result1[0].getX() - result1[1].getX(), 2) + Math.pow(result1[0].getY() - result1[1].getY(), 2) < 
				Math.pow(result2[0].getX() - result2[1].getX(), 2) + Math.pow(result2[0].getY() - result2[1].getY(), 2))
			result = result1;
		else
			result = result2;

		ArrayList T3 = new ArrayList();
		ArrayList T4 = new ArrayList();
		for(int i = 0; i < S1.length; i++){
			if(midX - S1[i].getX() < d1)
				T3.add(S1[i]);
		}
		for(int i = 0; i < S2.length; i++){
			if(S2[i].getX() - midX < d1){
				T4.add(S2[i]);
			}
		}
		
		Node [] S3 = new Node [T3.size()];
		Node [] S4 = new Node [T4.size()];
		T3.toArray(S3);
		T4.toArray(S4);
		
		mergeSort(S3, "y");
		mergeSort(S4, "y");
	
		
		double d =  Double.POSITIVE_INFINITY;
		for(int i = 0; i < S3.length; i ++){
			for(int j = 0; j < S4.length; j ++){
				if(Math.abs(S3[i].getY() - S4[j].getY()) < d1){
					double tmp = Math.sqrt(Math.pow(S3[i].getX() - S4[j].getX(), 2) + Math.pow(S3[i].getY() - S4[j].getY(), 2));
					if(tmp < d){
						d = tmp;
						result[0] = S3[i];
						result[1] = S4[j];
					}
				} 
			}
		}
		
		return result;
	}

	private static void mergeSort(Node[] list1, String property) {
		// TODO Auto-generated method stub
		Node []tmp = new Node[list1.length];
		mergeSort(list1,tmp,0,list1.length-1,property);
	}

	private static void mergeSort(Node[]list1,Node[]tmp,int left,int right,String property) {
		// TODO Auto-generated method stub
		if(left < right){
			int center = (left+right)/2;
			mergeSort(list1,tmp,left,center,property);
			mergeSort(list1,tmp,center+1,right,property);
			merge(list1,tmp,left,center+1,right,property);
		}
	}

	private static void merge(Node[] list1, Node[] tmp, int leftPos, int rightPos, int rightEnd, String property) {
		// TODO Auto-generated method stub
		int leftEnd = rightPos - 1;
		int numofElements = rightEnd - leftPos +1;
		int tmpPos = leftPos;
		
		while(leftPos <= leftEnd&&rightPos <= rightEnd){
			if(property.equals("x")){
				if(list1[leftPos].getX() <= list1[rightPos].getX()){
					tmp[tmpPos++] = list1[leftPos++];
				}else{
					tmp[tmpPos++] = list1[rightPos++];
				}
				
			}else if(property.equals("y")){
				if(list1[leftPos].getY() <= list1[rightPos].getY())
					tmp[tmpPos++] = list1[leftPos++];
				else
					tmp[tmpPos++] = list1[rightPos++];
			}else{
				  throw new RuntimeException();
			}
			
			
			
			while(leftPos <= leftPos){
				tmp[tmpPos++] = list1[leftPos++];
			}
			
			while(rightPos <= rightEnd){
				tmp[tmpPos++] = list1[rightPos++];
			}
			

			//将排好序的段落拷贝到原数组中
			System.arraycopy(tmp, rightEnd-numofElements+1, list1, rightEnd-numofElements+1, numofElements);
		}
	}
	
public static void main(String[] args) {
		
		Set<Node> testData = new TreeSet<Node>();
		
		Random random = new Random();
		
		int x = 0;
		int y = 0;
		
		for(int i = 0;i < 50;i++){
			x = random.nextInt(500);
			y = random.nextInt(500);
			System.out.println("x:" + x + "  y:" + y);
			testData.add(new Node(x, y));
		}
		
		Node [] S = new Node[testData.size()];
		S = (Node[]) testData.toArray(S);
		
		for(int i = 0; i < S.length; i ++){
			System.out.println("(" + S[i].getX() + ", " + S[i].getY() + ")");
		}
		
		System.out.println(testData.size());
		
		Node [] result = new Node [2];
		
		result = closestNode(S);
		
		System.out.println("最近的两点分别是(" + result[0].getX() + ", " + result[0].getY() 
				+ ") 和 (" + result[1].getX() + ", " + result[1].getY() + "), 最近距离为：" 
				+ Math.sqrt(Math.pow(result[0].getX() - result[1].getX(), 2) + Math.pow(result[0].getY() - result[1].getY(), 2)));
		
	}


}



class Node implements Cloneable,Comparable<Node>{
	private int x;
	private int y;
	public Node(){
		x=0;
		y=0;
	}
	public Node(int x,int y){
		this.x = x;
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	
	@Override
	public int compareTo(Node o){
		if(x==o.getX()&&y==o.getY()){
			return 0;
		}else{
			return 1;
		}
	}
}