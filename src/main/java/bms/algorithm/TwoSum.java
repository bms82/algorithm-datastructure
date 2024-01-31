package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * LeetCode #1. Two Sum
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0;i < nums.length; i++) {
            int findNum = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == findNum) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }

    @Test
    public void checkCase(String[] args) {


        int[] testnum = new int[]{2,7,11,15};
        int testTarget = 9;


        int[] ans = twoSum(testnum, testTarget);

        System.out.println(Arrays.toString(ans));
    }

}
