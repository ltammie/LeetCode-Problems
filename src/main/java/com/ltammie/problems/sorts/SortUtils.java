package com.ltammie.problems.sorts;

import java.util.Random;

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

    /**
     *
     * @param array array to be sorted
     * @param low lower bound of the array (or sub-array)
     * @param high higher boun of the array (or sub-array)
     * @param isRandom how a pivot point shoud be chosen - randomly or pick an element at array[high]
     */
    public static void quickSort(int[] array, int low, int high, boolean isRandom) {
        if (low < high) {
            int part = partition(array, low, high, isRandom);
            quickSort(array, low, part - 1, isRandom);
            quickSort(array, part + 1, high, isRandom);
        }
    }

    public static void mergeSort(int[] array, int low, int high) {
        if (array == null)
            return;
        if (low < high) {

            int mid = low + (high - low) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, high, mid);
        }
    }

    private static void merge(int[] array, int low, int high, int mid) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++)
            left[i] = array[i + low];
        for (int i = 0; i < n2; i++)
            right[i] = array[i + mid + 1];

        int i = 0;
        int j = 0;
        int k = low;
        while (i < n1 && j < n2) {
            if (left[i] < right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = left[j];
            j++;
            k++;
        }
    }

    private static int partition(int[] array, int low, int high, boolean isRandom) {
        Random randomizer = new Random();
        if (isRandom) {
            int pivotIndex = randomizer.ints(low, high + 1)
                    .findFirst()
                    .getAsInt();
            swap(array,pivotIndex,high);
        }

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
