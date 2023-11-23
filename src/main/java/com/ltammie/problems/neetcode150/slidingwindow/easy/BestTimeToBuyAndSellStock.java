package com.ltammie.problems.neetcode150.slidingwindow.easy;

/**
 * @No 121. Best Time to Buy and Sell Stock
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int max = 0;
        int left = 0;
        int right = left + 1;

        while (right < prices.length) {
            int currentSum = prices[right] - prices[left];
            if (currentSum < 0) {
                left = right;
            } else if (currentSum > max) {
                max = currentSum;
            }
            right++;
        }
        return max;
    }
}
