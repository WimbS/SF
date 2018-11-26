package com.wimb.B1;



import java.util.Arrays;
/*
 * �۰�ֱ�Ӳ�������
 */
public class BinInsertSort {
	public static int count = 0;  

	public static void main(String[] args) {  

		int[] data = new int[] {49,38,10,97,76,13,27};
		System.out.println("ԭʼ���ݣ�"+Arrays.toString(data));		
		//binaryInsertSort(data);  
		binaryInsertSort(data);
		System.out.println("��������ݣ�"+Arrays.toString(data));

	}
	/*
	 * ���ֲ��ҷ����۰���ҵ��㷨˼���ǽ����а�����(������ݼ�)���У����ҹ����в�����Ծʽ��ʽ���ң��������������е�
	 * �е�λ��Ϊ�Ƚ϶���
	 * ���Ҫ�ҵ�Ԫ��ֵС�ڸ��е�Ԫ�أ��򽫴���������СΪ��벿�֣�����Ϊ�Ұ벿�֡�ͨ��һ�αȽϣ�������������Сһ�롣 
	 * �۰������һ�ָ�Ч�Ĳ��ҷ��������������Լ��ٱȽϴ�������߲���Ч�ʡ����ǣ��۰���ҵ��Ⱦ������ǲ��ұ��е�����Ԫ��
	 * ��������

	   step1. ����ȷ����������������м�λ�� ����mid = �� left + right ��/ 2 ����
	   step2. �ô���ؼ���ֵ���м�λ�õĹؼ���ֵ���бȽϣ� ����
	   		����ȣ�����ҳɹ� ����
	   		�����ڣ����ں��ң����������������۰���� ����
	   		��С�ڣ�����ǰ���󣩰��������������۰���� ����
	   Step3. ��ȷ������С�����ٰ��۰빫ʽ���ظ��������衣
	   		��󣬵õ������Ҫô���ҳɹ��� Ҫô����ʧ�ܡ� ����
	   		�۰���ҵĴ洢�ṹ����һά�����š�

	 */
	//�����۰������� ֮ǰ�Ѿ�����õ�����
	public static void binaryInsertSort(int[] data) {  
		for (int i = 0; i < data.length-1; i++) {  
			if (data[i+1]< data[i]) {  //�������С��ǰ�����,���������У���˿��Խ����۰�����
				// ����i����Ԫ��ֵ   
				int tmp = data[i+1];  
				// ��¼������Χ����߽�   
				int low = 0;  
				// ��¼������Χ���ұ߽�   
				int high = i ;  
				//���ֲ��ҷ�
				while (low <= high) {  // һ�ζ��� ���ζ��� �Ƚϣ�
					//������ʹʹ������Χ��С ���ҵ���Ͱ����ǽ���λ������ ֱ��low<high,�ҵ��÷��õ�λ��
					// ��¼�м�λ��   
					int mid = (low + high) / 2;  
					// �Ƚ��м�λ�����ݺ�i�����ݴ�С������С������Χ   
					if (data[mid] < tmp) {  //�������ĸ���ֵ�ķ�Χ�������Ƚ���ֵ
						low = mid + 1;  
					} else {  
						high = mid - 1;  
					}  
				}  
				//��low~i��������������ƶ�1λ   
				for (int j = i; j >=low; j--) {  
					data[j+1] = data[j];  
				}  
				data[low] = tmp;  
				System.out.println("��"+i+"���������ݣ�"+Arrays.toString(data));
			}  
		}  

	}  


  


}
