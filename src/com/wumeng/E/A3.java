package com.wumeng.E;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class A3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int m = input.nextInt();
			int model = input.nextInt();
			ArrayList<Student> list = new ArrayList<Student>();
			while(m-->0){
				list.add(new Student(input.next(),input.nextInt()));
			}
			if(model==0){
				Collections.sort(list,new Comparator<Student>()
						{
					public int compare(Student o1,Student o2){
						return o2.score - o1.score;
					}
						});
			}else{//ÉýÐò
				Collections.sort(list,new Comparator<Student>()
						{
					public int compare(Student o1,Student o2){
						return o1.score - o2.score;
					}
						});
			}
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i).getName()+" "+list.get(i).getScore());
			}
		}
	}

}
class Student{
	String name;
	int score;
	Student(String name,int score){
		this.name = name;
		this.score = score;
	}
	public String getName(){
		return this.name;
	}
	public int getScore(){
		return this.score;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setScore(int score){
		this.score = score;
	}
}