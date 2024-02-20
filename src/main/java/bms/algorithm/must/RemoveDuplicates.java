package bms.algorithm.must;

import org.junit.jupiter.api.Test;

/**
 *
 * LeetCode #26. Remove Duplicates from Sorted Array
 */
public class RemoveDuplicates {

    // Constraint
    // C1. nums.length range from 1 to 30,000
    // C2. nums[i] range from -100 to 100
    // C3. nums is sorted in ascending order
    public int removeDuplicates(int[] nums) {
        int baseNum = nums[0];
        int ptr = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > baseNum) {
                baseNum = nums[i];
                nums[ptr] = baseNum;
                ptr++;
            }

        }
        return ptr;
    }

    @Test
    public void checkCase() {


        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        assert removeDuplicates(nums) == 5;
    }

}
