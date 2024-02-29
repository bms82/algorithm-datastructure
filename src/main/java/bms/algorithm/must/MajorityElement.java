package bms.algorithm.must;

import java.util.Arrays;

/**
 * LeetCode #169. Majority Element
 */
public class MajorityElement {

    // Finding a value that is more than 50% in an array.
    // if the array is sorted, median value will be the majority value.
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length /2];
    }

}
