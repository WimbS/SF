package com.wimb.B1;


import java.util.Arrays;
/*
1. �����½�һ�����б����ڱ�����������������У����ǳ�֮Ϊ�������б����� 
2. ��ԭ������ȡ��һ����Ա�������������б��еĳ�Ա������бȽϣ��ҵ���һ���������ĳ�Ա�����������ýϴ��Ա֮ǰ��
 ����ѭ����������һ�ֱȶԡ�
3.���û�д������ĳ�Ա����������������е���� 
4.�ظ�����2��3ֱ������ԭ�����е����ݶ�������ϡ�
������Ĵ����У��������Զ�������������Ϊ���ӡ�
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] nums = {49,38,10,97,76,13,27}; 		
		System.out.println(Arrays.toString(new InsertSort().insertSort(nums)));
	}
	
	public int[] insertSort(int[] source){ 
		for (int i=0; i<source.length; i++){ 
			int index = -1; 
			//����i����ǰi-1������Ƚϣ��ҵ���һ��������� 
			for (int j=0; j<i; j++){ 
				if (source[j] > source[i]){ 
					index = j; 
					break; 
				} 
			} 
			//����i��������ʵ�λ�á����ǰ��û�б���i����ģ�����Ҫ���κ����顣 
			if (index != -1){ 
				int temp = source[i]; 
				moveBackward(index, i-1, source); 
				source[index] = temp; //������Ӧ��λ��
			} 
		} 
		return source; 
	} 
	/* 
	 * ������������ָ����Χ�ڵ�����Ԫ���������������һ��λ�á� 
	 */ 
	private void moveBackward(int from, int to, int[] values){ 		
		for (int i=to + 1; i>from; i--){ 
			values[i] = values[i-1]; 
		} 
	} 


}
