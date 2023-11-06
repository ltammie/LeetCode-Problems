package com.ltammie.problems.arrays;

/**
 * @No 713. Subarray Product Less Than K
 */
public class NumSubarrayProductLessThanK {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;

        int res = 0;
        int left = 0;
        int right = 1;
        int product = nums[left];
        if (product < k)
            res++;

        while (right < nums.length) {
            product *= nums[right];

            if (product < k) {
                res += right - left + 1;
            } else {
                while (product >= k) {
                    product /= nums[left];
                    left++;
                }
                res += right - left + 1;
            }
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = numSubarrayProductLessThanK(new int[]{2, 5, 3, 6, 10}, 30);
        System.out.println(a);
        int b = numSubarrayProductLessThanK(new int[]{1, 1, 1}, 1);
        System.out.println(b);
        int c = numSubarrayProductLessThanK(new int[]{2, 3, 4, 5}, 30);
        System.out.println(a);
    }
}
