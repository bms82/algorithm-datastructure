package bms.algorithm;

import org.junit.jupiter.api.Test;

/**
 *
 * LeetCode #35. Search Insert Position
 */
public class SearchInsert {

    // Constraints
    // C1. fit the target in a sorted array and return the index where the target was inserted
    // C2. nums range from -10000 to 10000
    // C3. complexity of O(log n)
    // Procedure
    // P1. for statement for nums and check whether each number is eq or larger than target
    // P2. if so, then return the index. when the for statement ends without any return, return the length of hums array.

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target)
                return i;
        }
        return nums.length;
    }

    @Test
    public void checkAns() {
        int[] nums = new int[]{1,3,5,6};
        int target = 2;
        int ans = searchInsert(nums, target);
        assert ans == 1;

        nums = new int[]{1,3,5,6};
        target = 5;
        ans = searchInsert(nums, target);
        assert ans == 2;

        nums = new int[]{1,3,5,6};
        target = 7;
        ans = searchInsert(nums, target);
        assert ans == 4;

    }

}
