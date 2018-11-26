package com.wimb.B;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树的各种遍历方法总结
 * @author Wimb
 *
 */
public class B1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		TreeNode r4 = new TreeNode(4);
		TreeNode r5 = new TreeNode(5);
		TreeNode r6 = new TreeNode(6);
		r1.left = r2;
		r1.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.left = r6;
		new B1().DeepOrder(r1);

		System.out.println();
	}	

	//前序递归遍历
	public void pre(TreeNode root){
		if(root == null)
			return ;
		System.out.print(root.val);
		pre(root.left);
		pre(root.right);
	}
	/*
       前序遍历，非递归实现
    1，先入栈根节点，输出根节点val值，再先后入栈其右节点、左结点；
    2，出栈左节点，输出其val值，再入栈该左节点的右节点、左节点；直到遍历完该左节点所在子树。  
    3，再出栈右节点，输出其val值，再入栈该右节点的右节点、左节点；直到遍历完该右节点所在子树。
	 */
	public void pre1(TreeNode root){
		Stack <TreeNode> stack = new Stack<TreeNode>();
		if(root!=null){
			stack.push(root);
		}
		while(!stack.isEmpty()){
			TreeNode tmp = stack.pop();
			System.out.print(tmp.val);
			if(tmp.right!=null) stack.push(tmp.right);
			if(tmp.left!=null) stack.push(tmp.left);
		}
	}
	//中序递归遍历
	public void mid(TreeNode root){
		if(root == null)
			return ;
		pre(root.left);
		System.out.print(root.val);
		pre(root.right);
	}
	/*
	 * 中序遍历，非递归实现
	 *  
	 * 1，首先从根节点出发一路向左，入栈所有的左节点；
	 * 2，出栈一个节点，输出该节点val值，查询该节点是否存在右节点，
	 *    若存在则从该右节点出发一路向左入栈该右节点所在子树所有的左节点；
	 * 3，若不存在右节点，则出栈下一个节点，输出节点val值，同步骤2操作；
	 * 4，直到节点为null，且栈为空。
	 */
	public void mid1(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root!=null||!stack.isEmpty()){
			while(root!=null){
				stack.push(root);
				root = root.left;
			}
			if(!stack.isEmpty()){
				TreeNode tmp = stack.pop();
				System.out.print(tmp.val);
				root = tmp.right;
			}

		}
	}
	//后续递归遍历
	public void post(TreeNode root){
		if(root == null)
			return ;
		pre(root.left);
		pre(root.right);
		System.out.print(root.val);
	}
	/*
	 * 后续遍历非递归实现
	 */
	public void post1(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode flag = null;
		TreeNode cur = root;
		while(cur!=null){
			stack.push(cur);
			cur = cur.left;
		}
		while(!stack.isEmpty()){
			cur = stack.pop();
			if(cur.right == null||flag == cur.right){
				System.out.print(cur.val);
				flag = cur;
			}else{
				stack.push(cur);
				cur = cur.right;
				while(cur!=null){
					stack.push(cur);
					cur = cur.left;
				}
			}			
		}
	}
	/*
	 * 深度优先遍历 - 栈
	 */
	public void DeepOrder(TreeNode root){
		Stack <TreeNode>stack = new Stack<TreeNode>();
		if(root == null)
			return ;
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode tmp = stack.pop();
			if(tmp != null){
				System.out.print(tmp.val);
			}
			if(tmp.right!=null){
				stack.push(tmp.right);
			}
			if(tmp.left!=null){
				stack.push(tmp.left);
			}
		}
		
	}
	/*
	 * 层序遍历（广度优先遍历） - 队列
	 */
	public void LayerOrder(TreeNode root) {
		Deque <TreeNode> queue = new LinkedList<TreeNode>();
		if(root!=null){
			queue.add(root);
		}
		while(!queue.isEmpty()){
			TreeNode now = queue.pop();
			System.out.print(now.val);
			if(now.left!=null) queue.add(now.left);
			if(now.right!=null) queue.add(now.right);
		}
	}
}
class TreeNode{
	TreeNode left;
	TreeNode right;
	int val;
	TreeNode(int val){
		this.val = val;
	}
}