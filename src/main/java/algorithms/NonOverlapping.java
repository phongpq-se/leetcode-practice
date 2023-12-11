package algorithms;

import java.util.Arrays;
import java.util.Comparator;
/*
Given an array of intervals intervals where intervals[i] = [starti, endi],
return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
* */
public class NonOverlapping {
    public static int eraseOverlapIntervals1(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int prev = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                count++;
            }
        }
        return n - count;
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int[] reduce = Arrays.stream(intervals).skip(1).reduce(new int[]{intervals[0][1], 0}, (rs, v) -> {
            if (v[0] >= rs[0]) rs[0] = v[1];
            else rs[1] = rs[1] + 1;
            return rs;
        });
        return reduce[1];
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(input));
    }
}
