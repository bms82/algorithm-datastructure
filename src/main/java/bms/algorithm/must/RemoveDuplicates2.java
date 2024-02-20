package bms.algorithm.must;

import org.junit.jupiter.api.Test;

/**
 * LeetCode #80. Remove Duplicates from Sorted Array II
 */
public class RemoveDuplicates2 {

    public int removeDuplicates(int[] nums) {
        int ptr = 1;
        int baseNum = nums[0];
        boolean isTwice = false;
        for (int i = 1; i < nums.length; i++) {
            if (!isTwice && baseNum == nums[i]) {
                isTwice = true;
                nums[ptr] = baseNum;
                ptr++;
                continue;
            }
            if (nums[i] > baseNum) {
                baseNum = nums[i];
                isTwice = false;
                nums[ptr] = baseNum;
                ptr++;
            }
        }

        return ptr;
    }


    @Test
    public void checkCase() {

        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        assert removeDuplicates(nums) == 7;

        nums = new int[]{1,1,1,2,2,3};
        assert removeDuplicates(nums) == 5;
    }

}
