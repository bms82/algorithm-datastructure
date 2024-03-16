package bms.algorithm.must;

import org.junit.jupiter.api.Test;

/**
 * LeetCode #58. Length of Last Word.
 */
public class LastWordLength {

    // Constraint
    // C1. string has at least one word. the length ranges from 1 to 10,000
    // Procedure
    // P1. Find the where the last word ends.
    // P2. count the letters from the end letter to the next space.
    public int lengthOfLastWord(String s) {

        int idx = s.length() - 1;
        while (s.charAt(idx) == ' ') {
            idx--;
        }
        int cnt = 0;
        while (idx > -1 && s.charAt(idx) != ' ') {
            cnt++;
            idx--;
        }
        return cnt;
    }

    @Test
    public void checkCase() {

        String s = "a";
        assert lengthOfLastWord(s) == 1;


    }

}
