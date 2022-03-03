package ASSNMT1;

import java.util.Scanner;

public class ques4 {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		int rows = read.nextInt(), cols = read.nextInt();
		int[][] arr = new int[rows][cols];
		System.out.println("Enter elements : ");
		for(int i=0 ; i<rows; i++) {
			for(int j=0 ; j<cols ; j++) {
				arr[i][j] = read.nextInt();
			}
		}
		
		System.out.println("Array is : ");
		for(int i=0 ; i<rows; i++) {
			for(int j=0 ; j<cols ; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
			
		
		System.out.println("Sum of all elements of each col : ");
		for(int i=0 ; i<cols ; i++) {
			int sum=0;
			for(int j=0 ; j<rows ; j++) sum+=arr[j][i];
			System.out.println("Sum for col "+i+" is "+sum);
		}
		System.out.println("Sum of all elements of each row : ");
		for(int i=0 ; i<rows ; i++) {
			int sum=0;
			for(int j=0 ; j<cols ; j++) sum+=arr[i][j];
			System.out.println("Sum for row "+i+" is "+sum);
		}
		read.close();
	}

}
