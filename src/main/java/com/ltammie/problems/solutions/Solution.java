package com.ltammie.problems.solutions;

import java.util.Arrays;

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

    /**
     * @No 62 Unique Paths
     * @algo dynamic programming
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            grid[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            grid[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }
        return grid[m - 1][n - 1];
    }

    /**
     * @No 542 01 Matrix
     * @algo dfs
     */
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1)
                    continue;
            }
        }
        return mat;
    }

    /**
     * @No 1523
     */
    public int countOdds(int low, int high) {
        int total = high - low + 1;

        if (low % 2 == 1 && high % 2 == 1)
            return total / 2 + 1;
        return total / 2;
    }

    /**
     * @No 1491
     *
     * @param salary : 3 <= salary.length <= 100
     * Note:we can do it one pass without sorting the original array
     * by keeping track of max and min values
     */
    public double average(int[] salary) {
        int[] sorted = Arrays.stream(salary).sorted().toArray();

        double average = 0;
        for (int i = 1; i < sorted.length - 1; i++) {
            average += sorted[i];
        }
        return average / (sorted.length - 2);
    }
}
