package ASSNMT3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 
2) Given the following class
Employee class{ Double Age; Double Salary; String Name}
Design the class in such a way that the default sorting should work on firstname and lastname.

Also, Write a program to sort Employee objects based on salary using Comparator. 
 */
class Employee{
	double age;
	double salary;
	String name;
	
	public Employee(String name, double age, double salary) {
		this.name=name;
		this.age=age;
		this.salary=salary;
	}
	
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getfirstName() {
		return name.split(" ")[0];
	}
	public String getLastName() {
		return name.split(" ")[1];
	}

	@Override
	public String toString() {
		return "Employee [age=" + age + ", salary=" + salary + ", name=" + name + "]";
	}
	
}

class sortByFirstName implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getfirstName().compareTo(o2.getfirstName());
	}
	
}

class sortByLastName implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getLastName().compareTo(o2.getLastName());
	}
}

class sortBySalary implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return (int)(o1.getSalary()-o2.getSalary());
	}
}

public class ques2 {

	public static void main(String[] args) {
		final String separator="----------------------------------------";
		ArrayList<Employee> list = new ArrayList<>();
		
		list.add(new Employee("Alex Rider", 25, 25000.0));
		list.add(new Employee("Sam Winchester", 30, 20000.0));
		list.add(new Employee("Alex Mcgyver", 34, 30000.0));
		
		System.out.println("SORT BY FIRST NAME: ");
		for(Employee e: list)
			System.out.println(e.toString());
		Collections.sort(list, new sortByFirstName());
		Collections.sort(list, new sortByLastName());
		
		System.out.println(separator);
		
		System.out.println("SORT BY SALARY: ");
		for(Employee e: list)
			System.out.println(e.toString());
		System.out.println(separator);
		Collections.sort(list, new sortBySalary());
	}

}
