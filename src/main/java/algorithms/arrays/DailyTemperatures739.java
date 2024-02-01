package algorithms.arrays;

import java.util.Stack;

public class DailyTemperatures739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
                System.out.println("ret " + idx + " : " + ret[idx]);
            }
            System.out.println("push i " + i);
            stack.push(i);
        }
        for (int i = 0; i < ret.length; i++) {
            System.out.println("ret:" + ret[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});

    }
}
