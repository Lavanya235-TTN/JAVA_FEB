package ASSNMT3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
 * 1) Write Java code to define List . 
 * Insert 5 floating point numbers in List, and using an iterator, find the sum of the numbers in List.
 */

public class ques1 {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		List<Float> list = new ArrayList<>();
		for(int i=0;i<5;i++)
			list.add(read.nextFloat());
		
		System.out.println("List is : "+list);
		
		Iterator<Float> iter = list.iterator();
		float sum = 0.0f;
		while(iter.hasNext()) 
			sum+=iter.next();
		
		System.out.println("Sum is : "+sum);
		read.close();
	}

}
