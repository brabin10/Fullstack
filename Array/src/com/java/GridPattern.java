package com.java;

// Write a program to print the following grid
public class GridPattern {
	public static void main(String[] args) {

		int[][] a = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.printf("%2d", a[i][j]);
			}
			System.out.println();
		}
//		int i = 0;
//		int j = 0;
//		for (int[] i1 : a) {
//
//			for (int[] j1 : a) {
//
//				System.out.printf("%2d", a[i][j]);
//			}
//			System.out.println();
//
//		}

	}
}