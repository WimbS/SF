package com.wimb.B1;




import java.util.*;
/**
 * 
 * weikun
 * 2012-02-03
 */

public class SelectSort{
	private int [] data1={21,30,49,39,16,9};
	public  void selectSort(){
		
		System.out.println("��ʼ����");
		int arrayLength = data1.length;
		//���ν���n��1�˱Ƚ�, ��i�˱ȽϽ���i���ֵѡ������iλ���ϡ�
		for (int i = 0; i < arrayLength - 1 ; i++ ){
			int minIndex = i ;
			//��i������ֻ�������������ݱȽ�
			for (int j = i + 1 ; j < arrayLength ; j++ ){				
				//�����iλ�õ����� > jλ�õ�����, ��������
				if (data1[i]-(data1[j]) > 0){
					int  tmp = data1[i];
					data1[i] = data1[j];
					data1[j] = tmp;
				}
			}
			System.out.println(java.util.Arrays.toString(data1));
		}
	}
	public static void main(String[] args){
		SelectSort s=new SelectSort();
		
		System.out.println("����֮ǰ��\n"
			+ java.util.Arrays.toString(s.data1));
		s.selectSort();
		System.out.println("����֮��\n" 
			+ java.util.Arrays.toString(s.data1));
		
	}
}
