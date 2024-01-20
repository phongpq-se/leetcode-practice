package algorithms.arrays;

/*
* Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.



Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation:
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444
* */
public class SumSubarrayMins907 {
    public int sumSubarrayMins(int[] arr) {
        int M = (int) 1e9 + 7;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            sum = sum + arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum = sum + min;
                sum = sum % M;
            }
        }
        return sum;
    }
}
