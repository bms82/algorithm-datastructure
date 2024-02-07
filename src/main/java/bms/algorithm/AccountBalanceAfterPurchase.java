package bms.algorithm;

/**
 * LeetCode #2806. Account Balance After Rounded Purchase
 */
public class AccountBalanceAfterPurchase {

    public int accountBalanceAfterPurchase(int purchaseAmount) {

        return 100 - (int) (Math.floor((purchaseAmount + 5) / 10) * 10);

    }
}
