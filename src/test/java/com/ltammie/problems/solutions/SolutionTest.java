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
}