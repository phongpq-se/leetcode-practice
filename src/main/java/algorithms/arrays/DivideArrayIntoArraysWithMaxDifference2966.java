package algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideArrayIntoArraysWithMaxDifference2966 {
    public int[][] divideArray(int[] nums, int k) {
        int size = nums.length;
        if (size % 3 != 0) {
            return new int[][]{};
        }

        Arrays.sort(nums);

        int[][] result = new int[0][0];

        for (int i = 0; i < size; i += 3) {
            if (i + 2 < size && nums[i + 2] - nums[i] <= k) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
            } else {
                return new int[][]{};
            }
        }
        return result;
    }
}
