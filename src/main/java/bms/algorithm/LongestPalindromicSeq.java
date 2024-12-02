package bms.algorithm;

public class LongestPalindromicSeq {
    public int longestPalindromeSubseq(String s) {
        int ans = 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > -1; j--) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(1,2);
            }
        }


        return ans;
    }

}
