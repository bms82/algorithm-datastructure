package bms.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {

        int[] top = new int[nums.length];
        int topIdx = 0;
        top[topIdx] = nums[0];
        int piles = 1;
        for (int i = 1; i < nums.length; i++) {
            if (top[topIdx] < nums[i]) {
                top[++topIdx] = nums[i];
                piles++;
            } else {
                for (int j =0; j < top.length; j++) {
                    if (top[j] > nums[i]) {
                        top[j] = nums[i];
                        break;
                    }
                }

            }
        }
        return piles;
    }

    public int lengthOfLISExample(int[] nums) {
        int[] top = new int[nums.length];
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            int poker = nums[i];

            // 왼쪽 가장자리를 탐색하는 이진탐색
            int left = 0;
            int right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == piles) piles++;
            top[left] = poker;

        }

        return piles;

    }

    @Test
    public void checkMethod() {

        int[] nums1 = new int[]{6,3,5,10,11,2,9,14,13,7,4,8,12};
        assertEquals(lengthOfLIS(nums1), 5);

    }

}
