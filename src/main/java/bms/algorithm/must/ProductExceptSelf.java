package bms.algorithm.must;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 *
 * LeetCode #238. Product of Array Except Self
 */

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int[] leftProd = Arrays.copyOf(nums, nums.length);
        int[] rightProd = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < nums.length; i++) {
            leftProd[i] *= leftProd[i - 1];
        }
        for (int i = nums.length - 2; i > -1; i--) {
            rightProd[i] *= rightProd[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                nums[i] = rightProd[i + 1];
            else if (i == nums.length - 1)
                nums[i] = leftProd[i - 1];
            else
                nums[i] = leftProd[i - 1] * rightProd[i+1];
        }
        return nums;
    }

    @Test
    public void checkCase() {

        int[] nums = new int[]{-1,1,0,-3,3};
        assert Arrays.equals(new int[]{0,0,9,0,0}, productExceptSelf(nums));

        nums = new int[]{1,2,3,4};
        assert Arrays.equals(new int[]{24,12,8,6}, productExceptSelf(nums));
    }

}
