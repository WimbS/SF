package com.wimb.A;

//��̬�滮DP��������

//����Ŀ������������һ���������У�a0, a1, a2, ���� , an�������Ϊ�����������������������к͡���������������Ǹ�������ô��������к�Ϊ0��
public class DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		DP d = new DP();
		//		int a[] = {-1,-2,1,-1,-2};
		//		System.out.print(d.maxSubSum4(a,0, 5));
		//		int a[] = {1,2,4,1,7,8,3};
		//		System.out.print(d.rec_opt(a, 6));

		//		int a[] = {3,34,4,12,5,2};
		//		System.out.print(d.dp_subset(a, 13));
	}

	//��������еĺ�
	//1.��ٷ�  O(n^3)
	public static int maxSubSum1(int[] a) {
		int num = -10000000;
		int len = a.length;
		if(len < 0)
			return 0;
		for(int i=0;i<a.length;i++){
			for(int j=i;j<a.length;j++){
				int num1 = 0;
				for(int k=i;k<=j;k++){
					num1 += a[k];
				}
				if(num1 > num){
					num = num1;
				}
			}
		}
		return num;
	}
	//2.��ٸĽ��� O(N^2)
	//��ȥ�����ε��ظ�����
	public static int maxSubSum2(int[] a) {
		int num = -10000000;
		int len = a.length;
		if(len < 0)
			return 0;
		for(int i=0;i<a.length;i++){
			int num1 = 0;
			for(int j=i;j<a.length;j++){
				num1 += a[j];		
				if(num1 > num){
					num = num1;
				}
			}
		}
		return num;
	}
	//3.�ֶ���֮˼��  O(N*logN)
	//	�㷨˼�룺������ֳ�����������ȵ������⣬Ȼ��ݹ�ض�������⣬���ǡ��֡��Ĳ��֡�
	//	���Ρ��׶ν�����������Ľ��޲���һ�𲢿�������Щ�����ĸ��ӹ��������õ���������Ľ⡣	
	public static int maxSubSum3(int[] a,int left,int right) {
		if(left > right){
			return 0;
		}
		if(left == right){
			return a[left];
		}
		int mid = (left+right)/2;

		int maxleftsum = a[left];
		int leftsum = 0;
		for(int i=mid;i>=0;i--){
			leftsum += a[i];
			if(leftsum > leftsum){
				maxleftsum = leftsum;
			}
		}

		int maxrightsum = a[mid+1];
		int rightsum = 0;
		for(int i = mid+1;i<=right;i++){
			rightsum += a[i];
			if(maxrightsum < rightsum){
				maxrightsum = rightsum;
			}
		}

		return maxOfThree(maxrightsum+maxleftsum,maxSubSum3(a, left, mid),maxSubSum5(a, mid+1, right));
	}

	public static int maxOfThree(int a,int b,int c){
		int max = a>b?a:b;
		return max>c?max:c;
	}

	//4.��ѡ�������
	//��a[i]Ϊ��������е���㣬�����a[i]�Ǹ��ģ���ô�������ܴ����������е���㣬��Ϊ�κΰ���a[i]��Ϊ���������ж�����ͨ��a[i+1]�������õ��Ľ���
	public static int maxSubSum4(int[] a,int left,int right) {
		int maxSum = 0;
		int Sum = 0;
		for(int i=0;i<a.length;i++){
			Sum +=a[i];
			if(Sum>maxSum){
				maxSum = Sum;
			}
			if(Sum<0){
				Sum =0;
			}
		}	
		return maxSum;
	}	

	//��̬�滮
	//״̬ת�Ʒ��̣� sum[i]=max(sum[i-1]+a[i],a[i])
	public static int maxSubSum5(int[] a,int left,int right) {
		int len = right - left + 1;
		int sum = 0;
		int maxsum = 0;
		for(int i=0;i<len;i++){
			sum += a[i];
			if(sum > maxsum){
				maxsum = sum;
			}

			if(sum <0){
				sum = 0;
			}
		}
		return maxsum;
	}

	//�������⣺��������
	//ת�Ʒ��̣�sum[i] = max(a[����] , a[�Һ���]) + a[i]
	public static int NumTa(int a[][]){
		int row = a.length;
		for(int i = row-1;i>=0;i--){
			for(int j=0;j<i;j++){
				a[i-1][j] = a[i+1][j]>a[i][j]?a[i+1][j]:a[i][j];
			}
		}
		return a[0][0];
	}

	//��ѡ�����в����ں���󣺵ݹ�ʵ��
	//�ݹ�ʵ�ֳ��ֺܶ��ظ������⣬���ӶȴﵽO��2^n��
	public static int rec_opt1(int a[],int i){
		if(i == 0)
			return a[0];
		if(i == 1)
			return a[0]>a[1]?a[0]:a[1];

			int A = rec_opt1(a,i-2)+a[i];
			int B = rec_opt1(a,i-1);
			return A>B?A:B;			
	}
	//�ǵݹ�ʵ��
	public static int rec_opt2(int a[]){
		int len = a.length;
		int []b = new int[len];
		b[0] = a[0];
		b[1] = a[0]>a[1]?a[0]:a[1];
		for(int i=0;i<a.length;i++){
			int A = a[i-2]+a[i];
			int B = a[i-1];
			b[i] = A>B?A:B;
		}
		return b[len-1];
	}
	//����������������һ���������һ����ֵ������������ѡ���Ƿ���ڼ������ֵĺ�Ϊ��ֵ�����
	//�����ݡ�{3,34,4,12,5,2} S=9
	public static boolean rec_subset(int a[],int i,int s){
		if(s == 0){
			return true;
		}else if(i == 0){
			return false;
		}else if(a[i]>s){
			return rec_subset(a,i-1,s);
		}else{
			boolean A = rec_subset(a,i-1,s-a[i]);
			boolean B = rec_subset(a,i-1,s);
			return A||B;
		}
	}
	//�ǵݹ�ʵ��
	public static boolean dp_subset(int a[],int S){
		boolean [][]subset = new boolean[a.length][S+1];
		for(int i=0;i<a.length;i++){
			subset[i][0] = true;
		}
		for(int j=0;j<S+1;j++){
			subset[0][j] = false; 
		}
		subset[0][a[0]] = true;
		for(int i=1;i<a.length;i++){
			for(int s=1;s<S+1;s++){
				if(a[i]>s){
					subset[i][s] = subset[i-1][s];					
				}else{
					boolean A = subset[i-1][s-a[i]];
					boolean B = subset[i-1][s];
					subset[i][s] = A||B;
				}
			}
		}
		return subset[a.length-1][S];

	}

	//�ݹ龭����Ŀ2 - ��������
	public static int NumDump(int a[][]){
		for(int i=a.length-1;i>=0;i--){
			for(int j=0;j<=i;j++){
				a[i-1][j] += a[i][j]>a[i][j+1]?a[i][j]:a[i][j+1];
			}
		}
		return a[0][0]; 
	}

	//��������������n ����Ʒ�������и��Ե������ͼ�ֵ�����и��������ı���������ñ�����װ�����Ʒ�������ļ�ֵ�ܺͣ�
	//��˼·�����ݶ�̬�滮���ⲽ�裨������󻯡�����ģ�͡�Ѱ��Լ���������ж��Ƿ�����������ԭ���Ҵ�������С����ĵ��ƹ�ϵʽ�����Ѱ�ҽ���ɣ��ҳ�01������������Ž��Լ�����ɣ�Ȼ���д����ʵ�֣�
	public static int dp_01bag(){
		int N = 3 ;     // ��ʯ����
		int C = 10 ;    // �������
		int V[] = {0,5,3,4} ;       // ÿ����ʯ�����������ǰ���0��Ϊ�˺����ʾ���㣬��V[1]��ʾΪ��һ����ʯ���������ͬ
		int W[] = {0,20,10,12} ;    // ÿ����ʯ�ļ�ֵ
		int d[][] = new int[N+1][C+1];
		d[0][N] = 0;
		for(int i=0;i<N+1;i++){
			for(int j=0;j<C+1;j++){
				d[i][j] = (d[i-1][j-V[i]]+W[i])>d[i-1][j]? (d[i-1][j-V[i]]+W[i]):d[i-1][j];
			}
		}
		return d[N][C];
	}
	
}
