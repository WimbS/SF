package com.wimb.B1;



public class MergeSort {
	//���ù鲢�����㷨������data�������� 
	private int[] data={50,10,90,30,70,40,80,60,20};
	public  void mergeSort(){
		//�鲢���� 
		sort(data , 0 , data.length - 1);
	}
	/** 
	 * ��������left��right��Χ������Ԫ�ؽ��й鲢���� 
	 * @param data �����������
	 * @param left �����������ĵ�һ��Ԫ������ 
	 * @param right ���������������һ��Ԫ�ص����� 
	 * �Ȱ���������ͨ���ݹ飬�ָ�����ݣ������Ƿָ������һ��
	 */ 
	private  void sort(int[] data, int left, int right) { 
		if (left < right){
			//�ҳ��м���������ͣ�طָ����飬ʹ���Ϊ�����ٷָ�Ĳ���
			int center = (left + right) / 2;/*centֵ�ֱ���:4 2 1 0   */
			//�����������еݹ�
			System.out.println(left < center?"sort-left---L:"+left+";C:"+center:"");
			////�����������зָ�
			sort(data, left, center); //�ݹ�ʱ�ȵ��õĺ󷵻أ�����õ��ȷ��أ�����βε�ֵҲ���棬����ջ��ԭ��			
			//���ұ�������еݹ�
			System.out.println(center + 1 < right?"sort-right---C:"+(center + 1)+";R:"+right:"");
			//���ұ�������зָ�
			sort(data, center + 1, right); /*��center��0��ʱ��left=right,���sort����ִ�У������ߺϲ�*/
			
			//�ϲ�
			merge(data, left, center, right); 
		} 
	} 
	/** �ϲ�
	 * ������������й鲢���鲢ǰ���������Ѿ����򣬹鲢����Ȼ���� 
	 * @param data ������� 
	 * @param left ������ĵ�һ��Ԫ�ص����� 
	 * @param center ����������һ��Ԫ�ص�������center+1���������һ��Ԫ�ص�����
	 * @param right ����������һ��Ԫ�ص����� 
	 */ 
	private  void merge(int[] data, int left, int center, int right) {
		//����һ������������г�����ͬ����ʱ���� 
		int[] tmpArr = new int[data.length];
		int mid = center + 1;
		//third��¼�м����������
		int third = left; 
		int tmp = left; 
		while (left <= center && mid <= right){ 
			//����������������ȡ��С�ķ����м����飬 
			if (data[left]-data[mid]<= 0){ 
				tmpArr[third++] = data[left++]; 
			} else{
				tmpArr[third++] = data[mid++]; 
			}
		} 
		//�ȽϺ�ʣ����������ֲ������η����м����� 
 		while (mid <= right) { 
			tmpArr[third++] = data[mid++]; 
		} 
        while (left <= center) { 
			tmpArr[third++] = data[left++]; 
		} 
		//���м������е����ݸ��ƿ���ԭ����
		//(ԭleft��right��Χ�����ݸ��ƻ�ԭ����) 
		while (tmp <= right){//�Ѿ�����õ�����
		
			data[tmp] = tmpArr[tmp++]; 
		}
		System.out.println("merge");
	} 
	public static void main(String[] args) {
		MergeSort m=new MergeSort();

		System.out.println("����֮ǰ��\n"
				+ java.util.Arrays.toString(m.data));
		m.mergeSort();
		System.out.println("����֮��\n" 
				+ java.util.Arrays.toString(m.data));
	}
}
