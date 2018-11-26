package com.wumeng.E;

import java.util.Scanner;

public class A5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int index = 1;
		while(index<=m){
			String strA = input.next();
			String strB = input.next();
			if(strA == null||strB == null)
				return ;
			StringBuffer sb_A = new StringBuffer(strA).reverse();
			StringBuffer sb_B = new StringBuffer(strB).reverse();
			StringBuffer sum = new StringBuffer();
			int len1 = strA.length();
			int len2 = strB.length();
			if(len1>len2){
				int cha = len1-len2;
				for(int i=0;i<cha;i++){
					sb_B.append('0');
				}					
			}else{
				int cha = len2-len1;
				for(int i=0;i<cha;i++){
					sb_A.append('0');
				}
			}

			int overflow = 0;
			int sum1;
			for(int i=0;i<(len1>len2?len1:len2);i++){
				sum1 = sb_A.charAt(i) - '0' +sb_B.charAt(i) - '0'+overflow;
				if(sum1 >=10){
					sum1 = sum1-10;				
					overflow = 1;
				}else{
					overflow = 0;
				}
				sum.append(sum1);
			}

			if(overflow == 1){
				sum.append('1');
			}

			String sum_s = sum.reverse().toString();
			if(index!=m){
				System.out.println("Case "+index+":");

				System.out.println(strA+" "+"+ "+strB+" "+"= "+sum_s);
				System.out.println();
			}else{
				System.out.println("Case "+index+":");

				System.out.println(strA+" "+"+ "+strB+" "+"= "+sum_s);
			}
			index++;

		}


	}

}
