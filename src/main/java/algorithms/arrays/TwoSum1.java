package algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            var check = target - nums[i];
            if (map.containsKey(check)) {
                return new int[]{map.get(check), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

}
