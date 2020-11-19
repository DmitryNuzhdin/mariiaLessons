package lesson1;

import java.util.Objects;

public class ExampleClass {
    static int intData = 0;

    final int data;

    private final String stringData;

    public ExampleClass(int data, String stringData) {
        this.data = data;
        this.stringData = stringData;
    }

    public String getStringData() {
        return stringData;
    }

    static void exampleStaticMethod(){
        System.out.println("TADAM!");
    }

    void simpleMethod(String s, String s2){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExampleClass that = (ExampleClass) o;
        return data == that.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "ExampleClass{" +
                "data=" + data +
                ", stringData='" + stringData + '\'' +
                '}';
    }
}
