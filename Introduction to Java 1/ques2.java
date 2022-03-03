package ASSNMT1;

import java.util.Scanner;

public class ques2 {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		String text;
		do{
			text = read.next();
		}while(!text.equals("XDONE"));
		System.out.println(text);
		read.close();
	}

}
