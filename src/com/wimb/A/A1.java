package com.wimb.A;

import java.util.ArrayList;
import java.util.Stack;

//数据结构：数组，链表（内存不连续），字符串（常量字符串），栈与队列（互相表示），树（几种遍历），图 — 《大话数据结构》
//算法：《剑指offer》68题，牛客网（小知识点+算法题），Leetcode（专业编程平台，找工作真题）

//------》算法思路很重要的，思路很重要，思路很重要！！！必须要有自己的解决措施


/**
 * 《剑指offer所有题目代码》 - Java实现
 * @author Wimb
 *
 */
public class A1 {

	private ListNode listNode;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//  1 2 3 
		//  2 3 4 
		//  3 4 5

		int a[][] = {{1,2,3},{2,3,4},{3,4,5}};
		//System.out.print(Find(16,a));
		//		StringBuffer str = new StringBuffer("hello world");
		//		System.out.print(new A1().replaceSpace(str));

		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		a1.next = a2;
		a2.next = a3;
		new A1().printListFromTailToHead(a1);


	}
	//在二维数组中找某个值的问题
	public static boolean Find(int target,int a[][]){
		if(a == null ) return false;
		int rlen = a.length;
		int clen = a[0].length;
		int i = 0;
		int j = 0;
		int flag = j;
		while(i < rlen){
			if(target > a[i][j]){
				flag=j;
				while(j<clen){
					if(target > a[i][j]) j++;
					else if(target < a[i][j]) break;
					else if(target == a[i][j]) return true;
				}
			}
			j = flag;
			if(target == a[i][j]) return true;
			i++;
		}
		return false;
	}
	public static boolean Find1(int target,int array[][]){
		int rlen = array.length;
		int clen = array[0].length;
		int i = rlen - 1;
		int j = 0;
		while(i>=0&&j<clen){
			if(target<array[i][j]) i--;
			else if(target>array[i][j]) j++;
			else return true;
		}

		return false;
	}
	public static String replaceSpace(StringBuffer str){
		//		int len = str.length();
		//		for(int i=0;i<len;i++){
		//			if(str.charAt(i) == ' '){
		//				str.setCharAt(i, '%');
		//			}
		//		}
		char a[] = str.toString().toCharArray();
		int len = a.length;
		char b[] = new char [100];
		int j=0;
		for(int i=0;i<len;i++){
			if(a[i] != ' ') b[j++]=a[i];
			if(a[i] == ' '){
				b[j++] = '%';
				b[j++] = '2';
				b[j++] = '0';
			}

		}
		return new String(b).trim();

		//StringBuffer str1=new StringBuffer("asd").append("asd");
		//System.out.print(str1);
	}


	//《单链表的反转》
	//方法一：递归法。先找到最后一个节点，然后从最后一个开始反转,然后当前节点反转时其后面的节点已经进行反转了，不需要管。最后返回原来的最后一个节点
	public static ListNode reverse1(ListNode head){
		if(head.next == null) return head;
		ListNode next = head.next;
		head.next = null;
		ListNode re = reverse1(next);
		next.next = head;
		return re;
	}

	//方法二：迭代法。先将下一节点纪录下来，然后让当前节点指向上一节点，再将当前节点纪录下来,再让下一节点变为当前节点
	public static ListNode reverse2(ListNode head){
		ListNode pre = null;
		ListNode now = head;
		while(head != null){
			ListNode next = now.next;
			now.next = pre;
			pre = now;
			now = next;
		}
		return pre;
	}

	//反转单链表1
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> al= new ArrayList<Integer>();

		if(listNode == null) return al;

		ListNode pre = null;
		ListNode now = listNode;
		while(now != null){
			ListNode next = now.next;
			now.next = pre;
			pre = now;
			now = next;
		}


		while(pre != null){
			al.add(pre.value);
			pre = pre.next;
		}
		return al;	
	}
	//反转单链表2
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
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
	//	public static boolean Find3(int target,int a[][]){
	//		int rlen = a.length;
	//		int clen = a[0].length;
	//		int i = rlen-1;
	//		int j = 0;
	//		while(i>=0&&j<clen){
	//			if(a[i][j] < target) j++;
	//			else if(a[i][j] >target) i--;
	//			else{
	//				return true;
	//				}
	//			}
	//		return false;
	//		}

	public ListNode revserve3(ListNode listnode){
		ListNode pre = null;
		ListNode now = listnode;
		while(now != null){
			ListNode next = now.next;
			now.next = pre;
			pre = now;
			now =next;
		}
		return pre;
	}
	//输出链表倒数第n个节点
	//	 public ListNode FindKthToTail(ListNode head,int k) {
	//		 
	//	 }

	//【问题描述】1出现的次数
	public int NumberOf1Between1AndN_Solution(int n) {
		int sum = 0;
		for(int i=1;i<=n;i++){
			sum +=getNum(n);
		}
		return sum;
	}
	
	public static int getNum(int num){
		int sum =0;
		while(num != 0){
			int now = num%10;
			if(now == 1){
				sum++;
			}
			num = num/10;
			
		}
		return sum;
	}
}
class ListNode{
	int value;
	ListNode next = null;
	ListNode(int value){
		this.value = value;
	}
}