package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RemoveDuplicates {

    @Test
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) //return nums.length;
            return nums.length;
        int holdNum = nums[0];
        int countLength = 1;
        int[] newNums = new int[nums.length];
        newNums[0] = holdNum;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != holdNum) {
                holdNum = nums[i];
                newNums[countLength] = holdNum;
                countLength++;
            }
        }
        System.arraycopy(newNums, 0, nums, 0, countLength);
        System.out.println(Arrays.toString(nums));
        return countLength;
    }

    @Test
    public void actualCheck() {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4}; // Input array
        int[] expectedNums = new int[]{0,1,2,3,4,0,0,0,0,0}; // The expected answer with correct length

        int k = removeDuplicates(nums); // Calls your implementation
    }
}
