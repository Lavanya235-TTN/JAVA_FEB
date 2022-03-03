package ASSNMT4;

interface myinterface{
    default void print(){
        System.out.println("Printing in parent");
    }
}
class child1 implements myinterface{

}
class child2 implements myinterface{
    @Override
    public void print() {
        System.out.println("Printing in Child2");
    }
}
public class ques5 {
    public static void main(String[] args) {
        child1 a = new child1();
        child2 b = new child2();
        a.print();
        b.print();
    }
}