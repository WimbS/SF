package com.wumeng.E;

import java.util.Scanner;

public class A1009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		
	}

	/**
	 * @param m : ��ʾ�������������
	 * @param n : ��ʾ��Ʒ�ĸ���
	 * @param w : ��ʾ��Ʒ��������
	 * @param p : ��ʾ��Ʒ��ֵ����
	 * 
	 */
	public static int[][] DP_01bag(int m,int n,int w[],int p[]){
		//c[i][m] ��ʾǰi����Ʒǡ�÷�������Ϊm�ı���ʱ������ֵ
		int c[][] = new int[n+1][m+1];
		
		for(int i=0;i<n+1;i++){
			c[i][0] = 0;
		}
		for(int j=0;j<m+1;j++){
			c[0][j] = 0;
		}
		for(int i=1;i<n+1;i++){
			for(int j=1;j<m+1;j++){
				//����ƷΪi������Ϊjʱ�������i��������(w[i-1])С������jʱ��c[i][j]Ϊ�����������֮һ��
                //(1)��Ʒi�����뱳���У�����c[i][j]Ϊc[i-1][j]��ֵ
                //(2)��Ʒi���뱳���У��򱳰�ʣ������Ϊj-w[i-1],����c[i][j]Ϊc[i-1][j-w[i-1]]��ֵ���ϵ�ǰ��Ʒi�ļ�ֵ
				
				if(w[i-1] <= j){
					if(c[i-1][j] <c[i-1][j-w[i-1]]+p[i-1]){
						c[i][j] = c[i-1][j-w[i-1]]+p[i-1];
					}else{
						c[i][j] = c[i-1][j];
					}
					
				}else{
					c[i][j] = c[i-1][j];
				}
			}
		}
		return c;
		
	}
}