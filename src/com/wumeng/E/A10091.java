package com.wumeng.E;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class A10091 {
	
	static class Bag{
		double J;
		double F;
		double G;
		public double getJ() {
			return J;
		}
		public void setJ(double j) {
			J = j;
		}
		public double getF() {
			return F;
		}
		public void setF(double f) {
			F = f;
		}
		public double getG() {
			return G;
		}
		public void setG(double g) {
			G = g;
		}
		public Bag(double j, double f) {
			super();
			J = j;
			F = f;
		}
		public Bag(double j, double f, double g) {
			super();
			J = j;
			F = f;
			G = g;
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int M = scanner.nextInt();
			int N = scanner.nextInt();
			if(M == -1&&N == -1)
				return;
			Bag[] bags = new Bag[N];
			for(int i=0;i<N;i++){
				double k1 = scanner.nextDouble();
				double k2 = scanner.nextDouble();
				bags[i] = new Bag(k1,k2,k1/k2);
			}
			
			ArrayList <Bag>list = new ArrayList<Bag>();
			for(Bag k:bags){
				list.add(k);
			}
			Collections.sort(list,new Comparator<Bag>() {

				@Override
				public int compare(Bag o1, Bag o2) {
					
					// TODO Auto-generated method stub
					if(o1.G > o2.G)
						return 1;
					if(o1.G < o2.G)
						return -1;
					
					
					return 0;
				}

			});
				
			
			for(int i=0;i<list.size();i++){
				System.out.println(bags[i].J);
			}
		}
	}

}
