package com.wimb.B;

import java.util.Stack;

public class A2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(new A2().djTwoStack("asdasd"));;
		
	}
	public int djTwoStack(String a){
		int len = a.length();
		if(len == 0) 
			return 0;
		Stack <Integer> num = new Stack<Integer>();
		Stack <Character> cha = new Stack<Character>(); 
		
		for(int i=0;i<len;i++){
			if(a.charAt(i)!='('||a.charAt(i)!=')'||a.charAt(i)<'0'||a.charAt(i)>'9'||a.charAt(i)!='+'||a.charAt(i)!='-'||a.charAt(i)!='*'||a.charAt(i)!='/'){
				return -1;
			}
			if(a.charAt(i) == '('){
				continue;
			}
			if(a.charAt(i)<='9'&&a.charAt(i)>='0'){
				num.push(Integer.parseInt(a.substring(i,i+1)));
			}
			if(a.charAt(i) == '+'||a.charAt(i) == '-'||a.charAt(i) == '*'||a.charAt(i) == '/'){
				cha.push(a.charAt(i));
			}	
			
			if(a.charAt(i) == ')'){
				int pre = num.pop();
				int pree = num.pop();
				char fh = cha.pop();
				
				if(fh == '+'){
					num.push(pre + pree);
				}else if(fh == '-'){
					num.push(pree - pre);
				}else if(fh == '*'){
					num.push(pre*pree);
				}else{
					num.push(pree/pre);
				}
			}
		
		}
		return !num.isEmpty()?num.pop():0;
	}
	
}
