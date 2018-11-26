package com.wimb.A;

//动态规划DP典型例题

//【题目描述】：给定一个整数序列，a0, a1, a2, …… , an（项可以为负数），求其中最大的子序列和。如果所有整数都是负数，那么最大子序列和为0；
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

	//最大子序列的和
	//1.穷举法  O(n^3)
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
	//2.穷举改进版 O(N^2)
	//除去第三次的重复运算
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
	//3.分而治之思想  O(N*logN)
	//	算法思想：把问题分成两个大致相等的子问题，然后递归地对它们求解，这是“分”的部分。
	//	“治”阶段将两个子问题的解修补到一起并可能再做些少量的附加工作，最后得到整个问题的解。	
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

	//4.挑选最优起点
	//设a[i]为和最大序列的起点，则如果a[i]是负的，那么它不可能代表最优序列的起点，因为任何包含a[i]作为起点的子序列都可以通过a[i+1]作起点而得到改进。
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

	//动态规划
	//状态转移方程： sum[i]=max(sum[i-1]+a[i],a[i])
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

	//经典问题：数塔问题
	//转移方程：sum[i] = max(a[左孩子] , a[右孩子]) + a[i]
	public static int NumTa(int a[][]){
		int row = a.length;
		for(int i = row-1;i>=0;i--){
			for(int j=0;j<i;j++){
				a[i-1][j] = a[i+1][j]>a[i][j]?a[i+1][j]:a[i][j];
			}
		}
		return a[0][0];
	}

	//挑选数组中不相邻和最大：递归实现
	//递归实现出现很多重复子问题，复杂度达到O（2^n）
	public static int rec_opt1(int a[],int i){
		if(i == 0)
			return a[0];
		if(i == 1)
			return a[0]>a[1]?a[0]:a[1];

			int A = rec_opt1(a,i-2)+a[i];
			int B = rec_opt1(a,i-1);
			return A>B?A:B;			
	}
	//非递归实现
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
	//【问题描述】给定一个是数组和一个定值，从数组中挑选看是否存在几个数字的和为定值的情况
	//【数据】{3,34,4,12,5,2} S=9
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
	//非递归实现
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

	//递归经典题目2 - 数塔问题
	public static int NumDump(int a[][]){
		for(int i=a.length-1;i>=0;i--){
			for(int j=0;j<=i;j++){
				a[i-1][j] += a[i][j]>a[i][j+1]?a[i][j]:a[i][j+1];
			}
		}
		return a[0][0]; 
	}

	//【问题描述】有n 个物品，它们有各自的重量和价值，现有给定容量的背包，如何让背包里装入的物品具有最大的价值总和？
	//【思路】根据动态规划解题步骤（问题抽象化、建立模型、寻找约束条件、判断是否满足最优性原理、找大问题与小问题的递推关系式、填表、寻找解组成）找出01背包问题的最优解以及解组成，然后编写代码实现；
	public static int dp_01bag(){
		int N = 3 ;     // 宝石个数
		int C = 10 ;    // 书包容量
		int V[] = {0,5,3,4} ;       // 每个宝石的体积，这里前面的0是为了后面表示方便，即V[1]表示为第一个宝石的体积，下同
		int W[] = {0,20,10,12} ;    // 每个宝石的价值
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
