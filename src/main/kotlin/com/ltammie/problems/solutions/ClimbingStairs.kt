package com.ltammie.problems.solutions

/**
 * @theme Top Interview Questions
 * @No 70
 */
fun climbStairs(n: Int): Int {
    when (n) {
        0 -> return 0
        1 -> return 1
        2 -> return 2
        3 -> return 3
    }
    var oneBefore = 3
    var twoBefore = 2
    var ways = 0
    for (i in 4 .. n ) {
        ways = oneBefore + twoBefore
        twoBefore = oneBefore
        oneBefore = ways
    }
    return ways
}