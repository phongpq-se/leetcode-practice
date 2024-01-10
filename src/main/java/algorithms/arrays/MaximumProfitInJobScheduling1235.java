package algorithms.arrays;

import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class MaximumProfitInJobScheduling1235 {
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];

        // 1. create multiple jobs
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
            System.out.println("job " + i + " " + jobs[i][0] + ":" + jobs[i][1] + ":" + jobs[i][2]);
        }

        // 2. sort job by end time
        Arrays.sort(jobs, Comparator.comparingInt(v -> v[1]));
        for (int[] job : jobs) {
            System.out.println("job sorted " + job[1]);
        }

        // 3. create sorted Map
        // key: storage end time
        // value: storage profit history
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);

        for (int[] job : jobs) {
            //4 get profit of before stage and profit of job
            int cur = dp.floorEntry(job[0]).getValue() + job[2];

            //5 total profit > maxProfit current
            if (cur > dp.lastEntry().getValue()) {
                dp.put(job[1], cur);
            }
        }

        return dp.lastEntry().getValue();
    }
}
