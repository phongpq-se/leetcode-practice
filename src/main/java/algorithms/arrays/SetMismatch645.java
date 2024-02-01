package algorithms.arrays;

import java.util.HashSet;
import java.util.Set;

public class SetMismatch645 {
    Set<Integer> set = new HashSet<>();

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] result = new int[2];
        long sum = (n * (n+1)) / 2;
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                result[0] = nums[i];
                sum -= i;
            }
        }
        return result;
    }
}
