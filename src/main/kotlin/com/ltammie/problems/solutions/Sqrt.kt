package com.ltammie.problems.solutions

/**
 * @theme Top Interview Questions
 * @No 69
 */
fun mySqrt(x: Int): Int {
    if (x == 0)
        return 0
    var low = 1
    var high = x
    while (true) {
        val mid = (low + high) / 2
        if (mid > x / mid)
            high = mid - 1
        else {
            if (mid + 1 > x / (mid + 1))
                return mid
            low = mid + 1
        }
    }
}