package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode #2811. Check if it is Possible to Split Array
 * You are given an array nums of length n and an integer m. You need to determine if it is possible to split the array into n non-empty arrays by performing a series of steps.
 *
 * In each step, you can select an existing array (which may be the result of previous steps) with a length of at least two and split it into two subarrays, if, for each resulting subarray, at least one of the following holds:
 *
 *     The length of the subarray is one, or
 *     The sum of elements of the subarray is greater than or equal to m.
 *
 * Return true if you can split the given array into n arrays, otherwise return false.
 *
 * Note: A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class CanSplitArray {
    // Constraint
    // C1. nums.size range from 1 to 100
    // C2. nums range from 1 to 100
    // C3. m range from 1 to 200
    // Procedure
    // P1. Check size of nums. Nums less than three always meets the condition.
    // P2. Find the largest sum of the continuing pair.
    // P3. If the largest sum is less than m, then it is false.
    public boolean canSplitArray(List<Integer> nums, int m) {
        int maxValue = 0;
        if (nums.size() < 3)
            return true;
        for (int i = 0; i< nums.size() -1; i++) {
            if (nums.get(i) + nums.get(i + 1) > maxValue)
                maxValue = nums.get(i) + nums.get(i + 1);
        }
        if (maxValue < m)
            return false;
        return true;
    }

    @Test
    public void checkCase() {

        List<Integer> nums = Arrays.asList(2, 2, 1);
        int m = 4;
        assert canSplitArray(nums, m);

        nums = Arrays.asList(2, 1, 3);
        m = 5;
        assert !canSplitArray(nums, m);

        nums = Arrays.asList(2, 3, 3, 2, 3);
        m = 6;
        assert canSplitArray(nums, m);


    }
}
