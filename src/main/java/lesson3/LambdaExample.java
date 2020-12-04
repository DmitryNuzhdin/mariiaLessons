package lesson3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaExample {
    interface F{
        int apply(int a, int b);
    }

    static class FImpl implements F {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    }

    public static void main(String[] args) {
        F f1 = new FImpl();
        F f2 = new F() {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        };
        F f3 = (int a, int b) -> {return a + b;};

        List<Integer> list = Arrays.asList(1, 4, 6 ,7, 8, 11);
        List<String> stringList = list.stream()
                //.filter(integer -> integer % 2 == 0)
                .flatMap(integer -> {
                    if (integer % 2 == 0)
                        return Stream.of(integer);
                    else
                        return Stream.empty();
                })
                .map(integer -> integer * 2)
                .flatMap(i -> Stream.of(100 + i, 200 + i, 300 + i))
                .map(i -> "!" + i)
                .distinct()
                .limit(5)
                .collect(Collectors.toList());

        stringList.forEach(s -> System.out.println(s));

                //.forEach(integer -> System.out.println(integer));

    }
}
