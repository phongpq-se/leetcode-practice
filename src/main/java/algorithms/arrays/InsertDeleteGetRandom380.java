package algorithms.arrays;

import com.sun.source.doctree.SeeTree;

import java.util.*;

public class InsertDeleteGetRandom380 {
    public static class RandomizedSet {
        Set<Integer> randomList;
        Random random = new Random();

        public RandomizedSet() {
            randomList = new HashSet<>();
        }

        public boolean insert(int val) {
            if (randomList.contains(val)) {
                return false;
            } else {
                randomList.add(val);
                return true;
            }
        }

        public boolean remove(int val) {
            if (randomList.contains(val)) {
                randomList.remove(val);
                return true;
            } else {
                return false;
            }
        }

        public Integer getRandom() {
            if (randomList.isEmpty()) {
                return null;
            }
            int randomIndex = random.nextInt(randomList.size());
            int i = 0;
            for (Integer element : randomList) {
                if (i == randomIndex) {
                    return element;
                }
                i++;
            }
            return null;
        }
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
