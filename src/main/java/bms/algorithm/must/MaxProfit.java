package bms.algorithm.must;

import org.junit.jupiter.api.Test;

/**
 * LeetCode # 121. Best Time to Buy and Sell Stocks
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int cPrice = prices[0];
        int profit = 0;
        for (int i = 1;i < prices.length; i++) {
            if (cPrice > prices[i]) {
                cPrice = prices[i];
            }
            if (profit < prices[i] - cPrice) {
                profit =  prices[i] - cPrice;
            }
        }
        return profit;
    }

    @Test
    public void checkCase() {


        int[] prices = new int[]{7,6,4,3,1};
        assert maxProfit(prices) == 0;

        prices = new int[]{7,1,5,3,6,4};
        assert maxProfit(prices) == 5;
    }

}
