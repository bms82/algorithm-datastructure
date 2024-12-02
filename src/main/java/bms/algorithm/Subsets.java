package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> subsets(List<Integer> nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backtrack(res, 0, nums, track);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int start, List<Integer> nums, List<Integer> track) {
        res.add(track);
        for (int i = start; i < nums.size(); i++) {
            List<Integer> track2 = new ArrayList<>(track);
            track2.add(nums.get(i));
            backtrack(res, i + 1, nums, track2);

        }


    }


    @Test
    public void checkCase() {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);

        List<List<Integer>> subsets = subsets(nums);

        System.out.println(subsets);


    }
}
