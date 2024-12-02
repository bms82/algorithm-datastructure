package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.*;

public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        int[] sums = new int[nums1.length * nums2.length];
        int cntr = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> combined = new ArrayList<>();
                combined.add(nums1[i]);
                combined.add(nums2[j]);
                sums[cntr] = nums1[i] + nums2[j];
                resultList.add(combined);
                cntr++;
            }
        }

        if (sums.length <= k) {
            return resultList;
        }

        Arrays.sort(sums);
        List<List<Integer>> result = new ArrayList<>(k);
        for (List<Integer> a : resultList) {
            int listSum = 0;
            for (int element : a) {
                listSum += element;
            }
            if (listSum <= sums[k] && result.size() < k) {
                result.add(a);
            }
        }

        return result;

    }
    @Test
    public void checkAns() {

        int[] nums1 = new int[]{1,1,2};
        int[] nums2 = new int[]{1,2,3};
        int k = 3;

        List<List<Integer>> a = kSmallestPairs(nums1, nums2, k);
        System.out.println(a);

    }

}
