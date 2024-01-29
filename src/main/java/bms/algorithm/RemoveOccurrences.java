package bms.algorithm;

import org.junit.jupiter.api.Test;

/**
 * LeetCode #1910. Remove All Occurrences of a Substring
 */
public class RemoveOccurrences {

    /*
    Constraint
    C1. s.length and part.length < 1001
    C2. s and part all lowercase letters
    Procedure
    P1. Using while, check whether s contains part and rewrite s without the found part.
    P2. iterate until s does not contain part.
     */
    public String removeOccurrences(String s, String part) {

        while (s.contains(part)) {
            int idx = s.indexOf(part);
            s = s.substring(0,idx) + s.substring(idx+part.length());
        }

        return s;
    }

    @Test
    public void checkCase() {

        String s1 = "daabcbaabcbc";
        String part1 = "abc";
        assert removeOccurrences(s1, part1).equals("dab");
        String s2 = "axxxxyyyyb";
        String part2 = "xy";
        assert removeOccurrences(s2, part2).equals("ab");

    }

}
