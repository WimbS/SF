package com.wimb.C;

import java.util.HashMap;

import org.junit.Test;

public class A1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print(new A1().checkDifferent("welcometonowcoderrrrr"));
		
		//int[][] mat = {{1,2,3},{4,5,6},{7,8,0}};
		System.out.print(new A1().isSubString("asdasd", "asdasd"));
	}

	public boolean checkDifferent(String iniString) {
		int len = iniString.length();
		if(len == 0)
			return true;
		//抽屉原理：构成字符串的所有个数为256个，超过数字一定构成重复
		if(len>256)
			return false;
		for(int i=0;i<len;i++){
			for(int j=i+1;j<len;j++){
				if(iniString.charAt(i) == iniString.charAt(j))
					return false;
			}
		}
		return true;
	}

	public String reverseString(String iniString) {
		if(iniString == null)
			return iniString;
		char in[] = iniString.toCharArray();
		int len = in.length;
		for(int i=0;i<iniString.length()/2;i++){
			char tmp = in[i];
			in[i] = in[len-i-1];
			in[len-i-1] = tmp;
		}
		return new String(in);

	}

	public boolean checkSam(String stringA, String stringB) {
		char []a = stringA.toCharArray();
		char []b = stringB.toCharArray();
		HashMap<Character,Integer> map_a = new HashMap<Character,Integer>();
		HashMap<Character,Integer> map_b = new HashMap<Character,Integer>();
		for(int i=0;i<a.length;i++){
			if(!map_a.containsKey(a[i])){
				map_a.put(a[i], 1);
			}else{
				map_a.put(a[i],map_a.get(a[i])+1);
			}

		}
		for(int j=0;j<b.length;j++){
			if(!map_b.containsKey(b[j])){
				map_b.put(b[j], 1);
			}else{
				map_b.put(b[j],map_b.get(b[j])+1);
			}			
		}
		return map_a.equals(map_b);

	}
	public String replaceSpace(String iniString, int length) {
		if(length == 0)
			return iniString;
		int blank = 0;
		char []in = iniString.toCharArray();
		for(int i=0;i<length;i++){
			if(in[i] == ' '){
				blank++;
			}
		};
		char []ini = new char[length-blank+blank*3];

		int i = 0;
		int index = 0;
		while(index < length){
			if(in[index] != ' '){
				ini[i++] = in[index];
			}else{
				ini[i++] = '%';
				ini[i++] = '2';
				ini[i++] = '0';
			}
			index++;
		}
		return new String(ini);
	}

	public String zipString(String iniString) {
		int len = iniString.length();
		StringBuffer sb = new StringBuffer();
		char []in = iniString.toCharArray();
		int index = 0;
		while(index < len){
			sb.append(in[index]);
			int sum = 1;
			for(int i=index+1;i<len;i++){
				if(in[index] == in[i]){
					sum++;
				}else{
					break;
				}					
			}
			sb.append(sum);

			index = index+sum;
		}

		String sb1 = sb.toString().trim();
		if(sb1.length() > len){
			return iniString;
		}else{
			return sb1;
		}
	}
	//数组顺时针旋转90度
	//思路：先上下互换，再对角线互换即可
	public int[][] transformImage(int[][] mat, int n) {
		if(mat == null||n<2)
			return mat;
		//上下
		for(int i=0;i<n/2;i++){
			for(int j=0;j<n;j++){
				int tmp = mat[i][j];
				mat[i][j] = mat[n-1-i][j];
				mat[n-1-i][j] = tmp;
			}
		}
		//旋转
		for(int i=0;i<n;i++){
			for(int j=0;j<i;j++){
				int tmp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = tmp;
			}
		}
		
		return mat;
	}
	public void print(int a[][]){
		for(int i=0;i<a.length;i++){
			if(i !=0){
				System.out.println();
			}
			for(int j=0;j<a[0].length;j++){
				System.out.print(a[i][j]+" ");
			}
		}
	}
	//清零操作
	public int[][] clearZero(int[][] mat, int n) {
		if(mat == null||n<1)
			return mat;
		boolean row[] = new boolean [n];
		boolean col[] = new boolean [n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(mat[i][j] == 0){
					row[i] = true;
					col[j] = true;
				}
			}
		}	
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(row[i]||col[j]){
					mat[i][j] = 0;
				}
			}
		}
		return mat;
    }
	//反转子串
	public boolean checkReverseEqual(String s1, String s2) {
		if(s1 == null||s2 == null)
			return false;
		if(s1.length()<s2.length())
			return false;
		String str1 = s1+s1;
		return str1.contains(s2);
    }
	//判断是否是子串
	public boolean isSubString(String s1,String s2){
		if(s1.length()<s2.length())
			return false;
		
		char []ss1 = s1.toCharArray();
		char []ss2 = s2.toCharArray();
		
		for(int i=0;i<s1.length();i++){
			int k1 = i;
			int k2 = 0;
			while(ss1[k1] == ss2[k2]){
				k1++;
				k2++;
				if(k2 == s2.length())
					return true;
			}
		}
		return false;
	}
}
