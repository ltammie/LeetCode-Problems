package com.ltammie.problems.sorts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SortUtilsTest {

    @Test
    void bubbleSort() {
        int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] actual = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] nullArray = null;
        int[] oneSizedArray = new int[]{999};

        SortUtils.bubbleSort(actual);
        SortUtils.bubbleSort(nullArray);
        SortUtils.bubbleSort(oneSizedArray);

        assertArrayEquals(expected, actual);
        assertNull(nullArray);
        assertArrayEquals(new int[]{999}, oneSizedArray);
    }

    @Test
    void quickSort() {
        int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] actual = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] oneSizedArray = new int[]{999};

        SortUtils.quickSort(actual, 0, actual.length - 1, false);
        SortUtils.quickSort(oneSizedArray, 0, oneSizedArray.length - 1, false);

        assertArrayEquals(expected, actual);
        assertArrayEquals(new int[]{999}, oneSizedArray);
    }
    @Test
    void quickSortRandom() {
        int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] actual = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] oneSizedArray = new int[]{999};

        SortUtils.quickSort(actual, 0, actual.length - 1, true);
        SortUtils.quickSort(oneSizedArray, 0, oneSizedArray.length - 1, true);

        assertArrayEquals(expected, actual);
        assertArrayEquals(new int[]{999}, oneSizedArray);
    }

    @Test
    void mergeSort() {
        int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] actual = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        SortUtils.mergeSort(actual, 0, actual.length - 1);

        assertArrayEquals(expected, actual);
    }
}