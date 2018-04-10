package com.asiainfo.demo.algorithms;

public class Insertion {
	public static void sort(int[] a) {
		int n = a.length;
		for(int i=1; i<n; i++) {
			for(int j=i; j>0; j--) {
				if(a[j] < a[j-1]) {
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				} else {
					break;
				}
				
			}
		}
	}
	public static void main(String[] args) {
		int[] a = new int[]{5,4,3,6,8,3,2,94,22,12};
		sort(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
	}
}
