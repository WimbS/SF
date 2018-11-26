package com.wumeng.E;

import java.util.Scanner;

public class A6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int index = 1;
		while(index != 0){
			int n = input.nextInt();
			int m = input.nextInt();
			int k = input.nextInt();
			int stu[] = new int[n*m];
			for(int i=0;i<stu.length;i++){
				stu[i] = input.nextInt();
					
			}			
			for(int i=0;i<stu.length;i++){
				for(int j=i+1;j<stu.length;j++){
					if(stu[i]<stu[j]){
						int tmp = stu[i];
						stu[i] = stu[j];
						stu[j] = tmp;						
					}
				}
			}
			
			System.out.println("Scenario #"+index);
			System.out.println(stu[k-1]);	
			System.out.println();
			index++;
		}
			
	}

}
