package com.wumeng.E;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class A10072 {

	static class Point{
		public Point(){

		}
		public Point(double x,double y){
			this.x = x;
			this.y = y;
		}
		double x;
		double y;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			if(n == 0)
				return;
			Point[] ps = new Point[n];
			for(int i=0;i<n;i++){
				double x = scanner.nextDouble();
				double y = scanner.nextDouble();
				ps[i] = new Point(x,y);
			}

			//按照x轴坐标排序
			Arrays.sort(ps,new Comparator<Point>(){
				@Override
				public int compare(Point o1,Point o2){
					if(o1.x < o2.x){
						return -1;
					}
					if(o1.x > o2.x){
						return 1;
					}
					if(o1.y < o2.y){
						return -1;
					}
					if(o1.y > o2.y){
						return 1;
					}
					return 0;

				}

			});
			
			double minDis = minDistance(ps,0,n-1);
			DecimalFormat df = new DecimalFormat("0.00");
	        System.out.println(df.format(minDis/2));
	        
		}
		
	}

	/*
	 * 点对之间的最小距离
	 */
	private static double minDistance(Point[] ps, int l, int r) {
		// TODO Auto-generated method stub
		if(l == r){
			return Double.MAX_VALUE;
		}

		if(l+1 == r){
			return distance(ps[l],ps[r]);
		}

		int center = (l +(r-1)) /2;
		double dis1 = minDistance(ps, l, center);
		double dis2 = minDistance(ps, center+1, r);

		double minDis = Math.min(dis1, dis2);

		ArrayList<Point> nearPoints = new ArrayList<Point>();
		//选出中间线小于 minDis的点

		for(Point p:ps){
			if(Math.abs(ps[center].x-p.x) <= minDis){
				nearPoints.add(p);
			}
		}

		
		//按照y轴升序排序
		Collections.sort(nearPoints,new Comparator<Point>(){
			@Override
			public int compare(Point o1,Point o2){
				if(o1.y<o2.y){
					return -1;
				}
				if(o1.y>o2.y){
					return 1;
				}
				
				if(o1.x<o2.x){
					return -1;
				}
				if(o1.x>o2.x){
					return 1;
				}
				
				return 0;
			}
		});
		
		for(int i=0;i<nearPoints.size();i++){
			for(int j=i+1;j<nearPoints.size();j++){
				if(nearPoints.get(j).y - nearPoints.get(i).y > minDis){
					break;
				}
				
				double d = distance(nearPoints.get(j),nearPoints.get(i));
				
				if(d<minDis){
					minDis = d;
				}				
			}
		}
		return minDis;
	}

	private static double distance(Point p1, Point p2) {
		// TODO Auto-generated method stub
		if(p1 == p2){
			return 0;
		}
		return Math.sqrt(Math.pow(p1.x-p2.x, 2)+Math.pow(p1.y-p2.y, 2));
	}

}
