package leetcode.bestTimeToBuyandSellStock;

public class Solution {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length >= 2) {
            int dayToBuy  = 0;
            for (int i = 1; i <= prices.length - 1; i++) {
                if (prices[i] - prices[dayToBuy] > maxProfit) {
                    maxProfit = prices[i] - prices[dayToBuy];
                } else if (prices[i] < prices[dayToBuy]) {
                    dayToBuy = i;
                }
            }
        }
        return maxProfit;
    }
}
