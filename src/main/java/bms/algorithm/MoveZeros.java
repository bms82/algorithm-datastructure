package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class MoveZeros {

    public void movingZeros(int[] nums) {

        int i=0;
        for (int num:nums)
        {
            if(num != 0)
            {
                nums[i]=num;
                i++;
            }
        }
        while (i < nums.length)
        {
            nums[i]=0;
            i++;
        }
    }

    @Test
    public void checkAns() {

        int[] coordinates = new int[]{0,1,0,3,12};

        movingZeros(coordinates);


    }
}
