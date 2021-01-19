package leetcode.fizzBuzz;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution2 {
    public static List<String> fizzBuzz(int n) {
        return IntStream.rangeClosed(1,n)
                .boxed()
                .flatMap(integer -> {
                    if (integer % 5 == 0 && integer % 3 == 0 ) {
                        return Stream.of("FizzBuzz");
                    } else if (integer % 5 == 0) {
                        return Stream.of("Buzz");
                    } else if (integer % 3 == 0) {
                        return Stream.of("Fizz");
                    } else {
                        return Stream.of(String.valueOf(integer));
                    }
                })
                .collect(Collectors.toList());
    }
}
