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

	//顺时针打印矩阵
	public ArrayList<Integer> printMatrix(int [][] matrix) {
		int left=0,right=matrix[0].length-1,top=0,boom= matrix.length-1;//记录四个角的位置
		ArrayList<Integer> list = new ArrayList<Integer>();

		while((right>left)&&(boom>top)){
			for(int i=left;i<=right;i++){//从左到右
				list.add(matrix[top][i]);
			}
			for(int i=top+1;i<=boom;i++){//上到下
				list.add(matrix[i][right]);
			}
			for(int i = right-1;i>=left;i--){//右到左
				list.add(matrix[boom][i]);
			}
			for(int i = boom-1;i>top;i--){//下到上 ,注意此时的top还没减 ☆
				list.add(matrix[i][left]);
			}
			left++;
			right--;
			top++;
			boom--;
		}

		if((boom==top)&&(left<right)){//单独剩下一行的情况
			for(int i=left;i<=right;i++){
				list.add(matrix[top][i]);
			}
		}
		if((left==right)&&(boom>top)){//单独剩下一列的情况
			for(int i =top;i<= boom;i++){
				list.add(matrix[i][left]);
			}
		}
		if((boom==top)&&(right==left)){//单独剩下一个元素的情况
			list.add(matrix[left][boom]); 
		}
		return list;
	}
	//二叉树转变为二叉树的镜像:递归实现
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
	//判断是否是当前树的子结构,代码部分1
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
	//代码部分2
	public static boolean isSubTree(TreeNode root1,TreeNode root2){
		if(root2 == null)
			return true;
		if(root1 == null)
			return false;
		if(root1.value != root2.value)
			return false;
		return isSubTree(root1.left, root2.left)&&isSubTree(root1.right, root2.right);
	}

	//重建二叉树:根据中序遍历和前序遍历构建二叉树
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
	//重建二叉树:中序+前序
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
	//默写:中序+前序 -- 构建二叉树
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
	//弹出包含最小元素的栈min
	public void push1(int node) {
		//初始化状态
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
	//判断序列是否是栈的弹出序列
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
	//二叉树的层序遍历
	//方法：层序用---队列！
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

	//判断某二叉搜索树的后序遍历是否正确
	//思想：对于一个二叉树的后序遍历序列来说，最后一个数一定是根节点，然后前面的数中，从最开始到第一个大于根节点的数都是左子树中的数，
	//      而后面到倒数第二个数应该都是大于根节点的，是右子树，如果后面的数中有小于根节点的，那么说明这个序列不是二叉搜索树的后序遍历序列

	//判断前序亦如此，思路即是将序列拆分成 左子树和右子树两部分，利用递归思想完成操作。
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

	//找到二叉树中的指定数值的路径
	//思路：

	//	1.判断树是否为null、是否只有根节点 

	//	2.用前序遍历方法，可以首先访问节点，然后将节点入队列（或栈均可），并将数值和之前入队列的总和num相加 

	//	ps:个人倾向于栈，但由于在牛客网上刷题，该题返回值为队列，故使用队列，其实都差不多。栈可直接用pop将该最后加入栈的节点弹出，
	//	队列则使用move(list.size()-1)将最后入队的节点弹出。 

	//	3.判断当前之和否满足给定值，判断当前节点是否叶节点。 若当前值等于给定值，且当前节点是叶节点，则打印路径信息； 
	//	若当前值小于给定值，且当前节点不是叶节点，则递归调用该节点的左右子树； 若当前值大于给定值，无需递归了（在默认节点值为正数的情况下）
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
	//复制复杂链表:复制自身，复制自身指针，拆分
	public RandomListNode Clone(RandomListNode pHead){
		if(pHead == null)
			return null;
		RandomListNode currentNode = pHead;
		//(1)复制复杂链表，不处理链表的兄弟节点
		while(currentNode != null){
			RandomListNode newnode = new RandomListNode(currentNode.label);
			RandomListNode nextnode = currentNode.next;
			newnode.next = nextnode;
			currentNode.next = newnode;
			currentNode = newnode.next;
		}
		//(2)根据旧链表的兄弟节点，初始化链表的兄弟节点
		currentNode = pHead;
		while(pHead != null){
			RandomListNode clonenode = currentNode.next;
			clonenode.next = currentNode.random == null? null:currentNode.random.next;
			currentNode = clonenode.next;
		}

		//(3)拆分得到新链表
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

	//将排序二叉树转变为双向链表 ★★
	//思路：非递归中序遍历二叉树，修改指针即可
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
				pRootOfTree = p; //将中序遍历序列中的第一个节点记为root
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

	//二叉树前序遍历：递归
	public static void  PreOrder(TreeNode root){
		if(root != null){
			System.out.print(root.value);
			PreOrder(root.left);
			PreOrder(root.right);
		}
	}

	//二叉树的前序遍历：非递归
	//	对于任一结点P：
	//
	//    1)访问结点P，并将结点P入栈;
	//
	//    2)判断结点P的左孩子是否为空，若为空，则取栈顶结点并进行出栈操作，并将栈顶结点的右孩子置为当前的结点P，循环至1);
	//	        若不为空，则将P的左孩子置为当前的结点P;
	//
	//    3)直到P为NULL并且栈为空，则遍历结束。
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

	//二叉树中序遍历：递归
	public static void  InOrder(TreeNode root){
		if(root != null){				
			PreOrder(root.left);
			System.out.print(root.value);
			PreOrder(root.right);
		}
	}

	//二叉树中序遍历：非递归
	//	对于任一结点P，
	//
	//	  　1)若其左孩子不为空，则将P入栈并将P的左孩子置为当前的P，然后对当前结点P再进行相同的处理；
	//
	//	 　 2)若其左孩子为空，则取栈顶元素并进行出栈操作，访问该栈顶结点，然后将当前的P置为栈顶结点的右孩子；
	//
	//	  　3)直到P为NULL并且栈为空则遍历结束。
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
	//二叉树后序遍历：递归
	public void postOrder(TreeNode root){
		if(root!=null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.value);
		}
	}
	//二叉树的后序遍历：非递归   ★
	//思路：对于任一结点P，将其入栈，然后沿其左子树一直往下搜索，直到搜索到没有左孩子的结点，
	//	       此时该结点出现在栈顶，但是此时不能将其出栈并访问， 因此其右孩子还为被访问。
	//	       所以接下来按照相同的规则对其右子树进行相同的处理，当访问完其右孩子时，该结点又出现在栈顶，此时可以将其出栈并访问。
	//	       这样就 保证了正确的访问顺序。可以看出，在这个过程中，每个结点都两次出现在栈顶，只有在第二次出现在栈顶时，才能访问它。
	//	       因此需要多设置一个变量标识该结点是 否是第一次出现在栈顶。
	public void postOrder1(TreeNode root){
		if(root == null)
			return ;
		Stack <TreeNode>stack = new Stack<TreeNode>();
		TreeNode  curNode = root;//当前访问节点
		TreeNode lastVisitNode = null;//上次访问节点
		while(curNode !=null){
			stack.push(curNode);
			curNode = curNode.left;
		}

		while(!stack.isEmpty()){
			curNode  = stack.pop(); //弹出栈顶元素
			//一个根节点被访问的前提是：无右子树或者右子树已经被访问过
			if(curNode.left!=null||curNode.right!=lastVisitNode){
				//根节点再次入栈
				stack.push(curNode);
				//进入右子树且右子树一定不为空
				curNode = curNode.right;
				while(curNode!=null){
					//至右子树的最左边
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

