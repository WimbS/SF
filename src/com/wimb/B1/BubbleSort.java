package com.wimb.B1;


import java.util.*;

//����һ�����ݰ�װ��

public class BubbleSort
{                      
	private int[] data={9,16,27,23,30,49,21,35};
	public  void bubbleSort() 
	{
		System.out.println("��ʼ����");
		int arrayLength = data.length;
		for (int i = 0; i < arrayLength - 1 ; i++ )////-1��ԭ�����������ٲ�������		
		{
			boolean flag = false;
			for (int j = 0; j < arrayLength - 1 - i ; j++ )//-1-i��ԭ����û��һ��i��
			//�൱�ڰ��������Ѿ��ŵ�����ˣ������û��ѭ���ı�Ҫ��
			{
				//���j��������Ԫ�ش���j+1��������Ԫ��
				if (data[j]-(data[j + 1]) > 0)
				{
					//��������
					int tmp = data[j + 1];
					data[j + 1] = data[j];
					data[j] = tmp;
					flag = true;
				}
			}
			System.out.println(java.util.Arrays.toString(data));
			//���ĳ��û�з���������������Ѵ�������״̬
			if (!flag)
			{
				break;
			}
		}
	}
	public static void main(String[] args)
	{
		BubbleSort b=new BubbleSort();
		
		System.out.println("����֮ǰ��\n"
			+ java.util.Arrays.toString(b.data));
		b.bubbleSort();
		System.out.println("����֮��\n" 
			+ java.util.Arrays.toString(b.data));
	}
}
