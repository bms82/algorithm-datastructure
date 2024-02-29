package bms.algorithm.must;

import org.junit.jupiter.api.Test;

/**
 * LeetCode #45. JumpGame II
 */
public class JumpGame2 {
    // Constraint
    // C1. nums.length range from 1 to 10,000
    // C2. nums elements range from 0 to 1,000
    // C3. there is a way to reach the final index.
    // Procedure
    // P1. Start from nums[0];
    // P2. Find the idx that could go farthest
    // P3. Repeat P1 and P2 until it can reach the final index.
    public int jump(int[] nums) {
        int steps = 0;
        if (nums.length == 1) return steps;
        int idx = 0;
        while (idx < nums.length -1) {
            int maxPosition = nums[idx] + idx;
            steps++;
            int maxValue = maxPosition;
            if (maxPosition >= nums.length - 1) break;
            for (int i = idx; i <= maxPosition; i++) {
                if (maxValue < nums[i] + i) {
                    idx = i;
                    maxValue = nums[i] + i;
                }
            }
            if (maxPosition == maxValue) {
                idx = maxPosition;
            }
        }


        return steps;
    }

    @Test
    public void checkCase() {

        int[] nums = new int[]{2,3,1,1,4};
        assert jump(nums) == 2;
        nums = new int[]{2,3,0,1,4};
        assert jump(nums) == 2;

        nums = new int[]{3,2,1,1,2,3};
        assert jump(nums) == 3;
        nums = new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        assert jump(nums) == 2;
    }
}
