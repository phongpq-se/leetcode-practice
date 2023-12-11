package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Combinations {
    public void test() {
        String a = "";
        a.split(",");
    }

    public static List<List<Integer>> combine(int n, int k) {
        if (k == 1) {
            return IntStream.rangeClosed(1, n)
                    .mapToObj(Arrays::asList)
                    .collect(Collectors.toList());
        } else if (k == n) {
            List<Integer> collect = IntStream.rangeClosed(1, n).boxed()
                    .collect(Collectors.toList());
            return Collections.singletonList(collect);
        } else {
            List<List<Integer>> arrayLists = new ArrayList<>(Collections.emptyList());
            for (int i = 1; n - i >= k - 1; i++) {
                List<Integer> collect1 = IntStream.rangeClosed(i, i + k - 2).boxed()
                        .collect(Collectors.toList());

                for (int j = i + k - 1; j <= n; j++) {
                    System.out.println(j);
                    List<Integer> collect = Stream.concat(collect1.stream(), Stream.of(j))
                            .collect(Collectors.toList());
                    arrayLists.add(collect);
                }
            }
            return arrayLists;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        //int n = 5; int k = 5;
        //int n = 5;
        //int k = 1;
        List<List<Integer>> combine = combine(n, k);
        combine.forEach(System.out::println);
    }
}
