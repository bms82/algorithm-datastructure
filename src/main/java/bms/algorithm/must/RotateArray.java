package bms.algorithm.must;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * LeetCode #189. Rotate Array
 *
 */
public class RotateArray {

    // Constraints
    // C1. nums.length range from 1 to 100,000
    // C2. nums[i] range equal to int range
    // C3. k range from 1 to 100,000

    // Procedure
    // P1. reverse the whole array.
    // P2. Reverse the array from 0 to k - 1
    // P3. Reverse the array from k to nums.length -1;
    public void rotate(int[] nums, int k) {
        if (k == nums.length) return;
        if (k > nums.length) {
            k = k % nums.length;
        }
        reverseArray(nums, 0, nums.length);
        reverseArray(nums, 0, k);
        reverseArray(nums, k, nums.length);


    }

    public void reverseArray(int[] nums, int startIdx, int endIdx) {
        for (int i = startIdx; i < (startIdx + endIdx) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[endIdx +startIdx- i - 1];
            nums[endIdx + startIdx- i - 1] = temp;
        }
    }


    @Test
    public void checkCase() {

        int[] nums = new int[] {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        assert Arrays.equals(nums, new int[]{5,6,7,1,2,3,4});
        nums = new int[]{-1,-100,3,99};
        k = 2;
        rotate(nums, k);
        assert Arrays.equals(nums, new int[]{3,99,-1,-100});


        nums = new int[]{1,2,3,4,5,6,7,8,9,10, 11};
        k = 3;
        rotate(nums, k);
        // 8, 9, 10, 4, 5, 6, 7, 1, 2, 3 - >
        assert Arrays.equals(nums, new int[]{9,10,11,1,2,3,4,5,6,7, 8});

        nums = new int[] {1,2,3,4,5,6};
        k = 3;
        rotate(nums, k);
        assert Arrays.equals(nums, new int[]{4,5,6,1,2,3});

    }
}





























