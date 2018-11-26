package com.wumeng.E;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
 
public class NPointPair {
	/**
	 * ���������
	 * @param S
	 */
	public static dcPoint[] closestPoint(dcPoint [] S){
		
		dcPoint[] result = new dcPoint[2];	
		/**
		 * 0.���ȣ����������ı߽磬�����鳤����һ����Χ��ʱֱ���������㣬������� 
		 */
		double dmin = Double.POSITIVE_INFINITY;
		double tmpmin = 0;
		if(S.length <= 20){
			for(int i = 0; i < S.length; i ++){
				for(int j = i + 1; j < S.length; j ++){
					tmpmin = Math.sqrt(Math.pow(S[i].getX() - S[j].getX(), 2)) + Math.pow(S[i].getY() - S[j].getY(), 2);
					if(tmpmin < dmin){
						dmin = tmpmin;
						result[0] = S[i];
						result[1] = S[j];
					}
				}
			}
			return result;
		}
		
		/**
		 *1.�����е���X�������λ�� 
		*/
		int minX = (int) Double.POSITIVE_INFINITY;		//��֤����ĳ�ʼ��Сֵ�㹻��
		int maxX = (int) Double.NEGATIVE_INFINITY;		//��֤����ĳ�ʼ���ֵ�㹻С
		for(int i = 0; i < S.length; i++){
			if(S[i].getX() < minX)
				minX = S[i].getX();
			if(S[i].getX() > maxX)
				maxX = S[i].getX();
		}
		int midX = (minX + maxX)/2;
		
		/**
		 * 2.��midXΪ�罫���е�ֳ�����ֱ�������������
		 */
		ArrayList T1 = new ArrayList();
		ArrayList T2 = new ArrayList();
		for(int i = 0; i < S.length; i++){
			if(S[i].getX() <= midX)		//�Ƿ�Ҫ=�ţ�
				T1.add(S[i]);
			if(S[i].getX() > midX)
				T2.add(S[i]);
		}
		
		/**
		 * 3.�����ű�ת��Ϊ�������ͣ����ֱ�X������������
		 */
		dcPoint [] S1 = new dcPoint[T1.size()];
		dcPoint [] S2 = new dcPoint[T2.size()];
		
		T1.toArray(S1);
		T2.toArray(S2);
		
		mergeSort(S1, "x");		//��X������������
		mergeSort(S2, "x");		//��X������������
		
		/**
		 * 4.��S1�е���������������
		 */
		dcPoint[] result1 = new dcPoint[2];
		result1 = closestPoint(S1);
		
		/**
		 * 5.��S2�е���������������
		 */
		dcPoint[] result2 = new dcPoint[2];
		result2 = closestPoint(S2);
		
		/**
		 * 6.��������������Сֵ
		 */
		double d1 = Math.sqrt(Math.min(Math.pow(result1[0].getX() - result1[1].getX(), 2) + Math.pow(result1[0].getY() - result1[1].getY(), 2), 
				Math.pow(result2[0].getX() - result2[1].getX(), 2) + Math.pow(result2[0].getY() - result2[1].getY(), 2)));
		
		if(Math.pow(result1[0].getX() - result1[1].getX(), 2) + Math.pow(result1[0].getY() - result1[1].getY(), 2) < 
				Math.pow(result2[0].getX() - result2[1].getX(), 2) + Math.pow(result2[0].getY() - result2[1].getY(), 2))
			result = result1;
		else
			result = result2;
		
		/**
		 * 7.��S1��S2���ռ���������С��d1�ĵ㣬�ֱ�������������
		 */
		ArrayList T3 = new ArrayList();
		ArrayList T4 = new ArrayList();
		for(int i = 0; i < S1.length; i++){
			if(midX - S1[i].getX() < d1)
				T3.add(S1[i]);
		}
		for(int i = 0; i < S2.length; i++){
			if(S2[i].getX() - midX < d1){
				T4.add(S2[i]);
			}
		}
		
		/**
		 * 8.�ֱ𽫱�T3��T4ת��Ϊ�������͵�S3��S4��������ֱ�Y������������
		 */
		dcPoint [] S3 = new dcPoint [T3.size()];
		dcPoint [] S4 = new dcPoint [T4.size()];
		T3.toArray(S3);
		T4.toArray(S4);
		
		mergeSort(S3, "y");
		mergeSort(S4, "y");
		
		/**
		 * ���S3��S4����֮����ܵĸ����������d1������ , �Լ����ɸþ���ĵ�
		 */
		double d =  Double.POSITIVE_INFINITY;
		for(int i = 0; i < S3.length; i ++){
			for(int j = 0; j < S4.length; j ++){
				if(Math.abs(S3[i].getY() - S4[j].getY()) < d1){
					double tmp = Math.sqrt(Math.pow(S3[i].getX() - S4[j].getX(), 2) + Math.pow(S3[i].getY() - S4[j].getY(), 2));
					if(tmp < d){
						d = tmp;
						result[0] = S3[i];
						result[1] = S4[j];
					}
				} 
			}
		}
		
		return result;
	}
	
