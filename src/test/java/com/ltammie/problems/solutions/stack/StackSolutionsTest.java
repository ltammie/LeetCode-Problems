package com.ltammie.problems.solutions.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackSolutionsTest {

    @Test
    void asteroidCollision() {
        StackSolutions solution = new StackSolutions();

        assertAll("",
                () -> assertArrayEquals(new int[]{5, 10}, solution.asteroidCollision(new int[]{5, 10, -5})),
                () -> assertArrayEquals(new int[]{}, solution.asteroidCollision(new int[]{8, -8})),
                () -> assertArrayEquals(new int[]{10}, solution.asteroidCollision(new int[]{10, 2, -5})),
                () -> assertArrayEquals(new int[]{-2, -1, 1, 2}, solution.asteroidCollision(new int[]{-2, -1, 1, 2})),
                () -> assertArrayEquals(new int[]{-2}, solution.asteroidCollision(new int[]{-2, 2, -1, -2})),
                () -> assertArrayEquals(new int[]{-2, -1}, solution.asteroidCollision(new int[]{-2, 1, -1, -1}))
        );
    }

    @Test
    void evalRPN() {
        StackSolutions solution = new StackSolutions();

        assertAll("",
                () -> assertEquals(9, solution.evalRPN(new String[]{"2", "1", "+", "3", "*"})),
                () -> assertEquals(6, solution.evalRPN(new String[]{"4", "13", "5", "/", "+"})),
                () -> assertEquals(22, solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}))
        );
    }

    @Test
    void nextGreaterElement() {
        StackSolutions solution = new StackSolutions();

        assertAll("",
                () -> assertArrayEquals(new int[]{-1, 3, -1}, solution.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})),
                () -> assertArrayEquals(new int[]{3, -1}, solution.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4}))
        );
    }

    @Test
    void dailyTemperatures() {
        StackSolutions solution = new StackSolutions();

        assertAll("",
                () -> assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})),
                () -> assertArrayEquals(new int[]{1, 1, 1, 0}, solution.dailyTemperatures(new int[]{30, 40, 50, 60})),
                () -> assertArrayEquals(new int[]{1, 1, 0}, solution.dailyTemperatures(new int[]{30, 60, 90}))
        );
    }

    @Test
    void trap() {
        StackSolutions solution = new StackSolutions();
        assertAll("",
                () -> assertEquals(6, solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})),
                () -> assertEquals(9, solution.trap(new int[]{4, 2, 0, 3, 2, 5})),
                () -> assertEquals(2, solution.trap(new int[]{4, 2, 2, 3})),
                () -> assertEquals(4, solution.trap(new int[]{4, 2, 2, 4}))
        );

    }

    @Test
    void largestRectangleArea() {
        StackSolutions solution = new StackSolutions();

        assertAll("",
                () -> assertEquals(7, solution.largestRectangleArea(new int[]{2, 1, 2, 1, 2, 1, 2})),
                () -> assertEquals(5, solution.largestRectangleArea(new int[]{2, 1, 2, 1, 2, 0, 2})),
                () -> assertEquals(10, solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3})),
                () -> assertEquals(4, solution.largestRectangleArea(new int[]{2, 4})),
                () -> assertEquals(1, solution.largestRectangleArea(new int[]{1})),
                () -> assertEquals(9, solution.largestRectangleArea(new int[]{0, 9})),
                () -> assertEquals(9, solution.largestRectangleArea(new int[]{1, 9})),
                () -> assertEquals(9, solution.largestRectangleArea(new int[]{9, 0})),
                () -> assertEquals(9, solution.largestRectangleArea(new int[]{9, 0, 0})),
                () -> assertEquals(9, solution.largestRectangleArea(new int[]{0, 9, 0})),
                () -> assertEquals(3, solution.largestRectangleArea(new int[]{2, 1, 2}))
        );
    }

    @Test
    void findNextGreaterIndexes() {
        StackSolutions solution = new StackSolutions();
        assertAll("",
                () -> assertArrayEquals(
                        new int[]{-1, 6, 3, 6, 5, 6, 9, 9, 9, -1},
                        solution.findNextGreaterIndexes(new int[]{13, 8, 1, 5, 2, 5, 9, 7, 6, 12})
                )
        );
    }

    @Test
    void findPreviousGreaterIndexes() {
        StackSolutions solution = new StackSolutions();
        assertAll("",
                () -> assertArrayEquals(
                        new int[]{-1, 0, 1, 1, 3, 1, 0, 6, 7, 0},
                        solution.findPreviousGreaterIndexes(new int[]{13, 8, 1, 5, 2, 5, 9, 7, 6, 12})
                )
        );
    }
}