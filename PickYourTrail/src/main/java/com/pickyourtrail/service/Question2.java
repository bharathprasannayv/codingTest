package com.pickyourtrail.service;

import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		try {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();		
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		int maxDiff = arr[1] - arr[0];
		int i, j;
		for (i = 0; i < size; i++) {
			for (j = i + 1; j < size; j++) {
				if (arr[j] - arr[i] > maxDiff)
					maxDiff = arr[j] - arr[i];
			}
		}

		if(maxDiff<0) {
			maxDiff= -1;			
		}	
		System.out.println(maxDiff);
		}catch (Exception e) {
			System.out.println("Invalid input");
		}
	}
}
