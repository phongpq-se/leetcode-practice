package algorithms;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
*
Example 1:
Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
* */
public class RomanToInteger13Test {

    @Test
    public void test01() {
        String s = "III";
        int rs = RomanToInteger13.romanToInt(s);
        System.out.println(rs);
        assertThat(rs).isEqualTo(3);
    }

    @Test
    public void test02() {
        String s = "LVIII";
        int rs = RomanToInteger13.romanToInt(s);
        System.out.println(rs);
        assertThat(rs).isEqualTo(58);
    }

    @Test
    public void test03() {
        String s = "MCMXCIV";
        int rs = RomanToInteger13.romanToInt(s);
        System.out.println(rs);
        assertThat(rs).isEqualTo(1994);
    }
}
