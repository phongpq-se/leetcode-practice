package algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class MinSteps1347 {
    public static int minSteps(String s, String t) {
        Map<Character, Integer> characterWithOccurrenceCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!characterWithOccurrenceCount.containsKey(s.charAt(i))) {
                characterWithOccurrenceCount.put(s.charAt(i), 1);
            } else {
                characterWithOccurrenceCount.computeIfPresent(s.charAt(i), (k, v) -> v + 1);
            }
        }

        characterWithOccurrenceCount.forEach((k, v) -> {
            System.out.println("v : " + +k + " " + v);
        });

        for (int i = 0; i < t.length(); i++) {
            characterWithOccurrenceCount.computeIfPresent(t.charAt(i), (k, v) -> {
                if (v == 0) {
                    return v;
                } else {
                    return v - 1;
                }
            });
        }

        characterWithOccurrenceCount.forEach((k, v) -> {
            System.out.println("v : " + +k + " " + v);
        });
        return characterWithOccurrenceCount.values().stream()
                .reduce(0, Integer::sum);
    }
}
