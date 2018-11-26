package com.wimb.B;

import java.util.ArrayList;

public class A4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<ListNode> printCommon(ListNode p1,ListNode p2){
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		if(p1 == null||p2 == null)
			return list;
		while(p1!=null&&p2!=null){
			if(p1.val<p2.val){
				p1 = p1.next;
			}else if(p1.val>p2.val){
				p2 = p2.next;
			}else if(p1.val == p2.val){
				list.add(p1);
				p1 = p1.next;
				p2 = p2.next;
			}
		}		
		return list;
	}
}
class ListNode{
	ListNode next;
	int val;
	ListNode(int val){
		this.val = val;
	}
}