package com.wumeng.E;

import java.util.Scanner;

//��̬�滮��������������еĺ�
public class A7 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int cnt =1;
		while(num -->0){
			int n = input.nextInt();
			int a[] = new int[n]; //���������������
			int dp[] = new int[n];//DP����
			int s[] = new int[n]; // ��ŵ�ǰλ���ϴ��ĸ�λ�ÿ�ʼ�����
			int max = dp[0];//������ֵ
			int t = 0; //���м�������
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
