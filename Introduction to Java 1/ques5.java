package ASSNMT1;

import java.util.Scanner;

class Employee{
	private String firstname;
	private String lastname;
	private int age;
	private String designation;

	public Employee(String firstname, String lastname, int age, String designation) {
		this.firstname=firstname;
		this.lastname = lastname;
		this.age = age;
		this.designation = designation;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	@Override
	public String toString() {
		return firstname+" "+lastname+", aged "+age+" years old is a "+designation;
	}
}

public class ques5 {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		String firstname = read.next();
		String lastname = read.next();
		int age = read.nextInt();
		String designation = read.next();
		
		Employee emp = new Employee(firstname, lastname, age, designation);
		System.out.println(emp);
		read.close();
	}

}
