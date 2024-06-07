package algorithms.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author phongpq
 */
public class ContainsDuplicate217 {
    private Set<Integer> seen = new HashSet<>();

    public boolean containsDuplicate(int[] nums) {
        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}
