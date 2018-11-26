package com.wumeng.E;

import java.util.Scanner;

//动态规划：最大连续子序列的和
public class A7 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int cnt =1;
		while(num -->0){
			int n = input.nextInt();
			int a[] = new int[n]; //存放所有输入数字
			int dp[] = new int[n];//DP数组
			int s[] = new int[n]; // 存放当前位置上从哪个位置开始计算的
			int max = dp[0];//存放最大值
			int t = 0; //存有几个数字
			for(int i=0;i<n;i++){
				a[i] = input.nextInt();
			}
			s[0] = 0;
			dp[0] = a[0];
			for(int i=1;i<n;i++){
				if(dp[i-1]+a[i] >=a[i]){
					dp[i] = dp[i-1]+a[i];
					s[i] = s[i-1];
					t = i - s[i];
				}else{
					dp[i] = a[i];
					s[i] = i;
					t = 1;
				}
				if(max<dp[i]){
					max = dp[i];
				}
				
			}
			System.out.println("Case "+cnt+":");
			cnt++;
			for(int i=0;i<n;i++){
				if(dp[i] == max){
					System.out.println(max+" "+(s[i]+1)+" "+t);
					break;
				}
			}
			
			if(num!=0)
				System.out.println();
		}
		input.close();
	}
	
	

}
