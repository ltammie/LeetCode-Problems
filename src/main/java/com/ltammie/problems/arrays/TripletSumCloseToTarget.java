package com.ltammie.problems.arrays;

import java.util.Arrays;

public class TripletSumCloseToTarget {

    public static int searchTriplet(int[] arr, int targetSum) {
        int smallestDiff = Integer.MAX_VALUE;
        int diff = 0;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                diff = targetSum - currentSum;
                if (diff == 0)
                    return targetSum;

                if (Math.abs(diff) < Math.abs(smallestDiff)
                        || (Math.abs(diff) == Math.abs(smallestDiff)
                        && diff > smallestDiff)) {
                    smallestDiff = diff;
                }

                if (diff > 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return targetSum - smallestDiff;
    }

    public static void main(String[] args) {
        System.out.println(
                searchTriplet(new int[]{0, 0, 1, 1, 2, 6}, 5));
    }
}
