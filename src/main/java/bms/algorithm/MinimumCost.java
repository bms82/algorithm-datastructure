package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MinimumCost {

    class numCost {

        int number;
        int cost;

    }
    public long minCost(int[] nums, int[] cost) {

        int idxOfMaxCost = -1;
        long actualCost = -1;
        long fullAvg = 0;
        int costAvg = 0;
        int numAvg = 0;
        for (int i = 0; i < cost.length; i++) {
            numAvg += nums[i];
            costAvg += cost[i];
            fullAvg += ((long) nums[i] * cost[i]);
            if (cost[i] > actualCost) {
                actualCost = cost[i];
                idxOfMaxCost = i;
            }
        }
        numAvg /= nums.length;
        costAvg /= cost.length;
        fullAvg /= cost.length;

        Arrays.sort(nums);

        actualCost = 0;
        for (int j = 0; j < nums.length; j++) {
            long diff = Math.abs(nums[j] - nums[nums.length/2]);
//            long diff = Math.abs(nums[j] - numAvg);
            actualCost += diff * cost[j];

        }
        return actualCost;
    }


    @Test
    public void actualCheck() {
        int[] nums = new int[]{735103,366367,132236,133334,808160,113001,49051,735598,686615,665317,999793,426087,587000,649989,509946,743518};
        int[] newNums = new int[]{724182,447415,723725,902336,600863,287644,13836,665183,448859,917248,397790,898215,790754,320604,468575,825614};
        long result = minCost(nums, newNums);
        assert result == 1907611126748L;
    }

}
