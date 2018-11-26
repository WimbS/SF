package com.wimb.B;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 环形单链表 - 约瑟夫环问题
 * @author Wimb
 *
 */
public class A5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a[] =  new int[10];
		//System.out.print(new A5().YueSeFu(10,3));
		System.out.print(10000/40);
	}
	public int YueSeFu(int a[],int num){
		//错误判断★
		if(a.length<1||num<1)
			return -1;
		for(int i=0;i<a.length;i++){
			a[i] = i+1;
		}
		int count = a.length;
		int index = -1;
		int tmp = 0;
		while(count > 0){			
			index++;
			if(index == a.length) index = 0; //形成环
			if(a[index] == 0){
				continue;
			}else{
				tmp++;
				if(tmp %num == 0){
					a[index] = 0;
					tmp = 0;
					count--;
				}
			}			
		}
		return index;
	}
	public int YueSeFu(int n,int num){
		Deque<Integer>queue = new LinkedList<Integer>();
		if(n<1||num<1)
			return -1;
		for(int i=0;i<n;i++){
			queue.add(i+1);
		}
		int index = 0;
		int last = 0 ;
		while(!queue.isEmpty()){
			index++;
			if(index%num == 0){
				last = queue.pop();
				System.out.println("弹出的数字为："+last);
			}
			if(index%num != 0){
				int tmp = queue.removeFirst();
				queue.addLast(tmp);
			}
		}
		return last;
	}
	
}


