package lesson1;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        String s1 = "12";
        String s2 = s1;

        Integer i1 = null;
        Integer i2 = null;

        System.out.println(Objects.equals(i1, i2));

        int[] array = new int[]{1, 2, 3};
        int[] array2 = array;

        array[0] = 10;

        System.out.println(array2[0]);

        ExampleClass exampleClass1 = new ExampleClass(0, "");
        Object exampleClass2 = new ExampleClass(0, "");

        ExampleClass.intData = 5;


        if (exampleClass2 instanceof ExampleClass) {

            try {
                System.out.println(((ExampleClass) exampleClass2).intData);
            } catch (Exception e) {

            }
        }
        ExampleClass.exampleStaticMethod();

        int i4 = 0;

        Integer i5 = Integer.valueOf(i4);

        int i6 = i5;

        String s = "A".concat("B");

        s = s.toLowerCase();

        System.out.println(s);

    }
}
