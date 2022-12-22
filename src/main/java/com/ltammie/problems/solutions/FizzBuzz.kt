package com.ltammie.problems.solutions

/**
 * @theme Top Interview Questions
 * @No 412
 */
fun fizzBuzz(n: Int): List<String> {
    val result = mutableListOf<String>()

    for (i in 1 .. n) {
        if (i % 3 == 0 && i % 5 == 0)
            result.add("FizzBuzz")
        else if (i % 3 == 0)
            result.add("Fizz")
        else if (i % 5 == 0)
            result.add("Buzz")
        else
            result.add(i.toString())
    }
    return result
}

fun fizzBuzzWithoutModular(n: Int): List<String> {
    val result = mutableListOf<String>()
    var fizz = 0
    var buzz = 0
    for (i in 1 .. n) {
        fizz++
        buzz++
        if (fizz == 3 && buzz == 5) {
            result.add("FizzBuzz")
            fizz = 0
            buzz = 0
        } else if (fizz == 3) {
            result.add("Fizz")
            fizz = 0
        } else if (buzz == 5) {
            result.add("Buzz")
            buzz = 0
        } else result.add(i.toString())
    }
    return result
}