package algorithms.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
* Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
*/
public class UniqueNumberOfOccurrences1207 {

    private final Map<Integer, Integer> indexWithOccurrence = new HashMap<>();

    public boolean uniqueOccurrences(int[] arr) {
        for (int i : arr) {
            indexWithOccurrence.put(i, indexWithOccurrence.getOrDefault(i, 0) + 1);
        }

        Set<Integer> set = new HashSet<>(indexWithOccurrence.values());
        return indexWithOccurrence.size() == set.size();
    }
}
