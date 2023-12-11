package algorithms;

import java.util.HashMap;
import java.util.Map;

/*
* Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
* */
public class RomanToInteger13 {
    private static final Map<Character, Integer> mapRomanToInteger = new HashMap<>();

    static {
        mapRomanToInteger.put('I', 1);
        mapRomanToInteger.put('V', 5);
        mapRomanToInteger.put('X', 10);
        mapRomanToInteger.put('L', 50);
        mapRomanToInteger.put('C', 100);
        mapRomanToInteger.put('D', 500);
        mapRomanToInteger.put('M', 1000);
    }

    public static int romanToInt(String s) {
        if (s.isEmpty()) return 0;
        int total = mapRomanToInteger.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 1; i > 0; i--) {
            int a = mapRomanToInteger.get(s.charAt(i));
            int b = mapRomanToInteger.get(s.charAt(i - 1));
            if (a <= b) {
                total = total + b;
            } else {
                total = total - b;
            }
        }
        return total;
    }
}
