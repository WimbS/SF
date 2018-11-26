package com.wumeng.D;

import java.util.Scanner;


//n的阶乘的最后一位
//线段树
//规律题
public class A1000 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
//		int a ;
//		int b;
//		while(scan.hasNext()){
//			a = scan.nextInt();
//			b = scan.nextInt();
//			System.out.println(a+b);
//		}
//		String a = scan.nextLine();
//		String []str = a.split(" ");
//		for(int i=0;i<str.length;i++){
//			
//		}
//		for(int i=0;i<5;i++){
//			System.out.println("走了"+i+"步");
//		}
		
//		StringBuffer sb = new StringBuffer();
//		int num = scan.nextInt();
//		int []a = new int[num];
//		for(int i=0;i<num;i++){
//			a[i] = scan.nextInt();
//		}
//		
//		for(int k:a){
//			System.out.print(k);
//		}
		
		//HashMap <String,Integer>map = new HashMap<String,Integer>();
		//for(int i=0;i<10;i++){
			//map.put("1",i);
		//}
		
		int n;
		while(scan.hasNext()){
			n = scan.nextInt();
			int num = 1;
			for(int i=1;i<=n;i++){
				num = num * (i%10);
				num = num%10;
			}
			System.out.println(num);
		}
		
	}
	
//	public ArrayList<ArrayList<TreeNode>> Print(ListNode pRoot){
//		
//	}
	
	public ListNode revearse(ListNode node){
		if(node == null)
			return node;
		ListNode pre =  null;
		ListNode now = node;
		while(now !=null){
			ListNode next = now.next;
			now.next = pre;
			pre = now;
			now = next;
		}
		return pre;
	}
	
	public int deep(TreeNode root){
		if(root == null)
			return 0;
		int left = deep(root.left);
		int right =deep(root.right);
		return left>right?(left+1):(right+1);
	}
	
	
	
	
}

class ListNode{
	ListNode next;
	int val;
	ListNode(int val){
		this.val = val;
	}
}

class TreeNode{
	TreeNode left;
	TreeNode right;
	int val;
	TreeNode(int val){
		this.val = val;
	}
}