package ASSNMT4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
	private String fullName;
	private Long salary;
	private String city;
	
	public Employee(String fn, long sal, String cy) {
		fullName=fn;
		salary=sal;
		city=cy;
	}
	
	public long getSalary(){
		return salary;
	}
	
	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "Employee [fullName=" + fullName + ", salary=" + salary + ", city=" + city + "]";
	}
	
	public String getFirstName() {
		return fullName.split(" ")[0];
	}
	
}

public class ques4b {

	public static void main(String[] args) {
		Employee e1 = new Employee("Shah Rukh Khan", 11000, "Mumbai");
		Employee e2 = new Employee("Ravi Shanker Tyagi", 12000, "Gzb");
		Employee e3 = new Employee("Pankaj Kumar Chaturvedi", 4000, "Delhi");
		Employee e4 = new Employee("Suraj Singh Rajput", 2000, "Jaipur");
		Employee e5 = new Employee("Aman Deep Kaur", 1100, "Chandigarh");
		
		List<Employee> list = Arrays.asList(e1,e2,e3,e4,e5);
		System.out.println(list.stream()
		.filter(e->e.getSalary() <5000)
		.filter(e->e.getCity().equals("Delhi"))
		.map(e->e.getFirstName())
		.distinct()
		.collect(Collectors.toList()));
	}

}
