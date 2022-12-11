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
}
