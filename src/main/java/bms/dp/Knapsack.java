package bms.dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Knapsack {

    public int fitIn(int capacity, int[] weights, int[] values) {

        int[][] dp = new int[weights.length + 1][capacity + 1];
        dp[0] = new int[capacity + 1];
        Arrays.fill(dp[0], 0);
        for (int i = 1; i <= weights.length; i++) {
            dp[i][0] = 0;
            for (int w = 1; w <= capacity; w++) {
                if (w - weights[i - 1] < 0) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[weights.length][capacity];
    }

    @Test
    public void testCase() {

        int[] values = new int[]{4,2,3};
        int[] weights = new int[]{2,1,3};
        int capacity = 15;
        System.out.println(fitIn(capacity, weights, values));
    }
}
