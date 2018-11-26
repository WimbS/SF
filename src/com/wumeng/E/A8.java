package com.wumeng.E;

import java.util.Scanner;

public class A8 {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext())
		{
			int T=cin.nextInt();

			int No=1;
			while(T>0)
			{

				int N=cin.nextInt();
				int[] num=new int[N]; 
				for(int i=0;i<N;i++)
				{
					num[i]=cin.nextInt();
				}
				int maxSum=-10000,thisSum=0;
				int start=0,end=0;
				for(int i=0;i<N;i++)
				{
					thisSum+=num[i];   		 
					if(thisSum>maxSum)
					{
						maxSum=thisSum;
						end=i;
					}
					if(thisSum<0)
					{
						thisSum=0;  			 
					}   		 
				}
				int sum=0;
				for(int i=end;i>-1;i--)
				{    		
					sum+=num[i];
					if(sum==maxSum)start=i;
				}

				System.out.println("Case "+No+":"); 
				System.out.println(maxSum+" "+(start+1)+" "+(end+1));
				No++;
				if(T!=1)System.out.println();
				T--;

			}
		}
	}
}
