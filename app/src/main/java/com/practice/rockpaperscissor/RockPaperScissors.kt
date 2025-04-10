package com.practice.rockpaperscissor

fun main() {
    digitize(510000)
    getAscii('C')
    checkFactor(5, 10)
    mixedSum(listOf(23,50, "89"))
}

// CONVERT NUMBERS TO REVERSED ARRAY OF DIGITS
fun digitize(n:Long): IntArray {
    val nArr = n.toString().map {it.toString().toInt()}
    return nArr.reversed().toIntArray()
}

// GET ASCII VALUE OF A CHARACTER
fun getAscii(c: Char): Int {
    return c.code
}

//CHECK FOR FACTOR
fun checkFactor(base: Int, factor: Int ): Boolean {
    return if(base % factor == 0) true else false
}

//MAP AN ARRAY TO DOUBLE ITS ITEMS
fun maps(x: IntArray): IntArray {
    val doubled = x.map {it * 2}
    return doubled.toIntArray()
}

//SUM OF MIXED ARRAYS
fun mixedSum(mixed: List<any>): Int {
    return mixed.sumOf() {
        when(it) {
            is Int -> it
            is String -> it.toIntOrNull() ?: 0
            else -> 0
        }
    }
}
