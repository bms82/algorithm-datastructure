package bms.algorithm.must;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #12. Integer to Roman
 */
public class Int2Roman {

    // Constraint
    // C1. num ranges from 1 to 3,999
    // Procedure
    // P1. Make a map for designated numbers. Subtract each Number until 0.
    // P2. For each digit values convert to the appropriate roman numeral.
    Object [][] storeIntRoman = {{1000, "M"}, {900, "CM"}, {500, "D"}, {400, "CD"}, {100, "C"}, {90, "XC"}, {50, "L"},
            {40, "XL"}, {10, "X"}, {9, "IX"}, {5, "V"}, {4, "IV"}, {1, "I"}};
    public String intToRoman(int num) {
        StringBuilder romanNum = new StringBuilder();
        for (int i = 0; i < storeIntRoman.length; i++) {
            while (num >= (int) storeIntRoman[i][0]) {
                romanNum.append(storeIntRoman[i][1]);
                num -= (int) storeIntRoman[i][0];
            }
        }
        return romanNum.toString();
    }



}
