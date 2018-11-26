package com.wimb.B;
import java.util.Arrays;

//������
public class HeapSort{
	private int [] data={9,79,46,30,58,49};
	public  void heapSort() {
		System.out.println("��ʼ����");
		int arrayLength = data.length;
		//ѭ������
		/*
		 *        9
		 *      /   \
		 *    79    46
		 *   / \   /
		 * 30  58 49 
		 */
		//�����ȫ���������󶥶ѣ���˵�ֵ(0������)�϶�����ûswap֮ǰ������ֵ��
		//��������������������򽻻����������������棬��Ȼ�����������棬�������������ݲ�û���źã���ˣ���Ҫ��ͣ�������㣬���½��ѣ���Ҫѭ��
		for (int i = 0; i < arrayLength - 1 ; i++ ){//5 4 3 2 1		
			//����
			builMaxdHeap( arrayLength - 1 -i);//-i��ԭ�򣬾���������û����һ��ѭ�����������Ѿ�������ĺ����ˣ��Ͳ����ڽ�����
			//�����Ǵ�׶��ʽ��׶�����������������Ѷ������һ��Ԫ��
			System.out.print("����׶��ǰ");
			System.out.println(Arrays.toString(data));
			
			swap( 0 , arrayLength - 1 - i);
			System.out.print("����׶����");
			System.out.println(Arrays.toString(data));
		}
	}
	
	//��data�����0��lastIndex���󶥶�.
	//�󶥶ѵ������ǣ����и��ڵ��ֵ���������������ӽڵ�
	private  void builMaxdHeap( int lastIndex){//�޽��󶥶�
		//��lastIndex���ڵ㣨���һ���ڵ㣩�ĸ��ڵ㿪ʼ
		//(lastIndex - 1)/2    Ϊ���һ���ڵ�ĸ��ڵ������(�����ڵ�)
		
		//���Ǵ��ӽڵ㿪ʼ�ж�  k��ֵ�ֱ��� 5 3 1 �����������ж�
		/*
		 *        9
		 *      /   \
		 *    79    46
		 *   / \   /
		 * 30  58 49 
		 */
		for (int i = (lastIndex - 1) / 2 ; i >= 0  ; i--){//�����ŴӴ�Ŀ�ʼ
			//k���浱ǰ�����жϵĽڵ�
			int k = i;
			//�����ǰk�ڵ���ӽڵ���ڣ�
			//k * 2 + 1 �жϵ�ǰ�ڵ���ӽڵ�
			while (k * 2 + 1 <= lastIndex){//����ǰҪ�ж�k���ӽڵ��Ƿ���ڡ�
				//k�ڵ�����ӽڵ������
				int biggerIndex = 2 * k  + 1; 
				//���biggerIndexС��lastIndex����biggerIndex + 1
				//����k�ڵ�����ӽڵ����
				if (biggerIndex < lastIndex){//��ֹ���				
					 //������ӽڵ��ֵ�ϴ�biggerIndex�洢�Ķ������ڵ�����
					if(data[biggerIndex]-(data[biggerIndex + 1]) < 0){//�����С�������
						//biggerIndex���Ǽ�¼�ϴ��ӽڵ��������֮���ٺ͸��ױ�
						biggerIndex++; //���ǽϴ�ڵ��������,Ҳ�����ҽڵ��������
					}					
				}
				//���k(���ڵ�)�ڵ��ֵС����ϴ��ӽڵ�(���Ҷ��п���)��ֵ������
				if(data[k]-(data[biggerIndex]) < 0){
					//��������
					swap( k , biggerIndex);
					//��biggerIndex����k����ʼwhileѭ������һ��ѭ����
					//���±�֤k�ڵ��ֵ�����������ӽڵ��ֵ��
					k = biggerIndex;//��ڵ��������,
				}else{//����������պ��ǽڵ��ֵ�����ӽڵ��ֵ
					break;//�պý�����һ��ѭ��
				}
			}
		}
	}
	//����data������i��j������������Ԫ��
	private  void swap( int i , int j){
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	public static void main(String[] args){
		HeapSort h=new HeapSort();
		
		System.out.println("����֮ǰ��\n"
			+ java.util.Arrays.toString(h.data));
		h.heapSort();
		System.out.println("����֮��\n" 
			+ java.util.Arrays.toString(h.data));
	}
}
