package com.wimb.B;

import java.util.Stack;

public class A3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A3 a = new A3();
		a.push(1);
		a.push(2);
		a.push(3);
		a.push(4);
		System.out.print(a.pop());
		System.out.print(a.pop());
		System.out.print(a.pop());
		System.out.print(a.pop());
	}
	Stack <Integer>stack1 = new Stack<Integer>();
	Stack <Integer>stack2 = new Stack<Integer>();
	
	public void push(int num){
		while(!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
		stack1.push(num);
	}
	public int pop(){
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		if(stack2.isEmpty()){
			return -1;
		}
		return stack2.pop();
	}
}
