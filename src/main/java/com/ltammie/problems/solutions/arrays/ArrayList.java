package com.ltammie.problems.solutions.arrays;

import java.util.HashMap;
import java.util.Map;

public class ArrayList {

    public ArrayList() {
    }

    /**
     * @No 27
     * in-place removal
     */
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    /**
     * @No 66
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    /**
     * @No 136
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> occurrences = new HashMap<>();

        for (int num : nums) {
            if (occurrences.containsKey(num)) {
                occurrences.remove(num);
            } else {
                occurrences.put(num, num);
            }
        }
        return occurrences.keySet().iterator().next();
    }

    /**
     * @No 26
     * array is sorted in non-decreasing order
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
        }
        return slow + 1;
    }

    /**
     * 35
     * binary search
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target) {
                low = mid + 1;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        return low;
    }
}
