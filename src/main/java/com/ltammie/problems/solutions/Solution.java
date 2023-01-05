package com.ltammie.problems.solutions;

public class Solution {

    /**
     * @No 509 Fibonacci Number
     * @algo dynamic programming
     */
    public int fib(int n) {
        if (n <= 1)
            return n;

        int prev = 1;
        int prevPrev = 0;
        int sum = 0;

        for (int i = 1; i < n; i++) {
            sum = prev + prevPrev;
            prevPrev = prev;
            prev = sum;
        }

        return sum;
    }

    /**
     * @No 746 Min Cost Climbing Stairs
     * @algo dynamic programming
     * array length >= 2
     */

    public int minCostClimbingStairs(int[] cost) {
        int[] stepCost = new int[cost.length + 1];
        int sum = 0;

        for (int i = 2; i < cost.length + 1; i++) {
            stepCost[i] += Math.min(stepCost[i - 1] + cost[i - 1], stepCost[i - 2] + cost[i - 2]);
            sum = stepCost[i];
        }

        return sum;
    }


}
