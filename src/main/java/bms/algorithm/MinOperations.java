package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode # 2870. Minimum Number of Operations to Make Array Empty
 */
public class MinOperations {

    public int minOperations(int[] nums) {
        int numOfOperations = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            int count = 0;
            if (countMap.containsKey(num))
                count = countMap.get(num);
            count++;
            countMap.put(num, count);
        }
        for (int numCount : countMap.values()) {;
            if (numCount < 2)
                return -1;
            if (numCount % 3 == 0) {
                numOfOperations += (numCount / 3);
            } else {
                numOfOperations += (numCount / 3) + 1;
            }
        }


        return numOfOperations;
    }


    @Test
    public void checkCase() {

        int[] nums = new int[]{2,3,3,2,2,4,2,3,4};
        assert minOperations(nums) == 4;

        nums = new int[]{2,1,2,2,3,3};
        assert minOperations(nums) == -1;
    }
}
