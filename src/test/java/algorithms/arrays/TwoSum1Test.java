package algorithms.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSum1Test {
    @Test
    public void test01() {
        var rs = TwoSum1.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertThat(rs[0]).isEqualTo(0);
        assertThat(rs[1]).isEqualTo(1);
    }

    @Test
    public void test02() {
        var rs = TwoSum1.twoSum(new int[]{3, 2, 4}, 6);
        assertThat(rs[0]).isEqualTo(1);
        assertThat(rs[1]).isEqualTo(2);
    }

    @Test
    public void test03() {
        var rs = TwoSum1.twoSum(new int[]{3, 3}, 6);
        assertThat(rs[0]).isEqualTo(0);
        assertThat(rs[1]).isEqualTo(1);
    }
}
