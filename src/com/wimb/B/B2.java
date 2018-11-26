package com.wimb.B;

public class B2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean BinTreeSearch(TreeNode root,int tmp){
		if(root == null)
			return false;
		if(root.val == tmp)
			 return true;
		if(root.val > tmp){
			return BinTreeSearch(root.left,tmp);
		}
		if(root.val < tmp){
			return BinTreeSearch(root.right,tmp);
		}
		return false;			
	}
}
