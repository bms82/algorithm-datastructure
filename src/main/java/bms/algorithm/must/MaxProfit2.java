package bms.algorithm.must;

import org.junit.jupiter.api.Test;

/**
 * LeetCode #122. Best Time to Buy and Sell Stocks II
 */
public class MaxProfit2 {

    // Procedure
    // P1. Have the base price in place as prices[0]
    // P2-1. If price[i] more than base price, sell the stock.
    // P2-2. Else change the base price to price[i]
    public int maxProfit(int[] prices) {
        int profit = 0;
        int cPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (cPrice < prices[i]) {
                profit += (prices[i] - cPrice);
                cPrice = prices[i];
            } else {
                cPrice = prices[i];
            }
        }
        return profit;
    }

    @Test
    public void checkCase() {
        int[] prices = new int[]{7,6,4,3,1};
        assert maxProfit(prices) == 0;

        prices = new int[]{7,1,5,3,6,4};
        assert maxProfit(prices) == 7;

        prices = new int[]{1,2,3,4,5,6};
        assert maxProfit(prices) == 5;

    }
}