	private static void mergeSort(dcPoint[] a, String property){
		dcPoint[] tempArray = new dcPoint[a.length];
		mergeSort(a, tempArray, 0, a.length - 1, property);
	}
	
	private static void mergeSort(dcPoint[] a, dcPoint [] tempArray, int left, int right, String property){
		if(left < right){
			int center = (left + right) >> 1;
			//����
			mergeSort(a, tempArray, left, center, property);
			mergeSort(a, tempArray, center + 1, right, property);
			//�ϲ�
			merge(a, tempArray, left, center + 1, right, property);
		}
	}
	
	private static void merge(dcPoint [] a, dcPoint [] tempArray, int leftPos, int rightPos, int rightEnd, String property){
		int leftEnd = rightPos - 1;
		int numOfElements = rightEnd - leftPos + 1;
		
		int tmpPos = leftPos;		//�α����, �������α�����ֱ���leftPos �� rightPos
		
		while(leftPos <= leftEnd && rightPos <= rightEnd){
			if(property.equals("x")){
				if(a[leftPos].getX() <= a[rightPos].getX())
					tempArray[tmpPos++] = a[leftPos++];
				else
					tempArray[tmpPos++] = a[rightPos++];
			}else if(property.equals("y")){
				if(a[leftPos].getY() <= a[rightPos].getY())
					tempArray[tmpPos++] = a[leftPos++];
				else
					tempArray[tmpPos++] = a[rightPos++];
			}else
				throw new RuntimeException();
		}
		
		while(leftPos <= leftEnd)
			tempArray[tmpPos++] = a[leftPos++];
		while(rightPos <= rightEnd)
			tempArray[tmpPos++] = a[rightPos++];
		
		//���ź���Ķ��俽����ԭ������
		System.arraycopy(tempArray, rightEnd-numOfElements+1, a, rightEnd-numOfElements+1, numOfElements);
	}
	
	public static void main(String[] args) {
		
		Set<dcPoint> testData = new TreeSet<dcPoint>();
		
		Random random = new Random();
		
		int x = 0;
		int y = 0;
		
		for(int i = 0;i < 50;i++){
			x = random.nextInt(500);
			y = random.nextInt(500);
			System.out.println("x:" + x + "  y:" + y);
			testData.add(new dcPoint(x, y));
		}
		
		dcPoint [] S = new dcPoint[testData.size()];
		S = (dcPoint[]) testData.toArray(S);
		
		for(int i = 0; i < S.length; i ++){
			System.out.println("(" + S[i].getX() + ", " + S[i].getY() + ")");
		}
		
		System.out.println(testData.size());
		
		dcPoint [] result = new dcPoint [2];
		
		result = closestPoint(S);
		
		System.out.println("���������ֱ���(" + result[0].getX() + ", " + result[0].getY() 
				+ ") �� (" + result[1].getX() + ", " + result[1].getY() + "), �������Ϊ��" 
				+ Math.sqrt(Math.pow(result[0].getX() - result[1].getX(), 2) + Math.pow(result[0].getY() - result[1].getY(), 2)));
		
	}
}




class dcPoint implements Cloneable, Comparable<dcPoint>{
	public dcPoint() {
		x = 0;
		y = 0;
	}
 
	public dcPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
 
	public void setX(int x) {
		this.x = x;
	}
 
	public void setY(int y) {
		this.y = y;
	}
 
	public int getX() {
		return x;
	}
 
	public int getY() {
		return y;
	}
 
	private int x;
	private int y;
 
	@Override
	public int compareTo(dcPoint o) {
		if(x == o.getX() && y == o.getY())
			return 0;
		else 
			return 1;
	}
}

