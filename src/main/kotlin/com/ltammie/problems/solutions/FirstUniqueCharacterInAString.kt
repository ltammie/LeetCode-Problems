package com.ltammie.problems.solutions

/**
 * @theme Top Interview Questions
 * @No 387
 */
fun firstUniqChar(s: String): Int {
    val charFrequency = IntArray(26)
    for (i in s.indices)
        charFrequency[s[i] - 'a']++
    for (i in s.indices)
        if (charFrequency[s[i] - 'a'] == 1)
            return i
    return -1
}