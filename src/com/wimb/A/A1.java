package com.wimb.A;

import java.util.ArrayList;
import java.util.Stack;

//���ݽṹ�����飬�����ڴ治���������ַ����������ַ�������ջ����У������ʾ�����������ֱ�������ͼ �� �������ݽṹ��
//�㷨������ָoffer��68�⣬ţ������С֪ʶ��+�㷨�⣩��Leetcode��רҵ���ƽ̨���ҹ������⣩

//------���㷨˼·����Ҫ�ģ�˼·����Ҫ��˼·����Ҫ����������Ҫ���Լ��Ľ����ʩ


/**
 * ����ָoffer������Ŀ���롷 - Javaʵ��
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
	//�ڶ�ά��������ĳ��ֵ������
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


	//��������ķ�ת��
	//����һ���ݹ鷨�����ҵ����һ���ڵ㣬Ȼ������һ����ʼ��ת,Ȼ��ǰ�ڵ㷴תʱ�����Ľڵ��Ѿ����з�ת�ˣ�����Ҫ�ܡ���󷵻�ԭ�������һ���ڵ�
	public static ListNode reverse1(ListNode head){
		if(head.next == null) return head;
		ListNode next = head.next;
		head.next = null;
		ListNode re = reverse1(next);
		next.next = head;
		return re;
	}

	//�����������������Ƚ���һ�ڵ��¼������Ȼ���õ�ǰ�ڵ�ָ����һ�ڵ㣬�ٽ���ǰ�ڵ��¼����,������һ�ڵ��Ϊ��ǰ�ڵ�
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

	//��ת������1
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
	//��ת������2
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
	//�����������n���ڵ�
	//	 public ListNode FindKthToTail(ListNode head,int k) {
	//		 
	//	 }

	//������������1���ֵĴ���
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