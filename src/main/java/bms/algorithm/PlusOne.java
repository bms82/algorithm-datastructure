package bms.algorithm;

import org.junit.jupiter.api.Test;

public class PlusOne {

    public int[] plusOne(int[] digits) {

        boolean overInt = false;
        int firstDigit = digits[digits.length - 1] + 1;
        if (firstDigit == 10) {
            overInt = true;
            digits[digits.length - 1] = 0;
        } else {
            digits[digits.length - 1] = firstDigit;
        }
        for (int i = digits.length - 2;i > -1; i--) {
            if (overInt) {
                digits[i] += 1;
                if (digits[i] == 10) {
                    digits[i] = 0;
                    overInt = true;
                } else {
                    overInt = false;
                    break;
                }
            }
        }
        if (overInt) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
            for (int i = 1; i < digits.length; i++) {
                digits[i] = 0;
            }
        }
        return digits;
    }


    @Test
    public void actualCheck() {
        int[] nums = new int[]{9,8,7,6,5,4,3,2,1,0};
        int[] newNums = null;
        newNums = plusOne(nums);
        assert newNums.length == 1;
    }



}
