package com.ltammie.problems

import com.ltammie.problems.blind75.GroupAnagram

fun main() {
    val s = GroupAnagram();
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    s.groupAnagramsFast(strs)
}