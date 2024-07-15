package bms.algorithm.must;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #134. Gas Station
 */
public class GasStation {

    // Constraint
    // C1.
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        for (int g : gas) {
            sumGas += g;
        }
        int sumCost = 0;
        for (int c : cost) {
            sumCost += c;
        }
        if (sumCost > sumGas) {
            return -1;
        }
        int currentGas = 0;
        int resultIdx = 0;

        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                resultIdx = i + 1;
            }
        }
        return resultIdx;
     }

    @Test
    public void checkCase() {

        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        assert canCompleteCircuit(gas, cost) == 3;

        gas = new int[]{2,3,4};
        cost = new int[]{3,4,3};
        assert canCompleteCircuit(gas, cost) == -1;

        gas = new int[]{5,1,2,3,4};
        cost = new int[]{4,4,1,5,1};
        assert canCompleteCircuit(gas, cost) == 4;


        gas = new int[]{5,8,2,8};
        cost = new int[]{6,5,6,6};
        assert canCompleteCircuit(gas, cost) == 3;

    }





}
