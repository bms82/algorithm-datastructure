package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MajorityElement {

    public int checkStraightLine(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length / 2];

    }

    @Test
    public void checkAns() {

        int[] coordinates = new int[]{2,2,1,1,1,2,2};

        int result = checkStraightLine(coordinates);
        assert result == 2;

    }
}
