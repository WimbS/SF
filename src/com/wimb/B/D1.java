package com.wimb.B;

public class D1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4,5,6,7};
		System.out.print(new D1().BinarySearch(a, 10));
	}
	//¶ş·Ö²éÕÒ
	public boolean BinarySearch(int a[],int key){
		if(a.length == 0)
			return false;
		int low = 0;
		int high = a.length-1;
		while(low<=high){
			int mid = (low+high)/2;
			if(a[mid]<key){
				high = mid-1;
			}else if(a[mid]>key){
				low = mid+1;
			}else{
				return true;
			}
		}
		return false;
	}
}
