package com.ltammie.problems.solutions

/**
 * @theme Top Interview Questions
 * @No 242
 */
fun isAnagram(s: String, t: String): Boolean {
    val alphabet = IntArray(26)
    for (i in s.indices)
        alphabet[s[i] - 'a']++
    for (i in t.indices)
        alphabet[t[i] - 'a']--
    for (i in alphabet)
        if (i != 0)
            return false
    return true
}