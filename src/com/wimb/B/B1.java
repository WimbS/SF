package com.wimb.B;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * �������ĸ��ֱ��������ܽ�
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

	//ǰ��ݹ����
	public void pre(TreeNode root){
		if(root == null)
			return ;
		System.out.print(root.val);
		pre(root.left);
		pre(root.right);
	}
	/*
       ǰ��������ǵݹ�ʵ��
    1������ջ���ڵ㣬������ڵ�valֵ�����Ⱥ���ջ���ҽڵ㡢���㣻
    2����ջ��ڵ㣬�����valֵ������ջ����ڵ���ҽڵ㡢��ڵ㣻ֱ�����������ڵ�����������  
    3���ٳ�ջ�ҽڵ㣬�����valֵ������ջ���ҽڵ���ҽڵ㡢��ڵ㣻ֱ����������ҽڵ�����������
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
	//����ݹ����
	public void mid(TreeNode root){
		if(root == null)
			return ;
		pre(root.left);
		System.out.print(root.val);
		pre(root.right);
	}
	/*
	 * ����������ǵݹ�ʵ��
	 *  
	 * 1�����ȴӸ��ڵ����һ·������ջ���е���ڵ㣻
	 * 2����ջһ���ڵ㣬����ýڵ�valֵ����ѯ�ýڵ��Ƿ�����ҽڵ㣬
	 *    ��������Ӹ��ҽڵ����һ·������ջ���ҽڵ������������е���ڵ㣻
	 * 3�����������ҽڵ㣬���ջ��һ���ڵ㣬����ڵ�valֵ��ͬ����2������
	 * 4��ֱ���ڵ�Ϊnull����ջΪ�ա�
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
	//�����ݹ����
	public void post(TreeNode root){
		if(root == null)
			return ;
		pre(root.left);
		pre(root.right);
		System.out.print(root.val);
	}
	/*
	 * ���������ǵݹ�ʵ��
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
	 * ������ȱ��� - ջ
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
	 * ���������������ȱ����� - ����
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