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
     * @param arr    array to be searched
     * @param low    lower bound of the array
     * @param high   higher bound of the array
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

    /**
     * @No 2099
     * Find Subsequence of Length K With the Largest Sum
     */
    public int[] maxSubsequence(int[] nums, int k) {
        //todo
        return null;
    }

    /**
     * @No 1480
     * Running Sum of 1d Array
     */
    public int[] runningSum(int[] nums) {
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            nums[i] = currentSum;
        }
        return nums;
    }

    /**
     * @No 724
     * Find Pivot Index
     */
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == total - leftSum - nums[i])
                return i;
            leftSum += nums[i];
        }
        return -1;
    }

    /**
     * @No 977
     * Squares of a Sorted Array
     */
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int low = 0;
        int high = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[low]) >= Math.abs(nums[high])) {
                res[i] = nums[low] * nums[low];
                low++;
            } else {
                res[i] = nums[high] * nums[high];
                high--;
            }
        }
        return res;
    }

    /**
     * @No 189
     * Rotate Array
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }

    /**
     * @No 283
     * Move zeroes to the end of the array
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }

    /**
     * @No 167
     * Two Sum II - Input Array Is Sorted
     * @algo two-pointer
     * if current sum is smaller than a target -> move closer to the right
     * if current sum is higher than a target -> move closer to the left
     */

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (numbers[left] + numbers[right] != target) {
            if (numbers[left] + numbers[right] < target)
                left++;
            else right--;
        }

        return new int[] {left+1, right+1};
    }

    private void reverseArray(int[] array, int start, int end) {
        while (start < end) {
            int tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
    }


}
