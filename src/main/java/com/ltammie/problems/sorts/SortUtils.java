package com.ltammie.problems.sorts;

public class SortUtils {

    public static int[] bubbleSort(int[] array) {
        if (array == null)
            return null;
        if (array.length <= 1)
            return array;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[i]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }

        return array;
    }
}
