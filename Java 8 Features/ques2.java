package ASSNMT4;

interface MyCalcInterface {
    int performOperation(int a, int b);
}

public class ques2 {

    public int add(int a, int b) {
        System.out.println("Performing addition");
        return a + b;
    }

    public int subtract(int a, int b) {
    	System.out.println("Performing subtraction");
    	return a-b;
    }
    
    public static int multiply(int a, int b) {
        System.out.println("Performing multiplication");
        return a * b;
    }

    public static void main(String[] args) {

    	MyCalcInterface addEx = new ques2()::add;
        System.out.println(addEx.performOperation(1, 2));
        
        MyCalcInterface subEx = new ques2()::subtract;
        System.out.println(subEx.performOperation(5, 3));

        MyCalcInterface multEx = ques2::multiply;
        System.out.println(multEx.performOperation(2, 10));

//        MyCalcInterface myInterface3 = (a, b) -> a + b;
//        System.out.println(myInterface3.performOperation(1, 3));

    }
}