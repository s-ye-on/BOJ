package boj;
class Parent{
    static int total = 0;
    int v = 1;
    Parent(){
        total += (++v);
        showValue();
    }
    void showValue(){
        total += total;
    }
}
class Child extends Parent{
    int v = 10;
    Child(){
        v +=2;
        total += (v++);
        showValue();
    }
    @Override
    void showValue(){
        total += total *2;
    }
}
public class temp {
    public static void main(String[] args) {
        new Child();
        System.out.println(Parent.total);
    }
}
