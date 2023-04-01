package com.ltammie.problems.solutions;

import java.util.Arrays;
import java.util.Stack;

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

    /**
     * @No 191
     */
    public int hammingWeight(int n) {
        String number = Integer.toBinaryString(n);

        int weight = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '1') {
                weight++;
            }
        }
        return weight;
    }

    /**
     * @No 1281
     */
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            product *= digit;
            sum += digit;
            n /= 10;
        }
        return product - sum;
    }

    /**
     * @No 20 Valid Parentheses
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(')');
            else if (s.charAt(i) == '{')
                stack.push('}');
            else if (s.charAt(i) == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != s.charAt(i))
                return false;
        }
        return stack.isEmpty();
    }

    /**
     * @No 13. Roman to Integer
     * I -> V, X
     * X -> L, C
     * C -> D, M
     */
    public int romanToInt(String s) {
        int res = 0;
        s = s.replace("IV", "IIII")
                .replace("IX", "VIIII")
                .replace("XL", "XXXX")
                .replace("XC", "LXXXX")
                .replace("CD", "CCCC")
                .replace("CM", "DCCCC");

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == 'M') {
                res += 1000;
            } else if (c == 'D') {
                res += 500;
            } else if (c == 'C') {
                res += 100;
            } else if (c == 'L') {
                res += 50;
            } else if (c == 'X') {
                res += 10;
            } else if (c == 'V') {
                res += 5;
            } else {
                res += 1;
            }
            i++;
        }
        return res;
    }

    /**
     * @No 14. Longest Common Prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1)
            return strs[0];

        if (strs[0].length() == 0)
            return "";
        char[] symbols = new char[strs[0].length()];
        int[] count = new int[strs[0].length()];
        for (int i = 0; i < symbols.length; i++) {
            symbols[i] = strs[0].charAt(i);
            count[i] = 1;
        }

        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() == 0 || symbols[0] != strs[i].charAt(0))
                return "";
            for (int j = 0; j < strs[i].length(); j++) {
                if (symbols.length == j)
                    break;
                if (symbols[j] == strs[i].charAt(j)) {
                    count[j]++;
                }
            }
        }

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != count[0]) {
                break;
            }
            s.append(symbols[i]);
        }
        return s.toString();
    }
}
