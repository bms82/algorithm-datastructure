package bms.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxSubArray {

    static int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[nums.length];
        int maxValue = Integer.MIN_VALUE;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currentSum = Math.max(nums[i], dp[i-1] + nums[i]);
            if (currentSum > nums[i])
                dp[i] = currentSum;
            else
                dp[i] = nums[i];
            maxValue = Math.max(maxValue, dp[i]);

        }

        return maxValue;
    }


    @Test
    void checkMethod() {
        int[] nums = new int[]{-3, 1, 3, -1, 2, -4, 2};
        assertEquals(maxSubArray(nums), 5);
    }
}
