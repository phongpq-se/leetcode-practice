package algorithms.arrays;

import org.junit.jupiter.api.Test;

public class MinFallingPathSum931Test {

    @Test
    public void test() {
        int[][] c = {
                {100,-42,-46,-41},
                {31,97,10,-10},
                {-58,-51,82,89},
                {51,81,69,-51}
        };
        MinFallingPathSum931.minFallingPathSum(c);
    }
}
