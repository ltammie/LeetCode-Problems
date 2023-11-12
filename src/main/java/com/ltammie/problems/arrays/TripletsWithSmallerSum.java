package com.ltammie.problems.arrays;

import java.util.Arrays;

public class TripletsWithSmallerSum {
    public static int searchTriplets(int[] arr, int target) {
        int count = 0;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                if (currentSum < target) {
                    // there are right - left numbers that can be used with arr[i]
                    // as triplets because an array is sorted
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(
                searchTriplets(new int[]{-1, 0, 2, 3}, 3));
    }
}
