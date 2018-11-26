package com.wumeng.E;

import java.util.Scanner;

public class A1008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int N = input.nextInt();
			if(N == 0)
				return;
			
			int []el = new int[N];
			int sum = 0;
			int tmp = 0;
			for(int i=0;i<N;i++){
				el[i] = input.nextInt();
				
				int n = el[i] - tmp;
				if(n>0){
					sum += n*6 + 5;
				}else{
					sum += n*(-1)*4 + 5;
				}	
				
				tmp = el[i];
			}

			System.out.println(sum);
		}
	}

}
