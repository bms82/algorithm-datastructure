package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #1253. Reconstruct a 2-Row Binary Matrix
 * Given the following details of a matrix with n columns and 2 rows :
 *
 *     The matrix is a binary matrix, which means each element in the matrix can be 0 or 1.
 *     The sum of elements of the 0-th(upper) row is given as upper.
 *     The sum of elements of the 1-st(lower) row is given as lower.
 *     The sum of elements in the i-th column(0-indexed) is colsum[i], where colsum is given as an integer array with length n.
 *
 * Your task is to reconstruct the matrix with upper, lower and colsum.
 *
 * Return it as a 2-D integer array.
 *
 * If there are more than one valid solution, any of them will be accepted.
 *
 * If no valid solution exists, return an empty 2-D array.
 */
public class ReconstructMatrix {

    //Constraints
    // C1. colsum range from 1 to 100,000
    // C2. col number range from 0 to 2
    // C3. upper and lower range is equal to colsum length
    // Procedure
    // P1. for statement of colsum values
    // P2. if colsum[i] = 0, upper and lower rows all have 0
    // P3. if colsum[i] = 2, upper and lower rows all have 1 and decrease upper and lower values by 1
    // P4. if colsum[i] = 1, check whether upper is higher than lower and if so, add 1 to upper row and 0 to lower row, else the opposite.
    // P5. end of for statement. if upper and lower values are not 0 then return and empty list.
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {

        List<List<Integer>> resultList = new ArrayList<>();
        int totalSum = 0;
        List<Integer> upperRow = new ArrayList<>();
        List<Integer> lowerRow = new ArrayList<>();

        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 0) {
                upperRow.add(0);
                lowerRow.add(0);
                continue;
            }
            totalSum += colsum[i];
            if (colsum[i] == 2) {
                upperRow.add(1);
                lowerRow.add(1);
                upper--;
                lower--;
            } else if (colsum[i] == 1) {
                if (upper > lower) {
                    upperRow.add(1);
                    upper--;
                    lowerRow.add(0);
                } else {
                    lowerRow.add(1);
                    upperRow.add(0);
                    lower--;

                }
            }
        }
        if (lower != 0 || upper != 0)
            return new ArrayList<>();
        resultList.add(upperRow);
        resultList.add(lowerRow);
        return resultList;
    }

    @Test
    public void checkCase() {

        int upper = 2, lower = 1;
        int[]colsum = new int[]{1,1,1};
        assert reconstructMatrix(upper, lower, colsum).size() == 2;

        upper = 2;
        lower = 3;
        colsum = new int[]{2,2,1,1};
        assert reconstructMatrix(upper, lower, colsum).size() == 0;

        upper = 5;
        lower = 5;
        colsum = new int[]{2,1,2,0,1,0,1,2,0,1};
        assert reconstructMatrix(upper, lower, colsum).size() == 2;

        upper = 1;
        lower = 4;
        colsum = new int[]{2,1,2,0,0,2};
        assert reconstructMatrix(upper, lower, colsum).size() == 0;


    }
}
