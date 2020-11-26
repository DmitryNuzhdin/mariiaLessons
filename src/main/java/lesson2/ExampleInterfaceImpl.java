package lesson2;

import java.util.Iterator;

public abstract class ExampleInterfaceImpl implements ExampleInterface, Iterator {
    @Override
    public void abstractMethod() {
        System.out.println("Hello!");
    }

    @Override
    public void method(int a, int b) {
        System.out.println(a + b);
    }

}
