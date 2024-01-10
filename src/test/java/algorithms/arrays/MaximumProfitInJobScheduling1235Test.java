package algorithms.arrays;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;


public class MaximumProfitInJobScheduling1235Test {

    @Test
    public void testTreeMap() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(5, 10);
        treeMap.put(4, 10);
        treeMap.put(8, 20);
        treeMap.put(2, 20);
        treeMap.put(12, 20);
        treeMap.put(10, 20);
        System.out.println(treeMap.floorEntry(11));
    }

    @Test
    public void test01() {
        MaximumProfitInJobScheduling1235.jobScheduling(
                new int[]{1, 2, 3, 3},
                new int[]{3, 4, 5, 6},
                new int[]{50, 10, 40, 70}
        );
    }

    @Test
    public void test02() {
        MaximumProfitInJobScheduling1235.jobScheduling(
                new int[]{1, 2, 3, 4, 6},
                new int[]{3, 5, 10, 6, 9},
                new int[]{20, 20, 100, 70, 60}
        );
    }
}
