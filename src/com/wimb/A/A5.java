package com.wimb.A;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class A5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode r1 = new TreeNode(1);
//		TreeNode r2 = new TreeNode(2);
//		TreeNode r3 = new TreeNode(3);
//		TreeNode r4 = new TreeNode(4);
//		TreeNode r5 = new TreeNode(5);
//		TreeNode r6 = new TreeNode(6);
//		TreeNode r7 = new TreeNode(7);
//		r1.left = r2;
//		r1.right = r3;
//		r2.left = r4;
//		r2.right = r5;
//		r3.left = r6;
//		r3.right = r7;
//
//		ArrayList <ArrayList<Integer>>ll = new A5().Print(r1);
//		for(int i=0;i<ll.size();i++){
//			ArrayList<Integer> kk = new ArrayList<Integer>();
//			for(int j=0;j<kk.size();j++){
//				System.out.println(kk.get(j));
//			}
//		}
		A5 a5 = new A5();
		System.out.print(a5.LastRemaining_Solution(10, 5));

		//		ListNode l1 = new ListNode(1);
		//		ListNode l2 = new ListNode(2);
		//		ListNode l3 = new ListNode(3);
		//		ListNode l4 = new ListNode(4);
		//		ListNode l5 = new ListNode(5);
		//		ListNode l6 = new ListNode(6);
		//		l1.next = l2;
		//		l2.next = l3;
		//		l3.next = l4;
		//		l4.next = l5;
		//		l5.next = l6;
		//		l6.next = l3;
		//		System.out.print(new A5().EntryNodeOfLoop1(l1

		//		ListNode p1 = new ListNode(1);
		//		ListNode p2 = new ListNode(2);
		//		ListNode p3 = new ListNode(3);
		//		ListNode p4 = new ListNode(3);
		//		ListNode p5 = new ListNode(4);
		//		ListNode p6 = new ListNode(4);
		//		ListNode p7 = new ListNode(5);
		//		p1.next = p2;
		//		p2.next = p3;
		//		p3.next = p4;
		//		p4.next = p5;
		//		p5.next = p6;
		//		p6.next = p7;
		//		
		//		new A5().deleteDuplication(p1);
		//		while(p1!=null){
		//			System.out.println(p1.value);
		//			p1 = p1.next;
		//		}

	}
	/**
	 * 数组解决约瑟夫环问题
	 * @param 总人数
	 * @param 报到退出的数字
	 * @return
	 */
	public int LastRemaining_Solution(int n, int m) {
		if(n<1||m<1)
			return -1;
		int arr[] = new int [n];
		int i = -1;
		int count = n;
		int step = 0;
		while(count>0){
			i++;
			if(i >= n) i=0;
			step++;
			if(arr[i] == -1) continue;
			if(arr[i] == m){
				arr[i] = -1;
				count--;
			}
		}
		return i;
	}
	/**
	 * 利用队列解决约瑟夫环问题
	 * @param n
	 * @param m
	 * @return
	 */
	public int LastRemaining_Solution2(int n, int m) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int tmp = 0;
		for(int i=0;i<n;i++){
			queue.add(i+1);
		}

		int count=0;
		while(!queue.isEmpty()){
			Integer person = queue.poll();
			count++;
			if(count%m == 0){
				tmp = person;
			}else{
				queue.add(person);
			}
		}
		return tmp;
	}
	//不用加法完成加法操作
	public int Add(int num1,int num2){
		while(num2!=0){
			int temp = num1&num2;
			num2 = (num1&num2)<<1;
			num1 = temp;			 
		}
		return num1;		 
	}
	//字符串转整数
	public int StrToInt(String str){
		if(str == ""||str.length()<0)
			return 0;
		int sum =0;
		int f=0;
		char []nums = str.toCharArray();
		if(nums[0] == '-'){
			f =1; 
		}
		for(int i=f;i<str.length();i++){
			if(nums[i] == '+')
				continue;
			if(nums[i]<'0'||nums[i]>'9') return 0;
			sum = sum*10+nums[i]-'0';				 
		}
		return f==0?sum:sum*-1;
	}
	//数组中的重复数字
	public int duplicate(int numbers[]) {
		int len = numbers.length;
		if(len == 0||numbers == null){
			return -1;
		}
		HashMap <Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<len;i++){
			if(map.get(numbers[i]) != null){
				map.put(numbers[i], map.get(numbers[i]+1));
			}else{
				map.put(numbers[i], 1);
			}
		}

		for(int i=0;i<len;i++){
			if(map.get(numbers[i]) == 1)
				return numbers[i];
		}
		return 0;
	}
	//构建乘积数组
	public int[] multiply(int[] A) {
		int len = A.length;
		int []forward = new int[len];
		int []backward = new int[len];
		int []B = new int[len];
		forward[0] = 1;
		backward[0] = 1;
		for(int i=1;i<len;i++){
			forward[i] = A[i-1]*forward[i-1];
			backward[i] = A[len-i]*backward[i-1];
		}
		for(int i=0;i<len;i++){
			B[i] = forward[i]*backward[len-i-1];
		}
		return B;
	}


	//	public boolean isNumeric(char[] str) {
	//	    if(str.length<1){
	//	    	return false;
	//	    }
	//	    boolean flag = ScanInteger(str);
	//	    if(index<str.length&&str[index]=='.'){
	//	    	index++;
	//	    	flag = scanUnsignedInteger(str)||flag;
	//	    }
	//	    if(index<str.length&&(str[index]=='e'||str[index]=='E')){
	//	    	index++;
	//	    	flag = flag||ScanInteger(str);    		
	//	    }
	//	    return flag&&index == str.length;
	//	    
	//	}
	//	
	//	public boolean ScanInteger(char []str){
	//		if(index<str.length&&(str[index] == '+'||str[index] == '-')){
	//			index++;
	//		}
	//		return scanUnsignedInteger(str);
	//	}
	//	
	//	public boolean scanUnsignedInteger(char []str){
	//		int start = index;
	//		while(index<str.length&&str[index]>'0'&&str[index]<'9')
	//			index++;
	//		return start<index;
	//	}
	//链表有环的入口节点
	public ListNode EntryNodeOfLoop(ListNode pHead){
		if(pHead == null||pHead.next == null)
			return null;
		ListNode p1 = pHead;
		ListNode p2 = pHead;
		while(p2!=null&&p2.next!=null){
			p1 = p1.next;
			p2 = p2.next.next;
			if(p1 == p2){
				p2 = pHead;
				while(p1 != p2){
					p1 = p1.next;
					p2 = p2.next;
				}
				if(p1 == p2)
					return p2;
			}
		}
		return null;
	}
	//默写
	public ListNode EntryNodeOfLoop1(ListNode pHead){
		if(pHead == null||pHead.next == null)
			return null;
		ListNode p1 = pHead;
		ListNode p2 = pHead;
		while(p2!=null&&p2.next!=null){
			p1 = p1.next;
			p2 = p2.next.next;
			if(p1 == p2){
				p2 = pHead;
				while(p1 != p2){
					p1 = p1.next;
					p2 = p2.next;
				}
				if(p1 == p2)
					return p2;
			}
		}
		return null;
	}
	//找出中序遍历节点的下一个节点
	//三种情况：1.二叉树为空，返回空； 2.节点的右孩子存在，则沿着左孩子节点遍历至叶子节点；
	// 	        3.节点不是根节点，节点是父节点的左孩子，返回父节点
	//                                         右孩子，向上遍历至父节点
	public TreeNode GetNext(TreeNode pNode){
		if(pNode == null)
			return null;
		if(pNode.right!=null){
			TreeNode dd = pNode.right;
			while(dd.left!=null){
				dd = dd.left;
			}
			return dd;
		}
		while(pNode.next!=null){
			if(pNode.next.left == pNode) return pNode.next;
			pNode = pNode.next;
		}
		return null;
	}

	//判断二叉树是一个二叉树
	public boolean JudgeTree(TreeNode p1,TreeNode p2){
		if(p1 == null&&p2 == null)
			return true;
		if(p1 != null&&p2 == null)
			return false;
		if(p1 == null&&p2 != null)
			return false;
		return JudgeTree(p1.left,p2.left)&&JudgeTree(p1.right,p2.right);
	}

	//二叉树最小深度
	public int run(TreeNode root) {
		int min = 0; 
		if(root == null)
			return min;
		Deque <TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(queue.size()!=0){
			int len = queue.size();
			min++;
			for(int i=0;i<len;i++){
				TreeNode now = queue.poll();
				if(now.left!=null)
					queue.add(now.left);
				if(now.right!=null)
					queue.add(now.right);
				if(now.left == null&&now.right == null)
					return min;
			}
		}
		return min;

	}
	//删除重复节点
	public ListNode deleteDuplication(ListNode pHead)
	{
		ListNode prepHead;
		ListNode index=new ListNode(1);
		ListNode temp=pHead;
		index.next=pHead;
		prepHead=index;
		while(temp!=null){
			if(temp.next!=null&&temp.next.value==temp.value){
				while(temp.next!=null&&temp.next.value == temp.value){
					temp=temp.next;
				}
				temp=temp.next;
				index.next=temp;
			}else{
				temp=temp.next;
				index=index.next;
			}
		}
		return prepHead.next;

	}
	//按之字形打印二叉树
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
		ArrayList<ArrayList<Integer>> alist = new ArrayList<ArrayList<Integer>>();
		//存放奇数
		Stack <TreeNode>stack1 = new Stack<TreeNode>();
		//存放偶数
		Stack <TreeNode>stack2 = new Stack<TreeNode>();
		if(pRoot == null)
			return alist;
		stack1.push(pRoot);
		int layer = 1;
		while(!stack1.isEmpty()||!stack2.isEmpty()){
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			if(layer%2 == 0){
				while(!stack1.isEmpty()){
					TreeNode now = stack1.pop();
					if(now!=null){
						tmp.add(now.value);
						System.out.print(now.value + " ");
						if(now.left!=null){
							stack2.push(now.left);
						}
						if(now.right!=null){
							stack2.push(now.right);
						}
					}
					if(tmp!=null){
						alist.add(tmp);
						layer++;
						System.out.println();
					}
				}
			}else{
				ArrayList<Integer> tmp1 = new ArrayList<Integer>();
				while(!stack1.isEmpty()){
					TreeNode now = stack1.pop();
					if(now!=null){
						tmp.add(now.value);
						System.out.print(now.value + " ");
						if(now.right!=null){
							stack2.push(now.right);
						}
						if(now.left!=null){
							stack2.push(now.left);
						}
					}
					if(tmp!=null){
						alist.add(tmp1);
						layer++;
						System.out.println();
					}
				}
			}
		}
		return alist;	
	}
	//二叉树按层打印
	public ArrayList<ArrayList<Integer> > Print1(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> alist = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		if(pRoot == null){
			return alist;
		}
		queue.add(pRoot);
		int start = 0;
		int end = queue.size();
		while(queue.size()!=0){
			TreeNode now = queue.pop();
			list.add(now.value);
			start++;
			if(now.left!=null){
				queue.add(now.left);
			}
			if(now.right!=null){
				queue.add(now.right);
			}
			if(start == end){
				start = 0;
				alist.add(list);
				end = queue.size();
				list = new ArrayList<Integer>();
			}
			
		}
		return alist;
	}	
	//序列化二叉树	
	public String Serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if(root == null){
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.value+",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();
	}
	public int index = -1;
	//反序列化二叉树
	TreeNode Deserialize(String str) {
		index++;
		int len = str.length();
		if(index>=len){
			return null;
		}
		String [] strr = str.split(",");
		TreeNode node = null;
		if(!strr[index].equals("#")){
			node = new TreeNode(Integer.valueOf(strr[index]));
			node.left = Deserialize(str);
			node.right = Deserialize(str);			
		}
		return node;
	}
	
	
	
}

