package com.ltammie.problems.solutions

/**
 * @theme Top Interview Questions
 * @No 171
 */
fun titleToNumber(columnTitle: String): Int {
    var sum = 0
    for (c in columnTitle) {
        sum *= 26
        sum += c - 'A' + 1
    }
    return sum
}