package com.ltammie.problems.arrays;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array with positive numbers and a positive target number,
 * find all of its contiguous subarrays whose product is less than the target number.
 */
public class SubarraysWithProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] nums, int k) {
        List<List<Integer>> result = new LinkedList<>();
        if (k <= 1)
            return Collections.emptyList();

        int left = 0;
        int right = 1;
        int product = nums[left];
        if (product < k)
            result.add(List.of(nums[left]));

        while (right < nums.length) {
            product *= nums[right];

            if (product < k) {
                result.addAll(getSubArrays(nums, left, right));
            } else {
                while (product >= k) {
                    product /= nums[left];
                    left++;
                }
                result.addAll(getSubArrays(nums, left, right));
            }
            right++;
        }
        return result;
    }


    private static List<List<Integer>> getSubArrays(int[] nums, int left, int right) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> subArray = new LinkedList<>();

        // instead of shrinking subArray from left to right, we grow it from right
        // then copy it to tmp variable and add result, appending to the begging
        // because we are doing it form right side, not left
        // other way the order of elements and subArrays will be reversed

        while (left <= right) {
            subArray.add(0, nums[right]);
            List<Integer> tmp = new LinkedList<>(subArray);
            result.add(0, tmp);
            right--;
        }

        return result;
    }


    public static void main(String[] args) {
        List<List<Integer>> res = findSubarrays(new int[]{2, 5, 3, 10}, 30);
        System.out.println(res);
    }
}
