package algorithms;

import java.util.Arrays;

public class MaxProductDifference1913 {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[1] * nums[0]);
    }
}
