package ASSNMT3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 4) Create class Employee with attributes name,age,designation and 
 * use instances of these class as keys in a Map and their salary as value
 */
class Employee1{
	String name;
	double age;
	String designation;
	
	public Employee1(String name, double age, String designation) {
		this.name=name;
		this.age=age;
		this.designation=designation;
	}
	
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", designation=" + designation + "]";
	}
	
}

public class ques4 {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		HashMap<Employee1, Double> map = new HashMap<>();
		for(int i=0 ; i<3 ; i++) {
			System.out.println("Enter name, age, designation : ");
			Employee1 e=new Employee1(read.next(), read.nextDouble(), read.next());
			System.out.println("Enter salary : ");
			map.put(e, read.nextDouble());
		}
		
		for(Map.Entry<Employee1, Double> entry : map.entrySet()) {
			System.out.println(entry.getKey().toString()+" SALARY : "+entry.getValue());
		}
		
		read.close();
	}
	

}
