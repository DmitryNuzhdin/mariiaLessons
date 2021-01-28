package leetcode.fizzBuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<Integer> fizzBuzzArrayList= new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            fizzBuzzArrayList.add(i + 1);
        }
        return fizzBuzzArrayList.stream()
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
