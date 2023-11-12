package com.ltammie.problems.blind75;

public class BestTimeToBuyAndSellStock {

    /**
     * @No 121
     */
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentProfit = prices[i] - min;
            if (currentProfit < 0) {
                min = prices[i];
                continue;
            }
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }

        return maxProfit;
    }
}
