package com.wimb.C;

import java.util.*;

public class A3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(1);
		ListNode p4 = new ListNode(4);
		ListNode p5 = new ListNode(5);
		ListNode p6 = new ListNode(6);
		p1.next = p2;

		p3.next = p4;
		p4.next = p5;
		p5.next = p6;


		A3 a3 = new A3();
		ListNode pp = a3.plusAB(p1, p3);

		if(pp==null)
			System.out.print(0);
		while(pp.next!=null){
			System.out.print(pp.val);
			pp = pp.next;
		}
	}
	//Á´±í°æA+B
	public ListNode plusAB(ListNode a, ListNode b) {
		ListNode sum = new ListNode(-1);
		ListNode current = sum;
		int flag = 0;
		while(a!=null || b!=null || flag!=0){
			int vala = (a==null?0:a.val);
			int valb = (b==null?0:b.val);

			int c_sum = vala+valb+flag;
			flag = c_sum/10;
			c_sum = c_sum%10;

			current.next = new ListNode(c_sum);
			current = current.next;  

			a = (a!=null?a.next:null);
			b = (b!=null?b.next:null);
		}
		return sum.next;
	}
	//ÅÐ¶Ï»ØÎÄ
	public boolean isPalindrome(ListNode pHead) {
		// write code here
		Stack <ListNode>stack = new Stack<ListNode>();
		ListNode p = pHead;
		while(p != null){
			stack.push(p);
			p = p.next;
		}		
		while(!stack.isEmpty()){
			ListNode now = stack.pop();
			if(now.val != pHead.val){
				return false;
			}	
			pHead = pHead.next;
		}		
		return true;
	}
	//¼¯ºÏÕ»
	public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
		// write code here
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> currentArray = new ArrayList<Integer>(size);
		list.add(currentArray);
		for(int i=0;i<ope.length;i++){
			switch(ope[i][0]){
			//push
			case 1:
				if(currentArray.size()!=size){
					currentArray.add(ope[i][1]);
				}else{
					currentArray = new ArrayList<Integer>(size);
					list.add(currentArray);
					currentArray.add(ope[i][1]);					
				}
				break;
				//pop
			case 2:
				if(currentArray.size()!=0){
					currentArray.remove(currentArray.size()-1);
				}else{
					list.remove(list.size()-1);
					currentArray = list.get(list.size()-1);
					currentArray.remove(currentArray.size()-1);
				}
				break;
			}

		}
		return list;
	}
	
	//Ë«Õ»ÅÅÐò
	public ArrayList<Integer> twoStacksSort(int[] numbers) {
		// write code here
		ArrayList <Integer>list = new ArrayList<Integer>();
		
		return list;
	}
}
