package bms.programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTemplate {
    public int solution(int[] d, int budget) {
        boolean[][] dp = new boolean[d.length + 1][budget + 1];

        dp[0][0] = true;

        // Fill the DP table
        for (int i = 1; i <= d.length; i++) {
            for (int j = 0; j <= budget; j++) {
                // If not taking nums[i-1]
                dp[i][j] = dp[i - 1][j];
                // If taking nums[i-1], ensure it doesn't exceed the current sum
                if (j >= d[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - d[i - 1]];
                }
            }
        }

        // If there's no way to achieve the budget, return an empty list
        if (!dp[d.length][budget]) {
            return d.length;
        }

        // Backtrack to find the subset
        List<Integer> result = new ArrayList<>();
        int i = d.length, j = budget;
        while (i > 0 && j > 0) {
            if (dp[i][j] && !dp[i - 1][j]) {
                // If the current number was used
                result.add(d[i - 1]);
                j -= d[i - 1];
            }
            i--;
        }

        return result.size();
    }

    @Test
    public void testCase() {

        int[] d1 = new int[]{1,3,2,5,4};
        int b1 = 9;
        solution(d1, b1);

        int[] d2 = new int[]{2,2,3,3};
        int b2 = 10;
        solution(d2, b2);

    }
}
