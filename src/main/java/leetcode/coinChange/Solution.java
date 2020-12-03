package leetcode.coinChange;

import java.util.Arrays;

public class Solution {
    public int coinChange (int[] coins, int amount) {
        if (amount == 0) { return 0;}
        Arrays.sort(coins);
        int currentRem = 0;
        int currentSum = amount;
        int minOfNumCoins = amount + 1;
        int currentMinOfNumCoins = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] > amount) {continue;}
            for (int n = i; n >= 0; n--) {
                currentRem = currentSum % coins[n];
                if (currentRem < currentSum) {
                    currentMinOfNumCoins += currentSum / coins[n];
                    currentSum = currentRem;
                }
                if (currentSum == 0) {
                    break;
                }
            }
            if (currentSum != 0) {
                currentMinOfNumCoins = 0;
            } else if (currentMinOfNumCoins < minOfNumCoins) {
                minOfNumCoins = currentMinOfNumCoins;
            }
            currentSum = amount;
        }
        if (minOfNumCoins == amount + 1) {
            return -1;
        } else {
            return minOfNumCoins;
        }
    }
}
