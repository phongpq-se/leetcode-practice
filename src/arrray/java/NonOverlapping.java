package arrray.java;

import java.util.Arrays;
import java.util.Comparator;

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
