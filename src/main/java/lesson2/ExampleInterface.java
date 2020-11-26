package lesson2;

import java.util.List;

public interface ExampleInterface<A, B extends List<A>> {
    void abstractMethod();

    void method(int a, int b);


    default void method(int a){
        method(a, 0);
    }

    default void nonAbstractMethod(){
        abstractMethod();
    }
}
