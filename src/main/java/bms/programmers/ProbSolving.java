package bms.programmers;

import org.junit.jupiter.api.Test;

public class ProbSolving {
    public int solution(int[] diffs, int[] times, long limit) {

        int minLevel = 1;
        int maxLevel = 1;
        limit -= times[0];
        for (int i = 1; i < times.length; i++) {
            limit = limit - times[i];
            if (diffs[i] > maxLevel) maxLevel = diffs[i];
            times[i - 1] += times[i];
        }

        while (minLevel <= maxLevel) {
            int mid = (minLevel + maxLevel) / 2;
            long sum = 0;
            for (int i = 1; i < diffs.length; i++) {
                if (diffs[i] > mid) {
                    sum += (long) times[i - 1] * (diffs[i] - mid);
                }
                if (sum > limit) {
                    break;
                }
            }
            if (limit < sum) {
                minLevel = mid + 1;
            } else {
                maxLevel = mid - 1;
            }
        }
        return minLevel;
    }

    @Test
    public void checkCase() {
  	    int[] diffs = new int[]{1, 99999, 100000, 99995};
        int[] times = new int[]{9999, 9001, 9999, 9001};
        long limit = 3456789012L;
        solution(diffs, times, limit);
    }
}
