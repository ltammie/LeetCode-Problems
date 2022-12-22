package com.ltammie.problems.solutions

/**
 * @theme Top Interview Questions
 * @No 1
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    val map: MutableMap<Int, Int> = HashMap()
    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement)) {
            return intArrayOf(i, map[complement]!!)
        }
        map[nums[i]] = i
    }
    return intArrayOf(0, 1)
}