package com.wimb.B;

//Ȼ��ʵ�ֹ��������������࣬���а���������̬�ķ��ͷ�����Ϊ�������������͹�����ȱ�����������


import java.util.ArrayDeque;  
import java.util.ArrayList;  
import java.util.Collections;  
import java.util.List;  
import java.util.Queue;  

public class HuffmanTree<T> {  
	public static <T> Node<T> createTree(List<Node<T>> nodes){
		//ֻҪnodes�����л����������ϵĽڵ�
		while(nodes.size() > 1){  
			Collections.sort(nodes);//1����������  
			// ��ȡȨֵ��С�������ڵ�
			Node<T> left = nodes.get(nodes.size()-1);  //������һ��
			Node<T> right = nodes.get(nodes.size()-2);//�����ڶ���  
			//�����½ڵ㣬�½ڵ��ȨֵΪ�����ӽڵ��Ȩֵ֮��
			Node<T> parent = new Node<T>(null, left.getWeight()+right.getWeight()); 
			//���½ڵ���ΪȨֵ��С�������ڵ�ĸ��ڵ�
			parent.setLeft(left);  
			parent.setRight(right);  
			//ɾ��Ȩֵ��С�������ڵ�
			nodes.remove(left);  
			nodes.remove(right);
			//�������ɵĽڵ���ӵ�������
			nodes.add(parent);  
		}  
		return nodes.get(0);  
	}  
	/*7 5 4 2
	 * 
	 *       18
	 *    11   7
	 *   6  5
	 *  2 4
	 * 			
	 * 
	 */

	public static void main(String[] args) {  
		// TODO Auto-generated method stub  
		List<Node<String>> list = new ArrayList<Node<String>>();  
		list.add(new Node<String>("a",7));  
		list.add(new Node<String>("b",5));  
		list.add(new Node<String>("c",4));  
		list.add(new Node<String>("d",2));  

		Node<String> root = HuffmanTree.createTree(list);  
		System.out.println(HuffmanTree.breadth(root));  
		//    	      System.out.println(list);  
	}  

	//������ȱ���
	public static <T> List<Node<T>> breadth(Node<T> root){  
		List<Node<T>> list = new ArrayList<Node<T>>();  
		Queue<Node<T>> queue = new ArrayDeque<Node<T>>();  

		if(root != null){  
			//����Ԫ����"����"
			queue.offer(root);  
		}  

		while(!queue.isEmpty()){  
			//���ö��е�"��β"��Ԫ����ӵ�list��
			list.add(queue.peek());  
			Node<T> node = queue.poll();  
			//�����ڵ㲻Ϊnull�������Ǽ������
			if(node.getLeft() != null){  
				queue.offer(node.getLeft());  
			}  
			//����нڵ㲻Ϊnull�������Ǽ�����С�
			if(node.getRight() != null){  
				queue.offer(node.getRight());  
			}  
		}  
		return list;  
	}  
}
class Node<T> implements Comparable<Node<T>> {  
	private T data;  
	private double weight;  //Ȩ��
	private Node<T> left;  
	private Node<T> right;  

	public Node(T data, double weight){  
		this.data = data;  
		this.weight = weight;  
	}  

	public T getData() {  
		return data;  
	}  

	public void setData(T data) {  
		this.data = data;  
	}  

	public double getWeight() {  
		return weight;  
	}  

	public void setWeight(double weight) {  
		this.weight = weight;  
	}  

	public Node<T> getLeft() {  
		return left;  
	}  

	public void setLeft(Node<T> left) {  
		this.left = left;  
	}  

	public Node<T> getRight() {  
		return right;  
	}  

	public void setRight(Node<T> right) {  
		this.right = right;  
	}  

	@Override  
	public String toString(){  
		return "data:"+this.data+";weight:"+this.weight;  
	}  

	@Override  
	public int compareTo(Node<T> other) {  
		if(other.getWeight() > this.getWeight()){  
			return 1;  
		}  
		if(other.getWeight() < this.getWeight()){  
			return -1;  
		}  

		return 0;  
	}  
}  