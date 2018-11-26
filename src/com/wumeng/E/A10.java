package com.wumeng.E;

import java.util.Scanner;

public class A10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
	
		while(num-->0){
			int n = in.nextInt();
			if(n == 0)
				return ;
			int a[] = new int[n];
			for(int i=0;i<n;i++){
				a[i] = in.nextInt();
			}
			int sum = 0;
			for(int k:a){
				sum +=k;
			}

			if(num>1){
				System.out.println(sum);
				System.out.println();
			}else{
				System.out.println(sum);
				
			}
			
		}
		
	}
	

}
