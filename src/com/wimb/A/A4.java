package com.wimb.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class A4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A4 a4 = new A4();
		//		int a[] = {1,2,3,4,100001,100001,100001,100001,100001};
		//		int num = a4.MoreThanHalfNum_Solution(a);
		//		System.out.print(num);
		System.out.print(a4.FirstNotRepeatingChar("google"));

	}

	//经典的字符串全排列问题 
	//思路：回溯法实现，依次交换各个位置上字母
	public ArrayList<String> Permutation(String str) {
		List<String> ResultList = new ArrayList<String>();
		if(str.length() == 0){
			return (ArrayList<String>)ResultList;
		}
		//递归初始条件：str数组，空的list，初始下标为0
		fun(str.toCharArray(),ResultList,0);
		Collections.sort(ResultList);
		return (ArrayList<String>)ResultList;

	}

	public void fun(char a[],List<String> list,int i){
		//递归的初始条件为i移动到list的最后位置
		if(i == a.length - 1){
			if(list.contains(new String(a))){
				list.add(new String(a));
				return ;
			}
		}else{
			//				  //这一段就是回溯法，这里以"abc"为例
			//				             
			//				            //递归的思想与栈的入栈和出栈是一样的,某一个状态遇到return结束了之后，会回到被调用的地方继续执行
			//				             
			//				            //1.第一次进到这里是ch=['a','b','c'],list=[],i=0，我称为 状态A ，即初始状态
			//				            //那么j=0，swap(ch,0,0)，就是['a','b','c']，进入递归，自己调自己，只是i为1，交换(0,0)位置之后的状态我称为 状态B 
			//				            //i不等于2，来到这里，j=1，执行第一个swap(ch,1,1)，这个状态我称为 状态C1 ,再进入fun函数，此时标记为T1，i为2，那么这时就进入上一个if，将"abc"放进list中
			//				            /////////////-------》此时结果集为["abc"]
			//				             
			//				            //2.执行完list.add之后，遇到return，回退到T1处，接下来执行第二个swap(ch,1,1)，状态C1又恢复为状态B
			//				            //恢复完之后，继续执行for循环，此时j=2,那么swap(ch,1,2),得到"acb"，这个状态我称为C2,然后执行fun，此时标记为T2,发现i+1=2,所以也被添加进结果集，此时return回退到T2处往下执行
			//				            /////////////-------》此时结果集为["abc","acb"]
			//				            //然后执行第二个swap(ch,1,2)，状态C2回归状态B,然后状态B的for循环退出回到状态A
			//				             
			//				            //             a|b|c(状态A)
			//				            //               |
			//				            //               |swap(0,0)
			//				            //               |
			//				            //             a|b|c(状态B)
			//				            //             /  \
			//				            //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
			//				            //           /      \
			//				            //         a|b|c   a|c|b
			//				             
			//				            //3.回到状态A之后，继续for循环，j=1,即swap(ch,0,1)，即"bac",这个状态可以再次叫做状态A,下面的步骤同上
			//				            //-------》此时结果集为["abc","acb","bac","bca"]
			//				             
			//				            //             a|b|c(状态A)
			//				            //               |
			//				            //               |swap(0,1)
			//				            //               |
			//				            //             b|a|c(状态B)
			//				            //             /  \
			//				            //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
			//				            //           /      \
			//				            //         b|a|c   b|c|a
			//				             
			//				            //4.再继续for循环，j=2,即swap(ch,0,2)，即"cab",这个状态可以再次叫做状态A，下面的步骤同上
			//				            /////////////-------》此时结果集为["abc","acb","bac","bca","cab","cba"]
			//				             
			//				            //             a|b|c(状态A)
			//				            //               |
			//				            //               |swap(0,2)
			//				            //               |
			//				            //             c|b|a(状态B)
			//				            //             /  \
			//				            //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
			//				            //           /      \
			//				            //         c|b|a   c|a|b
			//				            5.最后退出for循环，结束。
			for(int j=i;j<a.length;j++){
				swap(a,i,j);
				fun(a,list,i+1);
				swap(a,i,j);
			}
		}
	}

	public void swap(char a[],int i,int j){
		if(i != j){
			char tmp = a[i];
			a[i] = a[j];
			a[i] = tmp;
		}
	}
	//数组中字数超过一半的数字
	//思路：最简单的一种，创建足够多的数组，记录数据出现次数进行比对即可
	public int MoreThanHalfNum_Solution(int [] array) {
		int need [] = new int[1000001];
		int len = array.length;
		for(int i=0;i<len;i++){
			need[array[i]]++;
		}
		int w = 0;
		for(int i=0;i<need.length;i++){
			if(need[i]>len/2){
				w = i;
			}
		}
		return w;
	}
	//思路2：作者：cm问前程
	//	采用阵地攻守的思想：
	//	第一个数字作为第一个士兵，守阵地；count = 1；
	//	遇到相同元素，count++;
	//	遇到不相同元素，即为敌人，同归于尽,count--；当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是主元素。
	//	再加一次循环，记录这个士兵的个数看是否大于数组一般即可。
	public int MoreThanHalfNum_Solution1(int [] array) {
		int len = array.length;
		if(len < 0)
			return 0;
		if(len == 0) 
			return array[len];

		int soilder = array[0];
		int count = 1;
		for(int i=1;i<len;i++){
			if(array[i] == soilder){
				count++;
			}else{
				count--;
			}
			if(count <= 0){
				soilder = array[i];
			}
		}


		int count1 = 0;
		for(int i=0;i<len;i++)
		{
			if(soilder == array[i]) count1++;
		}

		if(count1 > len/2){
			return soilder;
		}
		return 0;
	}

	//找出数组中最小的K个数

	//	*基于堆排序算法，构建最大堆。时间复杂度为O(nlogk)
	//	*如果用快速排序，时间复杂度为O(nlogn)；
	//	*如果用冒泡排序，时间复杂度为O(n*k)
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int len = input.length;
		if(k>=len){
			return list;
		}
		Arrays.sort(input);
		for(int i=0;i<k;i++){
			list.add(input[i]);
		}
		return list;
	}
	public void QuickSort(int a[],int low, int high){
		if(a == null)
			return;
		int i = low;
		int j = high;
		if(i>j){
			return ;
		}
		int key = a[low];
		while(i<j){
			while(i<j&&key<a[j]){
				j--;
			}
			while(i<j&&key>a[i]){
				i++;
			}
			if(i<j){
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}			
		}

		int p = a[i];
		a[i] = a[low];
		a[low] = p;
		QuickSort(a,low,i-1);
		QuickSort(a,i+1,high);
	}
	//最大连续子序列的和
	public int FindGreatestSumOfSubArray(int[] array) {
		int num = 0;
		for(int i=0;i<array.length;i++){
			for(int j=i;j<array.length;j++){
				int num1 = 0;
				for(int k=i;k<=j;k++){
					num1 += array[k];
				}
				if(num1 > num){
					num = num1;
				}

			}
		}
		return num;
	}
	//【问题描述】把数组排成最小数
	public String PrintMinNumber(int [] numbers) {
		String a = "";
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<numbers.length;i++){
			list.add(numbers[i]);
		}		
		Collections.sort(list,new Comparator<Integer>(){
			@Override
			public int compare(Integer a,Integer b){
				String aa = a+""+b;
				String bb = b+""+a;
				return aa.compareTo(bb);
			}	
		});
		for(int j:list){
			System.out.println(j);
			a+=j;
		}
		return a;
	}
	//丑数
	public int GetUglyNumber_Solution(int index) {
		if(index<=0)
			return 0;
		int[] result = new int[index];
		int count = 0;
		//三个队列头元素
		int i2 = 0;
		int i3 = 0;
		int i5 = 0; 
		result[0] = 1;
		int tmp = 0;
		while (count < index-1) {
			tmp = min(result[i2] * 2, min(result[i3] * 3, result[i5] * 5));
			if(tmp==result[i2] * 2) i2++;//三条if防止值是一样的，不要改成else的
			if(tmp==result[i3] * 3) i3++;
			if(tmp==result[i5]*5) i5++;
			result[++count]=tmp;
		}
		return result[index - 1];
	}
	private int min(int a, int b) {
		return (a > b) ? b : a;
	}
	//丑数2
	public int GetUglyNumber_Solution1(int index) {
		if(index<0)
			return 0;
		ArrayList <Integer>list1 = new ArrayList<Integer>();
		ArrayList <Integer>list2 = new ArrayList<Integer>();
		ArrayList <Integer>list3 = new ArrayList<Integer>();

		int newNum = 1;
		int count = 1;

		while(count <= index){
			list1.add(newNum*2);
			list2.add(newNum*3);
			list3.add(newNum*5);
			newNum = min(list1.indexOf(0),list2.indexOf(0)>list3.indexOf(0)?list3.indexOf(0):list2.indexOf(0));
			System.out.println(list1.indexOf(1));;
			if(newNum == list1.indexOf(0)) list1.remove(0);
			if(newNum == list2.indexOf(0)) list2.remove(0);
			if(newNum == list3.indexOf(0)) list3.remove(0);
			count++;
		}			

		return newNum;		
	}

	//第一个只出现一次的字符位置
	public int FirstNotRepeatingChar(String str) {
		HashMap <Character,Integer>map = new HashMap<Character,Integer>();
		char []arr = str.toCharArray();
		System.out.print(arr.length);
		for(int i=0;i<arr.length;i++){
			if(map.containsKey(arr[i])){
				int time = map.get(arr[i]);
				time++;
				map.put(arr[i], time);
			}else{
				map.put(arr[i], 1);
			}
		}

		for(int i=0;i<arr.length;i++){
			int now = map.get(arr[i]);
			if(now == 1){
				return i;
			}
		}
		return -1;
	}

	//两个链表找到第一个公共节点
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1 == null||pHead2 == null)
			return null;
		int count1 = 0;
		ListNode p1 = pHead1;
		while(p1 != null){
			p1 = p1.next;
			count1++;
		}
		int count2 = 0;
		ListNode p2 = null;
		while(p2!=null){
			p2 = p2.next;
			count2++;
		}

		int flag = count1 - count2;
		if(flag>0){
			pHead1 = pHead1.next;
			while(flag>0){
				flag--;
			}
			while(pHead1 != pHead2){
				pHead1 = pHead1.next;
				pHead2 = pHead2.next;
			}
			return pHead1;
		}

		if(flag<0){
			while(flag<0){
				pHead2 = pHead2.next;
				while(pHead1 != pHead2){
					pHead1 = pHead1.next;
					pHead2 = pHead2.next;
				}
				return pHead1;
			}
		}
		return null;
	}

	//求二叉树的深度：递归和非递归
	public int findDeep(TreeNode root){
		int deep = 0;
		if(root != null){
			int left = findDeep(root.left);
			int right = findDeep(root.right);
			return left>right?left+1:right+1;
		}
		return deep;
	}
	//非递归实现
	public int findDeep1(TreeNode root){
		if(root == null)
			return 0;
		TreeNode currentNode = null;
		LinkedList <TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int cur,last;
		int level = 0;
		while(!queue.isEmpty()){
			cur = 0;//已经遍历的节点个数
			last = queue.size();//遍历完当前层以后队列中是下一层的所有元素，队列长度即为这一层的节点个数
			while(cur < last){ //当还未遍历到本层节点的最后一个时循环
				currentNode = queue.poll(); // 出队一个元素
				cur++;
				if(currentNode.left != null){
					queue.offer(currentNode.left);
				}
				if(currentNode.right != null){
					queue.offer(currentNode.right);
				}
			}
			level++;//每遍历完一层
		}
		return level;	
	}
	//默写
	public static int findDeep2(TreeNode root){
		if(root == null)
			return 0;
		int cur,last;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		int level = 0;
		queue.add(root);
		while(!queue.isEmpty()){
			cur = 0;
			last = queue.size();
			while(cur<last){
				TreeNode now = queue.poll();
				cur++;
				if(now.left!= null){
					queue.add(now.left);
				}
				if(now.right!= null){
					queue.add(now.right);
				}
			}
			level++;			
		}
		return level;
	}
	//判断是否是平衡二叉树
	public boolean IsBalanced_Solution(TreeNode root) {
		if(root == null)
			return false;
		int left = this.findDeep(root.left);
		int right = this.findDeep(root.right);
		int flag = left - right;
		if(flag < -1||flag >1){
			return false;
		}
		return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
	}

	//数组中只出现一次的数字
	/*
	解法2：
	（1）思路：这个可以可以使用一个Map，Map对应的键值key就是数组中的元素，value就是这个元素出现的次数。这样我
	通过一次遍历数组中的元素，如果元素出现在map中，则将其对应的value加1，否则将元素添加到map中，这样遍历一遍数组，我们就可以得到数组中每个元素对应出现的次数，然后再通过遍历一遍map，返回value为1对应的key就是我们需要求得元素。
	（2）时间复杂度：因为首先需要遍历一遍数组，时间开销为O(n)，构建完map后需要遍历一遍map找到value为1的元素，而map的个数为n/2，时间开销为O(n/2)，所以总的时间开销为O(n)。
	（3）空间复杂度：因为需要建立一个map，而且最后map的大小为n/2，所以空间复杂度为O(n)。
	 */
	public static void findNumsAppearOnce1(int[] arr) {
		Map <Integer,Integer> hashMap = new HashMap<Integer,Integer>();
		for(int i:arr){
			if(hashMap.containsKey(i)){
				hashMap.put(i, hashMap.get(i)+1);
			}else{
				hashMap.put(i, 1);
			}
		}
	}
	public static int getMax(int a[]){
		int len = a.length;
		Stack <Integer> stack = new Stack<Integer>();
		if(len < 0){
			return 0;
		}
		if(len == 0){
			return a[0];
		}
		stack.push(a[0]);
		for(int i=0;i<len;i++){
			if(stack.isEmpty()){
				stack.push(a[i]);
			}else{
				if(stack.peek() == a[i]){
					stack.push(a[i]);
				}else if(stack.peek() != a[i]){
					stack.pop();
				}
			}			
		}
		return stack.isEmpty()?0:stack.pop();
	}
	//和为S的正整数序列
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> alist = new ArrayList<ArrayList<Integer>>();
		if(sum<=2){
			return alist;
		}

		for(int i=1;i<sum/2;i++){
			ArrayList<Integer> list = new ArrayList<Integer>();
			int count = 0;
			for(int j=i;j<sum;j++){
				list.add(j);
				count +=j;
				if(count == sum){
					alist.add(list);
					break;
				}else if(count > sum){
					break;
				}
			}
		}

		return alist;
	}
	//和为S的两个数
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		int len = array.length;
		ArrayList<Integer> alist = new ArrayList<Integer>();
		if(len < 2||array == null)
			return alist;
		int i = 0;
		int j = len-1;
		while(i<j){			
			if(array[i]+array[j]==sum){
				alist.add(array[i]);
				alist.add(array[j]);				
			}else if(array[i]+array[j] > sum){
				--j;
			}else{
				++i;
			}						
		}
		return alist;
	}
	//反转单词
	public String ReverseSentence(String str) {
		int len = str.length();
		if(len == 0){
			return "";
		}
		String []strs = str.trim().split(" ");
		StringBuffer sb = new StringBuffer();
		for(int i=strs.length-1;i>=0;i--){
			if(i == 0){
				sb.append(strs[i]);
				
			}else{
				sb.append(strs[i]);
				sb.append(" ");
			}
		}
		String str2 = sb.toString().trim();
		return str2;
	}
	//抽顺子问题
//	1、排序 
//	2、计算所有相邻数字间隔总数 
//	3、计算0的个数 
//	4、如果2、3相等，就是顺子 
//	5、如果出现对子，则不是顺子
	public boolean isContinuous(int [] numbers) {
			int numofzero = 0;
			int numofinterval = 0;
			int len = numbers.length;
			if(len == 0)
				return false;
			Arrays.sort(numbers);
			for(int i=0;i<len;i++){
				if(numbers[i] == 0){
					numofzero++;
				}
				if(numbers[i] == numbers[i+1]){
					return false;
				}
				numofinterval += numbers[i+1]-numbers[i]-1;
			}
			if(numofzero>=numofinterval){
				return true;
			}
			return false;
	}
}
