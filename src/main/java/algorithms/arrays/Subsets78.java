package algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author phongpq
 */
public class Subsets78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        System.out.println("Call to backtrack with list: " + list + ", tempList: " + tempList + ", nums: " + Arrays.toString(nums) + ", start: " + start);
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            System.out.println("Remove last element from tempList: " + tempList.get(tempList.size() - 1) + " : " + list + ", tempList: " + tempList + ", nums: " + Arrays.toString(nums) + ", start: " + start);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3});
    }
}
