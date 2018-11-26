package com.wimb.A;

import java.util.*;

public class A2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		String a = "11";
		//		String b = "11";
		//		System.out.print(new A2().BigNumberAdd1(a, b));
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(6);
		
		a1.next = a3;
		a3.next = a5;
		
		a2.next = a4;
		a4.next = a6;
		
		Merge(a1,a2);
	}
	//二进制个数
	public static void toBinary() {
		int count = 0;
		int n = 12;
		int flag = 1;
		while(flag  != 0){ //每次右移直至这个数超过int表示的最大数值范围，超过范围再右移变为0
			if((n&flag) != 0){
				count++;
			}
			flag = flag << 1;
			System.out.println((int)flag);
		}
		System.out.println("//");
		System.out.print(count);
	}
	//反转单链表1:借助栈	
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		while(listNode != null){
			stack.push(listNode.value);
			listNode = listNode.next;
		}
		while(!stack.isEmpty()){
			arraylist.add(stack.pop());
		}
		return arraylist;

	}
	//反转单链表2
	public static ListNode reverserlistNode(ListNode listnode){
		if(listnode != null)
			return listnode;

		ListNode pre = null;
		ListNode now = listnode;
		while(now != null){
			ListNode next = now.next;
			next.next = pre;
			pre = now;
			now = next;

		}
		return pre;
	}


	//旋转数组的最小值
	public int minNumberInRotateArray(int [] array) {
		if(array == null) return 0;

		for(int i=0;i<array.length;i++){
			if(array[i]>array[i+1])
				return array[i+1];
		}

		return array[0];
	}
	//斐波那契
	public int Fibonacci(int n) {
		if(n == 0) return 0;
		if(n == 1||n == 2) return 1;
		return Fibonacci(n-1)+Fibonacci(n-2);
	}
	////斐波那契的改进  复杂度为O(n)
	public int Fibonacci1(int n) {
		int fiOne = 1;
		int fiTwo = 1;
		int fiN = 0;

		if(n<3){
			return 1;
		}

		while(n > 2){
			fiN =fiOne +fiTwo;
			fiOne = fiTwo;
			fiTwo = fiN;
			n--;
		}

		return fiN;

	}

	//青蛙跳台阶问题，斐波那契的小应用
	public int JumpFloor(int target) {
		if(target == 1) return 1;
		if(target == 2) return 2;
		return JumpFloor(target-1)+1 +JumpFloor(target-2)+2;
	}
	//青蛙跳台阶变态版
	public int JumpFloorII(int target) {
		if(target <0){
			return -1;
		}else if(target == 1){
			return 1;
		}else{
			return 2*JumpFloorII(target-1);
		}
	}
	//方块放置问题
	public int RectCover(int target) {
		if(target<0){
			return 0;
		}else if(target == 1||target ==2){
			return target;
		}else{
			return RectCover(target-1)+RectCover(target-2);
		}
	}
	//输出二进制表示中1的个数 - 位运算问题
	//方法一：调用函数
	public int NumberOf1(int n) {
		int count = 0;
		String str = Integer.toBinaryString(n);
		for(int i=0;i<str.length();i++){
			if(str.charAt(i) == '1')
				count++;
		}
		return count;
	}
	//方法二：利用位运算
	public int NumberOf2(int n) {
		int count = 0;
		int flag = 1;
		while(flag != 0){
			if((flag&n) != 0)
				flag = flag<<1;
		}
		return count;
	}
	//方法三：位运算的正确使用
	public int NumberOf3(int n) {
		int count = 0;
		while(n!=0){
			++count;
			n = n&(n-1);
		}
		return count;
	}
	//调整数组位置，奇数位在前，偶数位在后
	public void reOrderArray(int [] array) {
		int len = array.length;
		int arrayCopy[] = new int[len];
		for(int i=0;i<len;i=i*2){
			arrayCopy[i] = array[i];
		}
		for(int i=0;i<len;i=i*2+1){
			arrayCopy[i] = array[i];
		}
		for(int i=0;i<len;i++){
			array[i] = arrayCopy[i];
		}
	}
	//调整数组位置2，利用List
	public void reOrderArray1(int [] array) {
		ArrayList <Integer>list1= new ArrayList<Integer>();

		int len = array.length;

		for(int i=0;i<len;i++){
			if(array[i]%2 == 0){
				list1.add(array[i]);
			}
		}
		for(int i=0;i<len;i++){
			if(array[i]%2 != 0){
				list1.add(array[i]);
			}
		}

		for(int i=0;i<len;i++){
			array[i] = list1.indexOf(i);
		}
	}
	//大数加法问题（不考虑符号问题，只有正时）
	public static String BigNumberAdd(String a,String b){
		if(a == null) return b;
		if(b == null) return a;

		StringBuffer sta = new StringBuffer(a).reverse();
		StringBuffer stb = new StringBuffer(b).reverse();
		StringBuffer st = new StringBuffer();

		int len1 = a.length();
		int len2 = b.length();

		if(len1>len2){
			int count = len1 - len2;
			while(count-->0){
				stb.append('0');
			}
		}else{
			int count = len2 - len1;
			while(count-->0){
				sta.append('0');
			}
		}

		int overflow = 0;
		int sum;

		for(int i=0;i<sta.length();i++){
			sum = sta.charAt(i) - '0' +stb.charAt(i) - '0' +overflow;
			if(sum>=10){
				overflow = 1;
				sum = sum - 10;
				st.append(String.valueOf(sum));
			}else{
				overflow = 0;
				st.append(String.valueOf(sum));
			}
		}

		if(overflow == 1){
			st.append('1');
		}

		return st.reverse().toString();		
	}
	//默写
	public static String BigNumberAdd1(String a,String b){
		if(a == null) return b;
		if(b == null) return a;

		StringBuffer sta = new StringBuffer(a).reverse();
		StringBuffer stb = new StringBuffer(b).reverse();
		StringBuffer st = new StringBuffer();

		int len1 = sta.length();
		int len2 = stb.length();

		if(len1 > len2){
			int count = len1 - len2;
			while(count-->0){
				stb.append('0');
			}
		}else{
			int count = len2 - len1;
			while(count-->0){
				sta.append('0');
			}
		}

		int overflow = 0;
		int sum =0;
		for(int i=0;i<sta.length();i++){
			sum = (int)(sta.charAt(i) - '0') +(int)(stb.charAt(i) - '0') + overflow;
			if(sum >= 10 ){
				overflow = 1;
				sum = sum -10;
				st.append(String.valueOf(sum));
			}else{
				overflow = 0;
				st.append(String.valueOf(sum));
			}
		}

		if(overflow == 1){
			st.append('1');
		}

		return st.reverse().toString();

	}
	//大数减法问题
	public static String BigNumberMinus(String a,String b){
		int len1 = a.length();
		int len2 = b.length();

		int []arrayA = new int[len1];
		int []arrayB = new int[len2];
		//变成整型字节数组
		for(int i=0;i<len1;i++){
			arrayA[i] = Integer.parseInt(a.substring(i, i+1));
		}

		for(int i=0;i<len2;i++){
			arrayB[i] = Integer.parseInt(b.substring(i, i+1));
		}

		boolean flag = false;
		if(len1 < len2){
			int c[] = arrayA;
			arrayA = arrayB;
			arrayB = c;
			flag = true;
		}

		int a_len = len1 - 1;
		int b_len = len2 - 1;

		int degree = 0;

		while(a_len>=0||b_len>=0){
			int temp = 0;

		}






		return b;
	}
	//StringToInt 字符串转整型数组
	public static int[] StringsToInt(String str){
		int len = str.length();
		int [] a = new int[len];
		for(int i=0;i<len;i++){
			a[i] = Integer.parseInt(str.substring(i,i+1));
		}
		return a;
	}
	//大数乘法 - 错误❌
	public static String BigNumberMulti(String f,String s){
		//获取符号位，判断是否是符号为
		char signA = f.charAt(0);
		char signB = s.charAt(0);
		char sign = '+';

		if(signA == '-'||signA == '+'){
			sign = signA;
			f = f.substring(1);
		}

		if(signB == '-'||signB == '+'){
			if(sign == signB){
				sign = '+';
			}else{
				sign = '-';
			}
			s = s.substring(1);
		}

		//将两个数组转换为字符数组，同时进行反转
		char []a = new StringBuffer(f).reverse().toString().toCharArray();
		char []b = new StringBuffer(s).reverse().toString().toCharArray();

		int lenA = a.length;
		int lenB = b.length;
		//计算最终长度
		int len = lenA + lenB;
		int []result = new int[len];

		//计算结果集合
		for(int i=0;i<a.length;i++){
			for(int j=0;j<b.length;j++){
				result[i+j] += ((int)(a[i]-'0'))*((int)(b[j]-'0'));
			}
		}
		//处理结果集合,如果当前数值大于10就像前进一位，本身进行除10取余操作
		for(int i=0;i<result.length;i++){
			if(result[i]>=10){
				result[i+1] +=result[i]/10;
				result[i] = result[i]%10;
			}
		}

		StringBuffer sb = new StringBuffer();
		//该字段用于标记前置是否为0，如果是0则不需要进行打印或者存储下来
		boolean flag =true;

		for(int i = len -1;i>=0;i--){
			if(result[i] == 0&&flag){
				continue;
			}else{
				flag = false;
			}
			sb.append(result[i]);
		}

		if(sb.toString().equals("")){
			if(sign == '-'){
				sb.insert(0,sign);
			}
		}else{
			sb.append(0);

		}

		return sb.toString();

	}
	//输出倒数第k个节点:p2先走k-1个空格，p1和p2再一起走即可
	//方法归纳：链表中用两个指针的方法适用于 求链表中间节点，判断链表是否是环形等问题。
	public ListNode FindKthToTail(ListNode head,int k){
		if(head == null) return null;
		ListNode p1 = head;
		ListNode p2 = head;
		for(int i=0;i<k;i++){
			if(p2 == null) return null;
			p2 = p2.next;
		}
		if(p2 == null) return null;
		while(p2.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	//合并两个有序链表:普通写法
	public static ListNode Merge(ListNode list1,ListNode list2) {
		if(list1 == null) return list2;
		if(list2 == null) return list1;
		ListNode listhead = null;
		if(list1.value < list2.value){
			listhead = new ListNode(list1.value);
			list1 = list1.next;
		}else{
			listhead = new ListNode(list2.value);
			list2 = list2.next;
		}
		ListNode p = listhead;
		while(list1!=null && list2.next!=null){
			if(list1.value<list2.value){
				ListNode newnode = new ListNode(list1.value);
				list1 = list1.next;
				p.next = newnode;
				p = newnode;
			}else{
				ListNode newnode = new ListNode(list2.value);
				list2 = list2.next;
				p.next = newnode;
				p = newnode;
			}

		}
		while(list1!=null){
			ListNode newnode = new ListNode(list1.value);
			list1 = list1.next;
			p.next = newnode;
			p = newnode;
		}
		while(list2!=null){
			ListNode newnode = new ListNode(list2.value);
			list2 = list2.next;
			p.next = newnode;
			p = newnode;
		}
		return listhead;
	}

	//合并两个有序链表:递归写法
	//1 3 5   
	//2 4
	public ListNode Merge1(ListNode list1,ListNode list2){
		if(list1 == null) 
			return list2;
		if(list2 == null) 
			return list1;
		ListNode head = null;
		if(list1.value < list2.value){
			head = list1;
			head.next = Merge1(list1.next,list2);
		}else{
			head = list2;
			head.next = Merge1(list1,list2.next);
		}
		return head;
	}
}

