package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class MaxEnvelopes {

    int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int[] height = new int[n];
        for (int i = 0; i < n;i++) {
            height[i] = envelopes[i][1];
        }
        return 0;
    }



    @Test
    public void checkMethod() {


    }
}
