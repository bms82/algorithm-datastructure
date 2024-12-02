package bms.dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LCS {

    static int longestCommonSequence(String s1, String s2) {

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        Arrays.fill(dp[0], 0);

        for (int i = 1; i < s1.length(); i++) {
            dp[i][0] = 0;
            for (int j = 1; j < s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i -1][j]) + 1;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i -1][j]);
            }

        }


        return dp[s1.length() - 1][s2.length() - 1];

    }

    @Test
    public void checkMethod() {
        String s1 = "abcde";
        String s2 = "aceb";
        assertEquals(longestCommonSequence(s1, s2), 3);

    }
}
