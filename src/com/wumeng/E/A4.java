package com.wumeng.E;

import java.util.Scanner;

public class A4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num = input.nextInt();
			int a[] = new int[num];
			for(int i=0;i<num;i++){
				a[i] = input.nextInt();
			}
			
			for(int j=0;j<num;j++){
				int sum = 0;
				int k=0;
				for(k=1;k*k<a[j];k++){
					if(a[j]%k==0){
						sum +=2;
					}
				}
				if(k*k == a[j])
					sum++;
				a[j] = sum;		
			}
			
			for(int l:a){
				System.out.print(l+" ");
			}
		}
	}

}
