package com.ltammie.problems.blind75;

/**
 * @No 238
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        int prev = 1;
        for (int i = 0; i < nums.length; i++) {
            prefix[i] = prev;
            prev *= nums[i];
        }

        prev = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            suffix[i] = prev;
            prev *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            prefix[i] *= suffix[i];
        }

        return prefix;
    }

    public static void main(String[] args) {
        var s = new ProductOfArrayExceptSelf();
        s.productExceptSelf(new int[]{1, 2, 3, 4});
    }

}