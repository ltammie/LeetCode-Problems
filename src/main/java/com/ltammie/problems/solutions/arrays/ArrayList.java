package com.ltammie.problems.solutions.arrays;

import java.util.*;

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
     * @No 35
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

    /**
     * @No 169
     * majority element
     * @algo hashmap to count occurrences
     */
    public int majorityElement(int[] array) {
        Map<Integer, Integer> occurrences = new HashMap<>();

        for (int num : array) {
            if (occurrences.containsKey(num))
                occurrences.replace(num, occurrences.get(num) + 1);
            else occurrences.put(num, 1);
        }

        return Collections.max(occurrences.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    /**
     * @No 169
     * majority element
     * @algo sorting and return element at array.length/2
     */
    public int majorityElementSort(int[] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    }

    /**
     * @No 414
     * Third Maximum Number
     */
    public int thirdMax(int[] nums) {
        int[] distinct = Arrays.stream(nums).distinct().toArray();
        Arrays.sort(distinct);
        if (distinct.length < 3)
            return distinct[distinct.length - 1];
        return distinct[distinct.length - 3];
    }

    /**
     * @No 1346
     * 1346. Check If N and Its Double Exist
     * @algo binarySearch
     */
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int zeros = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (zeros == 2)
                    return true;
                zeros++;
                continue;
            }
            int x = binarySearch(arr, 0, arr.length - 1, arr[i] * 2);
            if (x != -1) {
                if (x != i && arr[x] / 2 == arr[i])
                    return true;
            }
            int y = binarySearch(arr, 0, arr.length - 1, arr[i] / 2);
            if (y != -1) {
                if (y != i && arr[y] * 2 == arr[i])
                    return true;
            }
        }
        return zeros == 2;
    }

    /**
     * @param arr array to be searched
     * @param low lower bound of the array
     * @param high higher bound of the array
     * @param target number to be searched in the array
     * @return index of the found number of -1 if nothing found
     */
    public int binarySearch(int[] arr, int low, int high, int target) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                return binarySearch(arr, mid + 1, high, target);
            return binarySearch(arr, low, mid - 1, target);
        }
        return -1;
    }
}
