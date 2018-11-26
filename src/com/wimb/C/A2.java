package com.wimb.C;

public class A2 {

	public static void main(String[] args) {
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(2);
		ListNode p5 = new ListNode(3);
		ListNode p6 = new ListNode(1);
		p1.next = p2;
		p2.next = p3;
		
		p4.next = p5;
		p5.next = p6;
		ListNode ll = new A2().plusAB(p1, p4);
		while(ll != null){
			System.out.print(ll.val+" ");
		}
		}
	
	//删除当前只能访问的节点
	public boolean removeNode(ListNode pNode) {
		if(pNode.next == null)
			return false;
		pNode.val = pNode.next.val;
		pNode.next = pNode.next.next;
		return true;
	}
	public ListNode partition(ListNode pHead, int x) {
		if(pHead == null)
			return null;
		ListNode small = new ListNode(-1);
		ListNode large = new ListNode(-1);
		ListNode smallhead = small;
		ListNode largehead = large;
		while(pHead != null){
			if(pHead.val<x){
				small.next = pHead;
				small = small.next;
			}else{
				large.next = pHead;
				large = large.next;
			}
			pHead = pHead.next;
		}
		large.next = null;
		small.next = largehead.next;
		return smallhead.next;

	}
	//大数加法 - 链表
	public ListNode plusAB(ListNode a, ListNode b) {
		if(a == null&&b == null)
			return a;
		boolean flag = false;
		ListNode plushead =null;
		ListNode plus = plushead;
		while(a != null||b != null){
			int num1 = 0 ;
			int num2 = 0;
			if(a!=null){
				num1 = a.val;
			}else{
				num1 = 0;
			}
			
			if(b!=null){
				num2 = b.val;
			}else{
				num2 = 0;
			}
			int sum = num1 + num2 +(flag == true?1:0);
			if(sum >=10){
				flag = true;
				sum = sum/10;
			}else{
				flag = false;
			}

			if(plushead == null){
				plushead = new ListNode(sum);
			}else{
				plus.next = new ListNode(sum);
				plus = plus.next;
			}
		}
		if(flag == true){
			plus.next = new ListNode(1);
			plus = plus.next;
		}
		return plushead;
	}
	
	 public boolean isPalindrome(ListNode pHead) {
		 if(pHead == null)
			 return false;
		 ListNode p1 = pHead;
		 ListNode p2 = pHead;
		 while(p2!=null){
			 p1 = p1.next;
			 p2 = p2.next.next;
			 if(p1 == p2 )
				 return true;
		 }
		 return false;
	 }
	 
}
class ListNode{
	int val;
	ListNode next;
	public ListNode(int val){
		this.val = val;
	}
}
