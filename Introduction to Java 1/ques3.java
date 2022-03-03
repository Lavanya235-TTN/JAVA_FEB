package ASSNMT1;

import java.util.Scanner;

class Circle{
	private static double radius;
	Circle(double r){
		radius=r;
	}
	public static void showMenu(Scanner sc) {
		System.out.println("Select operation : ");
		System.out.println("1. Calculate Area : ");
		System.out.println("2. Calculate Circumference : ");
		System.out.println("3. Exit : ");
		
		int choice = sc.nextInt();
		switch(choice)
		{
			case 1: 
				System.out.println(calculateArea());
				break;
			case 2:
				System.out.println(calculateCircumference());
				break;
			case 3: 
				System.out.println("Exiting!");
				return;
			default:
				System.out.println("Invalis Option, choose again!!");
				return;
		}
	}
	
	private static double calculateCircumference() {
		return Math.PI*2*radius;
	}
	private static double calculateArea() {
		return Math.PI*radius*radius;
	}
}
public class ques3 {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		double rad = read.nextDouble();
		new Circle(rad);
		Circle.showMenu(read);
		read.close();
	}

}
