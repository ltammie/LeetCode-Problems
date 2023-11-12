package com.ltammie.problems.blind75;

import java.util.*;

/**
 * @No 15
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0)
            return Collections.emptyList();

        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum > 0) {   // move left
                    k--;
                } else {                // move right
                    j++;
                }
            }
        }
        return new ArrayList<>(res);
    }
}
