package com.ltammie.problems.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void countOdds() {
        Solution s = new Solution();
        assertAll("",
                () -> assertEquals(3, s.countOdds(3, 7)),
                () -> assertEquals(1, s.countOdds(8, 10)),
                () -> assertEquals(1, s.countOdds(9, 10)),
                () -> assertEquals(1, s.countOdds(9, 9)),
                () -> assertEquals(1, s.countOdds(0, 1)),
                () -> assertEquals(0, s.countOdds(2, 2))
        );
    }

    @Test
    void average() {
        Solution s = new Solution();
        assertAll("",
                () -> assertEquals(2500.00000, s.average(new int[]{4000, 3000, 1000, 2000})),
                () -> assertEquals(2000.00000, s.average(new int[]{1000, 2000, 3000}))
        );
    }

    @Test
    void hammingWeight() {
        Solution s = new Solution();
        assertAll("",
                () -> assertEquals(3, s.hammingWeight(11)),
                () -> assertEquals(1, s.hammingWeight(128)),
                () -> assertEquals(31, s.hammingWeight(-3))
        );
    }

    @Test
    void subtractProductAndSum() {
        Solution s = new Solution();
        assertAll("",
                () -> assertEquals(15, s.subtractProductAndSum(234)),
                () -> assertEquals(21, s.subtractProductAndSum(4421))
        );
    }

    @Test
    void isValid() {
        Solution s = new Solution();
        assertAll("",
                () -> assertTrue(s.isValid("()")),
                () -> assertTrue(s.isValid("()[]{}")),
                () -> assertFalse(s.isValid("(]")),
                () -> assertTrue(s.isValid("([{}])")),
                () -> assertFalse(s.isValid("([{}[)"))
        );
    }

    @Test
    void romanToInt() {
        Solution s = new Solution();
        assertAll("",
                () -> assertEquals(3, s.romanToInt("III")),
                () -> assertEquals(58, s.romanToInt("LVIII")),
                () -> assertEquals(1994, s.romanToInt("MCMXCIV"))
        );
    }

    @Test
    void longestCommonPrefix() {
        Solution s = new Solution();
        assertAll("",
                () -> assertEquals("fl", s.longestCommonPrefix(new String[]{"flower", "flow", "flight"})),
                () -> assertEquals("", s.longestCommonPrefix(new String[]{"dog", "racecar", "car"})),
                () -> assertEquals("a", s.longestCommonPrefix(new String[]{"a", "ac"}))
        );
    }

    @Test
    void areAlmostEqual() {
        Solution s = new Solution();
        assertAll("",
                () -> assertTrue(s.areAlmostEqual("bank", "kanb")),
                () -> assertFalse(s.areAlmostEqual("abcd", "dcba")),
                () -> assertFalse(s.areAlmostEqual("attack", "defend")),
                () -> assertTrue(s.areAlmostEqual("kelb", "kelb")),
                () -> assertTrue(s.areAlmostEqual("akrjnhuojtkhlqdfifwxbsmphhcchuqcconcvplcyxjpi", "akrjnhuojtkhlxdfifwqbsmphhcchuqcconcvplcyxjpi"))
        );
    }

    @Test
    void updateMatrix() {
        Solution s = new Solution();
        assertAll("",
                () -> {
                    int[][] mat = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
                    assertArrayEquals(
                            new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}},
                            s.updateMatrix(mat));
                },
                () -> {
                    int[][] mat = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
                    assertArrayEquals(
                            new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 2, 1}},
                            s.updateMatrix(mat));
                }
        );
    }
}