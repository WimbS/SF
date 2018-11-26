package com.wimb.B1;



public class QuickSort { 
	/**������*/ 
	public static void main(String[] args) { 
		//�������� 
		int[] nums = {49,38,65,97,76,13 ,27}; 
		//Ӧ�ÿ������򷽷� 
		quickSort(nums, 0, nums.length-1); 
		//��ʾ���������� 
		for(int i = 0; i < nums.length; ++i) { 
			System.out.print(nums[i] + ","); 
		} 
		System.out.println(""); 
	} 

	/**�������򷽷�*/ 
	/* data��Ҫ���������
	 * start:ѡȡ���ǵ�һ�����������������ţ�������49��ʼ������������������Ƚϣ�
	 * 		  ��ˣ�λ��Ҳ�ʹ���������ڵ�������
	 * end�����һ��Ԫ�أ������������ţ�������27
	 */
	public static void  quickSort(int[] data, int start, int end) { 
		int i = start;    //�൱��i����  ����
		int j = end;    //�൱��j,  ��  ����
		if (i >= j)  { // �ж��Ƿ��м��� �����м䷵��// 1 2 
			return; //����
		}
		//ȷ��ָ�뷽����߼�������Ҳ���Ǵ������������������� 
		boolean flag=true; //false:��->��  true����->��
		while (i != j) { //���i==j֤����һ�˽�����ÿ�˵ı�׼ֵ����һ���������һ�˱��Ƚ�ֵΪ49��
			if (data[i] > data[j]) { 
				//�������� �����б���С������Ԫ��һ�ɷŵ���ߣ����б����������Ԫ��һ�ɷŵ��ұߣ�
				int temp = data[i]; 
				data[i] = data[j]; 
				data[j] = temp; 
				//ֻ�о������Ľ����󣬲��ܰ��α���ƶ�λ�øı䣬�ƶ������ǽ���ı�
				//�����±��ƶ��������ϱ��ƶ� ���α���� ����һ������
				flag = (flag == true) ? false : true; 
			//	flag=!flag;
			} 
			//��ָ����ǰ��������ƶ� ,��һ�δ���-���ң��ڶ��δ���-����
			if(flag) {//true����---����
				j--; 
			}else{//false ��---����
				i++;
			}				 
		} //1 2 
		//���ˣ��������������λ��Ϊ��		
		//��һ�ε���λ�ã�data��ֵ�ǣ�[27, 38, 13, 49, 76, 97, 65]
		//������ֿ����룬ȷ��ÿ�����ֵ���ȷλ�� 
		//i=3,j=3 
		i--; //
		j++; 
		//i=2 j=4 start=0 end=6
		quickSort(data, start, i); //Ҳ���� 27 38 13�ڿ�������
		quickSort(data, j, end); // Ҳ���� 76, 97, 65�ڿ�������
	} 
}