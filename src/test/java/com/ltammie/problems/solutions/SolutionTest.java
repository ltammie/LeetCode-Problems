package com.ltammie.problems.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void fib() {
        Solution s = new Solution();
        assertEquals(0, s.fib(0));
        assertEquals(1, s.fib(1));
        assertEquals(1, s.fib(2));
        assertEquals(2, s.fib(3));
    }

    @Test
    void minCostClimbingStairs() {
        Solution s = new Solution();
        assertEquals(15, s.minCostClimbingStairs(new int[]{10, 15, 20}));
        assertEquals(6, s.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        assertEquals(1, s.minCostClimbingStairs(new int[]{1, 2}));
    }

    @Test
    void uniquePaths() {
        Solution s = new Solution();
        assertEquals(28, s.uniquePaths(3, 7));
        assertEquals(3, s.uniquePaths(3, 2));
        assertEquals(0, s.uniquePaths(0, 2));
        assertEquals(0, s.uniquePaths(2, 0));
        assertEquals(0, s.uniquePaths(0, 0));
    }

    @Test
    void updateMatrix() {
        Solution s = new Solution();
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] res = s.updateMatrix(mat);
        System.out.println();
    }
}