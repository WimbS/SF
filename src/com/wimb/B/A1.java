package com.wimb.B;

import java.util.Stack;
/*
 * 设计一个得到getmin的栈
 */
public class A1 {
	Stack <Integer>s1 = new Stack<Integer>();
	Stack <Integer>s2 = new Stack<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A1 a = new A1();
		a.push(1);
		a.push(1);
		a.push(1);
		a.push(0);
		a.push(1);
		System.out.print(a.getMin());
	}

	public int getMin(){
		if(s2.isEmpty()){ 
			return 0;
		}			
		return s2.peek();
	}
	public void push(int num){
		s1.push(num);
		if(!s2.isEmpty()){
			int now = s2.peek();
			if(now > num){
				s2.push(num);
			}
		}else{
			s2.push(num);
		}
	}
}
