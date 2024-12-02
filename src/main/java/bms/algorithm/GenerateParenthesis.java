package bms.algorithm;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        String track = "";
        backtrack(res, n, 0, track);
        return res;
    }

    private void backtrack(List<String> res, int n, int i, String track) {

        if (i == 2 * n)
            return;
        return;

    }
}
