package com.wimb.B1;


import java.util.Arrays;

/*
 * weikun
 * 2012-02-07
 * h����4�������ÿ������(ֱ�Ӳ�������)
 */
public class ShellSort {
	public static int count = 0;
	private int [] data={47,55,10,40,15,94,5,70};
	
	public  void shellSort(){   
		System.out.println("ԭʼ���飺");
		System.out.println(Arrays.toString(data));
		System.out.println("-------------------");
		System.out.println("��ʼ����");
		int arrayLength = data.length;
		//h��������ɱ�����
		int h = 1;
		//��h * 3 + 1�õ��������е����ֵ
		while(h <= arrayLength / 3){/// ������h���ֵ  
			h = h * 3 + 1;
		}
		while(h > 0){
			System.out.println("===h��ֵ:" + h + "===");
			for (int i = h ; i < arrayLength ; i++ ){
				//���������ʱ����֤data[i]��ֵ���ᶪʧ
				int tmp = data[i];
				//i��������ֵ�Ѿ���ǰ������ֵ���󣬱����Ѿ������������
				//��i-1����֮ǰ�������Ѿ�����ģ�i-1������Ԫ�ص�ֵ�������ֵ��
				if (data[i]-data[i - h]< 0){
					int j = i - h;
					//�������h��,
					//��h������1��ʱ�򣬽��д�Сֵ�Ե���Ҳ�����������Ϊ��������
					//��h����1��ʱ�򣺲�����(h�Ŀɱ������Ŀ�ȵ��Ǹ�ֵ)�ȣ�
					//���һ�Ҫ�Ϳ��ֵ��ǰһ��Ԫ�ر�(ֱ��j >= 0)��ֱ������С�����뵽û�б�����С�ĵط���					
					for ( ; j >= 0 && data[j]-tmp > 0 ; j=j-h){//j=j-h �˼�����
						data[j + h] = data[j];	//��Ԫ�ص�Ϊ���˸���һ��h�������ڽ��бȶ�					
					}
					//���tmp��ֵ��Ҳ������С��ֵ�������Ѿ��ȶ����֮��ĺ���λ��
					data[j + h] = tmp;					
				}
				System.out.println(Arrays.toString(data));
			}
			//h=4�����ս����[15, 55, 5, 40, 47, 94, 10, 70]
			h = (h - 1) / 3;//�������h����,
		}
	}   

	public static void main(String[] args){   
		ShellSort s=new ShellSort();
		s.shellSort();		
	}
}
