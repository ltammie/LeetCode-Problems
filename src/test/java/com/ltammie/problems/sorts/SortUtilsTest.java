package com.ltammie.problems.sorts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortUtilsTest {

    @Test
    void bubbleSort() {
        int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] actual = SortUtils.bubbleSort(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});

        assertArrayEquals(expected, actual);
    }
}