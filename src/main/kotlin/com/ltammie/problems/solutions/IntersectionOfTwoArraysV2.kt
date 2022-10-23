package com.ltammie.problems.solutions

/**
 * @theme Top Interview Questions
 * @No 350
 */
fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val map = hashMapOf<Int, Int>()
    val intersection = mutableListOf<Int>()
    for (i in nums1.indices){
        if (map.containsKey(nums1[i]))
            map[nums1[i]] = map[nums1[i]]!! + 1
        else map[nums1[i]] = 1
    }

    for (i in nums2.indices) {
        if (map.containsKey(nums2[i]) && map[nums2[i]]!! > 0) {
            intersection.add(nums2[i])
            map[nums2[i]] = map[nums2[i]]!! - 1
        }
    }
    return intersection.toIntArray()
}