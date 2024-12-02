package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {

        if (nums.length < 1) return new ArrayList<String>();
        List<String> resultList = new ArrayList<>();
        if (nums.length < 2) {
            resultList.add(String.valueOf(nums[0]));
            return resultList;
        }
        for (int i = 0; i < nums.length; i++) {
            int startNum = nums[i];
            int endNum = nums[i];
            while (i < nums.length - 1) {
                i++;
                if (endNum + 1 == nums[i]) {
                    endNum = nums[i];
                } else {
                    i--;
                    break;
                }
            }
            if (startNum != endNum) {
                resultList.add(startNum + "->" + endNum);

            } else {
                resultList.add(String.valueOf(endNum));
            }
        }
        return resultList;
    }

    @Test
    public void checkAns() {
        String arrow = "->";
        int[] prob1 = new int[]{0,1,2,4,5,7};
        System.out.println(summaryRanges(prob1));
        int[] prob2 = new int[]{0,2,3,4,6,8,9};
        System.out.println(summaryRanges(prob2));
    }
}