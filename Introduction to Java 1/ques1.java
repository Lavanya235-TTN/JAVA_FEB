package ASSNMT1;

class Person{
	static String FirstName;
	static String LastName;
	static int age;

	static {
		FirstName="Pihu";
		LastName="Tyagi";
		age=5;
		System.out.println("STATIC BLOCK : \n"+FirstName+"\t"+LastName+"\t"+age);
	}
	
	public static void printDetails() {
		System.out.println("STATIC METHOD : \n"+FirstName+"\t"+LastName+"\t"+age);
	}
	
}

public class ques1 {

	public static void main(String[] args) {
		
		Person p = new Person();
		p.printDetails();
		System.out.println("USING STATIC VARIABLES : ");
		System.out.println(p.FirstName+"\t"+p.LastName+"\t"+p.age);
		
	}

}
