package bms.algorithm;

import org.junit.jupiter.api.Test;

/**
 * LeetCode #2765. Longest Alternating Subarray
 */
public class AlternatingSubArray {

    // Constraint
    // C1. nums length range from 2 to 100
    // C2. nums range from 1 to 10,000
    public int alternatingSubarray(int[] nums) {
        int seqLength = -1;
        for (int i = 0; i < nums.length-1; i++) {
            int currCount = 1;
            boolean isPlus = false;
            int idx = i + 1;
            if (nums[i] + 1 == nums[i + 1]) {
                currCount++;
                while (idx < nums.length - 1) {
                    if (!isPlus && nums[idx] - 1 == nums[idx + 1]) {
                        currCount++;
                        isPlus = true;
                    } else if (isPlus && nums[idx] + 1 == nums[idx + 1]) {
                        currCount++;
                        isPlus = false;
                    } else
                        break;
                    idx++;
                }
                if (currCount > 1 && currCount > seqLength)
                    seqLength = currCount;
            }
            if (i > nums.length/2 && seqLength > nums.length/2)
                return seqLength;
        }

        return seqLength;
    }

    @Test
    public void checkCase() {

        int[] nums = new int[]{2,3,4,3,4};
        assert alternatingSubarray(nums) == 4;

        nums = new int[]{4,5,6};
        assert alternatingSubarray(nums) == 2;

    }

}
