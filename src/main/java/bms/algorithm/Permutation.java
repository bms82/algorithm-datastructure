package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutation {

    List<List<Integer>> permute(List<Integer> nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backtrack(res, nums, track);
        return res;

    }

    private void backtrack(List<List<Integer>> res, List<Integer> nums, List<Integer> track) {

        if (track.size() == nums.size()) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (track.contains(nums.get(i))) continue;
            List<Integer> track2 = new LinkedList<>(track);
            track2.add(nums.get(i));
            backtrack(res, nums, track2);
        }

    }


    @Test
    public void checkCase() {

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        System.out.println(permute(nums));

    }

}
