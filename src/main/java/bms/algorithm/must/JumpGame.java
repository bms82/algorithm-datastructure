package bms.algorithm.must;

import org.junit.jupiter.api.Test;

/**
 * LeetCode #55. JumpGame
 */
public class JumpGame {

    // Constraint
    // C1. nums.length ranges from 1 to 10,000
    // C2. nums elements range from 0 to 100,000
    // Procedure
    // P1. if nums.length is 1, return true;
    // P2. have to variables ready, one for maximum reach and another for index.
    // P3. while in the range of maximum reach, update maximum reach for each index.
    // P4. Check whether one exceeds maximum reach.
    public boolean canJump(int[] nums) {

        if (nums.length == 1) return true;
        int maxPosition = 0;
        int idx = 0;
        while (maxPosition < nums.length - 1 && idx <= maxPosition) {
            if (nums[idx] + idx > maxPosition) {
                maxPosition = nums[idx] + idx;
            }
            if (maxPosition >= nums.length - 1) return true;
            idx++;

        }
        return false;
    }

    @Test
    public void checkCase() {

        int[] nums = new int[]{2,3,1,1,4};
        assert canJump(nums);

        nums = new int[]{3,2,1,0,4};
        assert !canJump(nums);


    }

}
