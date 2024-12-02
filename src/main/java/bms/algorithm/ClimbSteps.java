package bms.algorithm;

import org.junit.jupiter.api.Test;

public class ClimbSteps {


    public int climbStairs(int n) {
        int[] nums = new int[n];
        if (n < 4) {
            nums[n-1] = n;
            return nums[n-1];
        } else {
            for (int i =1; i< 3;i++) {
                nums[i-1] = i;
            }
            for (int j = 3; j < n+1;j++) {
                nums[j - 1] = nums[j - 2] + nums[j - 3];
            }
        }
        return nums[n-1];
    }

    @Test
    public void checkCase() {
        int ans1 = climbStairs(4);
        assert ans1 == 5;

    }
}
