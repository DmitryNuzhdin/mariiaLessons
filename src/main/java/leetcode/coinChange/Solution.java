package leetcode.coinChange;

import java.util.*;

public class Solution {
    int[] coins;
    Map<Integer, Integer> cache = new HashMap<>();


    public int coinChange (int[] coins, int amount) {
        this.coins = coins;

        cache.put(0, 0);

        for (Integer coin : coins) {
            cache.put(coin, 1);
        }

        return f(amount);
    }

    public int f(int amount) {
        if (amount < 0)
            return -1;
        else if (cache.containsKey(amount))
            return cache.get(amount);
        else {
            Optional<Integer> minOpt = Arrays.stream(coins)
                    .boxed()
                    .map(coin -> f(amount - coin))
                    .filter(i -> i != -1)
                    .map(i -> i + 1)
                    .min((i1, i2) -> i1.compareTo(i2));

            int ans = minOpt.orElse(-1);

            cache.put(amount, ans);

            return ans;
        }
    }

    public static void main(String[] args) {

    }
}
