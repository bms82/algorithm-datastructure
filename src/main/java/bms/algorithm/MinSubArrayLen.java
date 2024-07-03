package bms.algorithm;

import org.junit.jupiter.api.Test;

/**
 * LeetCode #209. Minimum Size Subarray Sum
 */


public class MinSubArrayLen {

    /**
     * sliding window algorithm
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {

        int rightIdx = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= target) {
                rightIdx = i;
                break;
            }
        }
        if (sum < target) return 0;
        if (sum == target && rightIdx == nums.length - 1) return nums.length;
        int minLen = rightIdx + 1;
        for (int leftIdx = 1; leftIdx < nums.length; leftIdx++) {
            int currSum = sum - nums[leftIdx - 1];
            if (currSum < target && rightIdx < nums.length - 1) {
                rightIdx++;
                sum = currSum + nums[rightIdx];
            } else if (currSum >= target) {
                int currLen = rightIdx - leftIdx + 1;
                if (currLen < minLen)
                    minLen = currLen;
                sum = currSum;
            }

        }
        return minLen;
    }

    @Test
    public void checkCase() {

        int caseTarget1 = 7;
        int[] caseNums1 = new int[]{2, 3, 1, 2, 4, 3};
        assert minSubArrayLen(caseTarget1, caseNums1) == 2;

        int caseTarget2 = 4;
        int[] caseNums2 = new int[]{1, 4, 4};
        assert minSubArrayLen(caseTarget2, caseNums2) == 1;

        int caseTarget3 = 11;
        int[] caseNums3 = new int[]{1, 1, 1, 1, 1, 1, 1};
        assert minSubArrayLen(caseTarget3, caseNums3) == 0;

        int caseTarget4 = 11;
        int[] caseNums4 = new int[]{1, 2,3,4,5};
        assert minSubArrayLen(caseTarget4, caseNums4) == 3;
        int caseTarget5 = 15;
        int[] caseNums5 = new int[]{5,1,3,5,10,7,4,9,2,8};
        assert minSubArrayLen(caseTarget5, caseNums5) == 2;

        int caseTarget6 = 5;
        int[] caseNums6 = new int[]{2,3,1,1,1,1,1,1};
        assert minSubArrayLen(caseTarget6, caseNums6) == 2;


    }
}
