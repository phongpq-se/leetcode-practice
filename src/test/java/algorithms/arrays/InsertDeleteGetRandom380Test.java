package algorithms.arrays;

import org.junit.jupiter.api.Test;

public class InsertDeleteGetRandom380Test {

    @Test
    public void test01() {
        var randomSet = new InsertDeleteGetRandom380.RandomizedSet();
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.remove(1));
        System.out.println(randomSet.getRandom());
    }
}
