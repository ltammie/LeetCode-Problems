package com.ltammie.problems.sorts;

public class SortUtils {

    public static void bubbleSort(int[] array) {
        if (array == null)
            return;
        if (array.length <= 1)
            return;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[i]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int part = partition(array, low, high);
            quickSort(array, low, part - 1);
            quickSort(array, part + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
