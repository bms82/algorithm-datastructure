package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * LeetCode #739. Daily Temperatures
 *  ** How many days to wait for warmer temperatures?
 */
public class DailyTemperatures {

    // Constraints
    // C1. temperatures.length ranges from 1 to 100,000
    // C2. temperatures range from 30 to 100
    // Procedure
    // P1. for statement of the temperatures array
    // P2. within the for statement, while statement with the condition that the stack remains not empty
    // and the temperature of ith element is bigger than the temperature at the top of the index;
    // P3. Within the while statement, pop the index and put i - index as the number of warm days.
    // P4. for the remainders when the stack is not empty, put 0 in the result array.
    public int[] dailyTemperatures(int[] temperatures) {

        int[] warmdays = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                warmdays[index] = i - index;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            warmdays[index] = 0;
        }

        return warmdays;
    }


    @Test
    public void checkCase() {

        int[] case1 = new int[]{73,74,75,71,69,72,76,73};

        assert Arrays.equals(dailyTemperatures(case1), new int[]{1,1,4,2,1,1,0,0});
        int[] case2 = new int[]{30,40,50,60};
        assert Arrays.equals(dailyTemperatures(case2), new int[]{1,1,1,0});
        int[] case3 = new int[]{30,60,90};
        assert Arrays.equals(dailyTemperatures(case3), new int[]{1,1,0});


    }

}
