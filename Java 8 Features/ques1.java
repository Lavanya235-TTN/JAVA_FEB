package ASSNMT4;

interface MyInterface1{
    boolean greaterThan(int a, int b);
}

interface MyInterface2{
    int increment(int a);
}
interface MyInterface3{
    String concat(String a, String b);
}
interface MyInterface4{
    String toUpperCase(String a);
}


public class ques1 {

    public static void main(String[] args) {
        String separator = "----------------------------------";
        MyInterface1 my1 = (a,b) -> a>b;
        System.out.println(my1.greaterThan(10,15));
        System.out.println(my1.greaterThan(15,10));
        System.out.println(separator);

        MyInterface2 my2 = (a) -> a=a+1;
        System.out.println(my2.increment(10));
        System.out.println(separator);

        MyInterface3 my3 = (a,b) -> a+b;
        System.out.println(my3.concat("Lavanya ", "Tyagi"));
        System.out.println(separator);

        MyInterface4 my4 = (a) -> a.toUpperCase();
        System.out.println(my4.toUpperCase("hello"));

    }
}

