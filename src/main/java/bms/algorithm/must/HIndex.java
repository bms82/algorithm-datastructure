package bms.algorithm.must;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * LeetCode #274. H-Index
 */
public class HIndex {

    // Constraint
    // C1. citations.length range from 1 to 5,000
    // C2. citations[i] range from 0 to 1,0000
    // Procedure
    // P1. sort the citations array.
    // P2. find citations[i] < citations.length - i and deduct 1.
    public int hIndex(int[] citations) {

        Arrays.sort(citations);
        int hValue = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] < citations.length - i) {
                hValue--;
            }
        }

        return hValue;

    }

    @Test
    public void checkCase() {

        int[] citations = new int[]{3,0,6,1,5};
        assert hIndex(citations) == 3;
        citations = new int[] {1,3,1};
        assert  hIndex(citations) == 1;
    }
}
