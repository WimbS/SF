package com.wumeng.E;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class A10073 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = -1;
        while (scanner.hasNext()) 
       {
            N = scanner.nextInt();
            List<Point> points = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                Point point = new Point();
                point.setX(scanner.nextDouble());
                point.setY(scanner.nextDouble());
                points.add(point);
            }
            if(N!=0){
                double min = MinDistance(points);
                System.out.printf("%.2f", min/2);
                System.out.println();
            }    
        }
    }

    public static double MinDistance(List<Point> points) {
        int n = points.size();
        if (n < 2)
            return Integer.MAX_VALUE;
        if (n == 2) {
            double distance = Distance(points.get(0), points.get(1));
            return distance;
        }
        Collections.sort(points);// ���㰴��x�����ź�
        // �ֽ���Ϊ�м�����x�����һ��
        double m = (points.get(points.size() / 2 - 1).getX() + points.get(points.size() / 2).getX()) / 2;
        // ��x = m Ϊ���޷�Ϊ�����㼯
        List<Point> leftPoints = new ArrayList<>();
        List<Point> rightPoints = new ArrayList<>();
        leftPoints.addAll(points.subList(0, points.size() / 2));
        rightPoints.addAll(points.subList(points.size() / 2, points.size()));
        // �õ����������㼯����̾���
        double leftMin = MinDistance(leftPoints);
        double rightMin = MinDistance(rightPoints);

        // �õ���̾���
        double min = Math.min(leftMin, rightMin);

        // ����P1�㼯��P2�㼯
        List<Point> P1 = new ArrayList<>();
        List<Point> P2 = new ArrayList<>();
        for (Point point : points) {
            if (point.getX() >= (m - min) && point.getX() < m) {
                P1.add(point);
            }
            if (point.getX() > m && point.getX() <= m + min) {
                P2.add(point);
            }
        }

        double min2 = Integer.MAX_VALUE;
        double distance;
        boolean flag1, flag2;
        if (P1 != null && P2 != null) {
            for (Point point : P1) {
                for (Point point2 : P2) {
                    flag1 = (point2.getY() >= (point.getY() - min) && point2.getY() <= point.getY());
                    flag2 = (point2.getY() >= point.getY() && point2.getY() <= (point.getY() + min));
                    if (flag1 || flag2) {
                        distance = Distance(point,point2);
                        if (distance < min2) {
                            min2 = distance;
                        }

                    }
                }
            }
            return Math.min(min, min2);
        } else {
            return min;
        }
    }
    
    public static double Distance(Point point1,Point point2){
        return Math.sqrt((point1.getX() - point2.getX()) * (point1.getX() - point2.getX())
                + (point1.getY() - point2.getY()) * (point1.getY() - point2.getY()));
    }
}

class Point implements Comparable<Point> {
    // ���x.y����
    private double x;
    private double y;

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
    @Override
    public int compareTo(Point o) {
        if (x > o.getX())
            return 1;
        else if (x == o.getX()) {
            return 0;
        } else {
            return -1;
        }
    }
}