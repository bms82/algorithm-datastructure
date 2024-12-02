package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    List<List<Integer>> combination(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0) return res;
        List<Integer> track = new ArrayList<>();
        backtrack(res, n, k, 1, track);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int n, int k, int start, List<Integer> track) {

        if (k == track.size()) {
            res.add(track);
            return;
        }
        for (int i = start; i <= n; i++) {
            List<Integer> track2 = new ArrayList<>(track);
            track2.add(i);
            backtrack(res, n, k, i + 1, track2);
        }

    }


    @Test
    public void checkCase() {

        int n = 4;
        int k = 2;

        List<List<Integer>> combination  = combination(n, k);
        System.out.println(combination);


    }


}
