package com.wimb.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class A3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		int a[]= {4,2,5,1,6,3};
		//		int b[]=Arrays.copyOfRange(a, 0, 3); 
		//		for(int i=0;i<b.length;i++){
		//			System.out.print(b[i]);
		//		}

		//		int a[][]={{1,2,3},{4,5,6},{7,8,9}};
		//		ArrayList <Integer>list = new ArrayList<Integer>();
		//		list = new A3().printMatrix(a);
		//		for(int i=0;i<list.size();i++){
		//			System.out.print(list.indexOf(i));
		//		}

	}

	//˳ʱ���ӡ����
	public ArrayList<Integer> printMatrix(int [][] matrix) {
		int left=0,right=matrix[0].length-1,top=0,boom= matrix.length-1;//��¼�ĸ��ǵ�λ��
		ArrayList<Integer> list = new ArrayList<Integer>();

		while((right>left)&&(boom>top)){
			for(int i=left;i<=right;i++){//������
				list.add(matrix[top][i]);
			}
			for(int i=top+1;i<=boom;i++){//�ϵ���
				list.add(matrix[i][right]);
			}
			for(int i = right-1;i>=left;i--){//�ҵ���
				list.add(matrix[boom][i]);
			}
			for(int i = boom-1;i>top;i--){//�µ��� ,ע���ʱ��top��û�� ��
				list.add(matrix[i][left]);
			}
			left++;
			right--;
			top++;
			boom--;
		}

		if((boom==top)&&(left<right)){//����ʣ��һ�е����
			for(int i=left;i<=right;i++){
				list.add(matrix[top][i]);
			}
		}
		if((left==right)&&(boom>top)){//����ʣ��һ�е����
			for(int i =top;i<= boom;i++){
				list.add(matrix[i][left]);
			}
		}
		if((boom==top)&&(right==left)){//����ʣ��һ��Ԫ�ص����
			list.add(matrix[left][boom]); 
		}
		return list;
	}
	//������ת��Ϊ�������ľ���:�ݹ�ʵ��
	public void Mirror(TreeNode root) {
		if(root == null)
			return;
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		if(root.left!=null){
			Mirror(root.left);			
		}
		if(root.right!=null){
			Mirror(root.right);
		}
	}
	//�ж��Ƿ��ǵ�ǰ�����ӽṹ,���벿��1
	public static boolean HasSubTree(TreeNode root1,TreeNode root2){
		boolean result = false;
		if(root1.value == root2.value){
			result = isSubTree(root1, root2);
			if(!result){
				result = HasSubTree(root1.left, root2);
			}
			if(!result){
				result = HasSubTree(root1.right, root2);
			}
		}
		return result;


	}
	//���벿��2
	public static boolean isSubTree(TreeNode root1,TreeNode root2){
		if(root2 == null)
			return true;
		if(root1 == null)
			return false;
		if(root1.value != root2.value)
			return false;
		return isSubTree(root1.left, root2.left)&&isSubTree(root1.right, root2.right);
	}

	//�ؽ�������:�������������ǰ���������������
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		if(pre.length == 0 ||in.length == 0) 
			return null;
		TreeNode root = new TreeNode(pre[0]);
		for(int i=0;i<pre.length;i++){
			if(in[i] == pre[i]){
				if(i == 0){
					root.left = null;
					root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1 ,pre.length),Arrays.copyOfRange(in, i+1, in.length));
				}else if(i == pre.length){
					root.right = null;
					root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1 ,i+1),Arrays.copyOfRange(in, 0, i));
				}else{
					root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1 ,i+1),Arrays.copyOfRange(in, 0, i));
					root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length),Arrays.copyOfRange(in, i+1, in.length));
				}
			}
		}
		return root;
	}
	//�ؽ�������:����+ǰ��
	public TreeNode reConstructBinaryTree2(int [] pre,int [] in) {
		TreeNode root = new TreeNode(pre[0]);

		int len=pre.length;

		if(len ==1){
			root.left = null;
			root.right = null;
			return root;
		}

		int i;
		int rootvalue = root.value;
		for(i=0;i<len;i++){
			if(rootvalue == in[i]){
				break;
			}
		}
		if(i>0){
			int []preo = new int[i];
			int []ino = new int[i];
			for(int j=0;j<i;j++){
				preo[j] = pre[j+1];
				ino[j] = in[j];
			}
			root.left = reConstructBinaryTree3(preo, ino);
		}else{
			root.left = null;
		}

		if(len-i-1>0){
			int preo[] = new int[len-i-1];
			int ino[] = new int[len-i-1];
			for(int j=i;j<len;j++){
				preo[len-j-1] = pre[j];
				ino[len-j-1] = in[j];
			}
			root.right = reConstructBinaryTree3(preo, ino);
		}else{
			root.right = null;
		}
		return root;

	}
	//Ĭд:����+ǰ�� -- ����������
	public TreeNode reConstructBinaryTree3(int [] pre,int [] in) {
		TreeNode root = new TreeNode(pre[0]);

		int len = pre.length;		
		if(len == 1){
			root.left = null;
			root.right = null;
			return root;
		}

		int rootvalue = root.value;
		int i;
		for(i=0;i<len;i++){
			if(rootvalue == in[i]) 
				break;
		}

		if(i>0){
			int preo[] = new int[i];
			int ino[] = new int[i];
			for(int j=0;j<i;j++){
				preo[j] = pre[j+1];
				ino[j] = in[j];
			}
			root.left = reConstructBinaryTree3(preo, ino);
		}else{
			root.left = null;
		}

		if(len-i-1>0){
			int preo[] = new int[len-i-1];
			int ino[] = new int[len-i-1];
			for(int j=i+1;j<len;j++){
				preo[j-i-1] = pre[j];
				ino[j-i-1] = in[j];
			}
			root.right = reConstructBinaryTree3(preo, ino);
		}else{
			root.right = null;
		}
		return root;

	}

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		int first = stack2.pop();
		while(!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
		return first;
	}


	Stack <Integer>stack11 = new Stack<Integer>();
	Stack <Integer>stack22 = new Stack<Integer>();
	//����������СԪ�ص�ջmin
	public void push1(int node) {
		//��ʼ��״̬
		if(stack1.isEmpty()){
			stack11.push(node);
			stack22.push(node);
		}else{
			stack11.push(node);
			if(node < stack22.peek()){
				stack22.push(node);
			}
		}


	}

	public void pop1() {
		int tm = stack11.pop();
		if(tm == stack22.peek()){
			stack22.pop();
		}
	}

	public int top1() {
		return (int) stack11.peek();

	}

	public int min1() {
		return (int)stack22.peek();

	}
	//�ж������Ƿ���ջ�ĵ�������
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		if(pushA.length != popA.length) 
			return false;

		if(pushA.length == 0||popA.length == 0)
			return false;

		int index = 0;
		Stack <Integer>stack = new Stack<Integer>();
		for(int i=0;i<pushA.length;i++){
			stack.push(pushA[i]);

			while(index<popA.length&&popA[index] == stack.peek()){
				stack.pop();
				index++;
			}
		}
		return stack.isEmpty();

	}
	//�������Ĳ������
	//������������---���У�
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Deque <TreeNode> deque = new LinkedList<TreeNode>();
		deque.add(root);
		while(!deque.isEmpty()){
			TreeNode now = deque.pop();
			list.add(now.value);
			if(now.left!=null){
				deque.add(now.left);
			}
			if(now.right!=null){
				deque.add(now.right);
			}
		}
		return list;
	}	

	//�ж�ĳ�����������ĺ�������Ƿ���ȷ
	//˼�룺����һ���������ĺ������������˵�����һ����һ���Ǹ��ڵ㣬Ȼ��ǰ������У����ʼ����һ�����ڸ��ڵ���������������е�����
	//      �����浽�����ڶ�����Ӧ�ö��Ǵ��ڸ��ڵ�ģ�������������������������С�ڸ��ڵ�ģ���ô˵��������в��Ƕ����������ĺ����������

	//�ж�ǰ������ˣ�˼·���ǽ����в�ֳ� �������������������֣����õݹ�˼����ɲ�����
	public boolean VerifySquenceOfBST(int [] sequence) {
		int len = sequence.length;
		if(len <=  0)
			return false;
		int i = 0;
		int root = sequence[len-1];
		for(;i<len-1;i++){
			if(root<sequence[i]){
				break;
			}
		}

		int j=i;
		for(;j<len-1;j++){
			if(sequence[j]<root){
				return false;
			}
		}

		boolean judgeleft = true;
		boolean judgeright = true;

		if(i>0){
			judgeleft = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
		}
		if(j<len-1){
			judgeright = VerifySquenceOfBST(Arrays.copyOfRange(sequence,j, len-1));
		}
		return judgeleft&&judgeright;
	}

	//�ҵ��������е�ָ����ֵ��·��
	//˼·��

	//	1.�ж����Ƿ�Ϊnull���Ƿ�ֻ�и��ڵ� 

	//	2.��ǰ������������������ȷ��ʽڵ㣬Ȼ�󽫽ڵ�����У���ջ���ɣ���������ֵ��֮ǰ����е��ܺ�num��� 

	//	ps:����������ջ����������ţ������ˢ�⣬���ⷵ��ֵΪ���У���ʹ�ö��У���ʵ����ࡣջ��ֱ����pop����������ջ�Ľڵ㵯����
	//	������ʹ��move(list.size()-1)�������ӵĽڵ㵯���� 

	//	3.�жϵ�ǰ֮�ͷ��������ֵ���жϵ�ǰ�ڵ��Ƿ�Ҷ�ڵ㡣 ����ǰֵ���ڸ���ֵ���ҵ�ǰ�ڵ���Ҷ�ڵ㣬���ӡ·����Ϣ�� 
	//	����ǰֵС�ڸ���ֵ���ҵ�ǰ�ڵ㲻��Ҷ�ڵ㣬��ݹ���øýڵ������������ ����ǰֵ���ڸ���ֵ������ݹ��ˣ���Ĭ�Ͻڵ�ֵΪ����������£�
	ArrayList <ArrayList<Integer>>list = new ArrayList <ArrayList<Integer>>();
	ArrayList <Integer> arr = new ArrayList<Integer>();
	int num = 0;
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		if(root == null)
			return list;
		arr.add(root.value);
		num += root.value;

		boolean isLeaf = (root.left==null)&&(root.right==null);

		if((num == target)&&isLeaf){
			ArrayList<Integer> now = new ArrayList<Integer>();
			for(int i=0;i<arr.size();i++){
				now.add(arr.get(i));
			}
			list.add(now);
		}

		if((num < target)&&root.left!=null){
			FindPath(root.left,target);
		}

		if((num<target)&&(root.right!=null)){
			FindPath(root.right,target);
		}


		arr.remove(arr.size()-1);
		num -= root.value;

		return list;
	}
	//���Ƹ�������:����������������ָ�룬���
	public RandomListNode Clone(RandomListNode pHead){
		if(pHead == null)
			return null;
		RandomListNode currentNode = pHead;
		//(1)���Ƹ�������������������ֵܽڵ�
		while(currentNode != null){
			RandomListNode newnode = new RandomListNode(currentNode.label);
			RandomListNode nextnode = currentNode.next;
			newnode.next = nextnode;
			currentNode.next = newnode;
			currentNode = newnode.next;
		}
		//(2)���ݾ�������ֵܽڵ㣬��ʼ��������ֵܽڵ�
		currentNode = pHead;
		while(pHead != null){
			RandomListNode clonenode = currentNode.next;
			clonenode.next = currentNode.random == null? null:currentNode.random.next;
			currentNode = clonenode.next;
		}

		//(3)��ֵõ�������
		currentNode = pHead;
		RandomListNode pCloneHead = pHead.next;
		while(currentNode != null){
			RandomListNode cloneNode = currentNode.next;
			currentNode.next = cloneNode.next;
			cloneNode.next = cloneNode.next ==null? null:cloneNode.next.next;
			currentNode = currentNode.next;
		}
		return pCloneHead;


	}

	//�����������ת��Ϊ˫������ ���
	//˼·���ǵݹ�����������������޸�ָ�뼴��
	public TreeNode Convert(TreeNode pRootOfTree) {
		TreeNode p = pRootOfTree;
		TreeNode pre = null;
		boolean isFirst = true;
		Stack <TreeNode>stack = new Stack<TreeNode>();
		while(p!=null||!stack.isEmpty()){
			while(p!=null){
				stack.push(p);
				p = p.left;
			}
			p = stack.pop();
			if(isFirst){
				pRootOfTree = p; //��������������еĵ�һ���ڵ��Ϊroot
				pre = pRootOfTree;
				isFirst = false;				
			}else{
				pre.right = p;
				p.left = pre;
				pre = p;
			}
			p = p.right;			
		}
		return pRootOfTree;
	}

	//������ǰ��������ݹ�
	public static void  PreOrder(TreeNode root){
		if(root != null){
			System.out.print(root.value);
			PreOrder(root.left);
			PreOrder(root.right);
		}
	}

	//��������ǰ��������ǵݹ�
	//	������һ���P��
	//
	//    1)���ʽ��P���������P��ջ;
	//
	//    2)�жϽ��P�������Ƿ�Ϊ�գ���Ϊ�գ���ȡջ����㲢���г�ջ����������ջ�������Һ�����Ϊ��ǰ�Ľ��P��ѭ����1);
	//	        ����Ϊ�գ���P��������Ϊ��ǰ�Ľ��P;
	//
	//    3)ֱ��PΪNULL����ջΪ�գ������������
	public static void PreOrder1(TreeNode root){
		Stack <TreeNode>stack = new Stack<TreeNode>();
		TreeNode p = root;
		while(p != null||!stack.isEmpty()){
			while(p!=null||!stack.isEmpty()){
				System.out.print(p.value);
				stack.push(p);
				p = p.left;
			}
			if(!stack.isEmpty()){
				p = stack.pop();
				stack.pop();
				p = p.right;
			}
		}
	}

	//����������������ݹ�
	public static void  InOrder(TreeNode root){
		if(root != null){				
			PreOrder(root.left);
			System.out.print(root.value);
			PreOrder(root.right);
		}
	}

	//����������������ǵݹ�
	//	������һ���P��
	//
	//	  ��1)�������Ӳ�Ϊ�գ���P��ջ����P��������Ϊ��ǰ��P��Ȼ��Ե�ǰ���P�ٽ�����ͬ�Ĵ���
	//
	//	 �� 2)��������Ϊ�գ���ȡջ��Ԫ�ز����г�ջ���������ʸ�ջ����㣬Ȼ�󽫵�ǰ��P��Ϊջ�������Һ��ӣ�
	//
	//	  ��3)ֱ��PΪNULL����ջΪ�������������
	public static void  InOrder1(TreeNode root){
		Stack <TreeNode>stack = new Stack<TreeNode>();
		TreeNode p = root;
		while(p!=null||!stack.isEmpty()){
			while(p!=null){
				stack.push(p);
				p = p.left;
			}
			if(!stack.isEmpty()){
				p = stack.pop();
				System.out.print(p.value);
				p = p.right;
			}
		}
	}
	//����������������ݹ�
	public void postOrder(TreeNode root){
		if(root!=null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.value);
		}
	}
	//�������ĺ���������ǵݹ�   ��
	//˼·��������һ���P��������ջ��Ȼ������������һֱ����������ֱ��������û�����ӵĽ�㣬
	//	       ��ʱ�ý�������ջ�������Ǵ�ʱ���ܽ����ջ�����ʣ� ������Һ��ӻ�Ϊ�����ʡ�
	//	       ���Խ�����������ͬ�Ĺ������������������ͬ�Ĵ��������������Һ���ʱ���ý���ֳ�����ջ������ʱ���Խ����ջ�����ʡ�
	//	       ������ ��֤����ȷ�ķ���˳�򡣿��Կ���������������У�ÿ����㶼���γ�����ջ����ֻ���ڵڶ��γ�����ջ��ʱ�����ܷ�������
	//	       �����Ҫ������һ��������ʶ�ý���� ���ǵ�һ�γ�����ջ����
	public void postOrder1(TreeNode root){
		if(root == null)
			return ;
		Stack <TreeNode>stack = new Stack<TreeNode>();
		TreeNode  curNode = root;//��ǰ���ʽڵ�
		TreeNode lastVisitNode = null;//�ϴη��ʽڵ�
		while(curNode !=null){
			stack.push(curNode);
			curNode = curNode.left;
		}

		while(!stack.isEmpty()){
			curNode  = stack.pop(); //����ջ��Ԫ��
			//һ�����ڵ㱻���ʵ�ǰ���ǣ��������������������Ѿ������ʹ�
			if(curNode.left!=null||curNode.right!=lastVisitNode){
				//���ڵ��ٴ���ջ
				stack.push(curNode);
				//������������������һ����Ϊ��
				curNode = curNode.right;
				while(curNode!=null){
					//���������������
					stack.push(curNode);
					curNode = curNode.left;
				} 
			}else{
				System.out.print(curNode.value);
				lastVisitNode = curNode;
			}
		}

	}
}

class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.label = label;
	}
}

class TreeNode{
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode next;
	TreeNode(int value){
		this.value = value;
	}
}

