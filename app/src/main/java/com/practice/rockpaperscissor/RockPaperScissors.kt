package com.practice.rockpaperscissor

fun main() {
    digitize(510000)
    getAscii('C')
    checkFactor(5, 10)
    mixedSum(listOf(23,50, "89"))
    replace("Hello WORLD")
    rps("rock", "paper")
    doubleChar("Big Man Ting yeah")
    sumPositives(arrayOf(20, -4, 10).toIntArray())
    reverseSeq(5)
    points(listOf("1:1", "2:4", "1:0", "4:3", "5:5", "2:1", "0:0"))
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
fun mixedSum(mixed: List<Any>): Int {
    return mixed.sumOf() {
        when(it) {
            is Int -> it
            is String -> it.toIntOrNull() ?: 0
            else -> 0
        }
    }
}

// Replace all vowel to EXCLAMATION mark in the SENTENCE
fun replace(s: String): String {
    var newS = ""
    val vow = "aeiou"
    for (i in s) {
        if(i.lowercaseChar() in vow) {
            newS +="!"
        } else {
            newS += i
        }
    }
    print("$s __ $newS")
    return newS
}

// ROCK PAPER SCISSORS
fun rps(p1: String, p2: String): String{
    return when {
        p1 == p2 -> "Draw!"
        (p1 == "scissors" && p2 == "paper")
                || (p2 == "scissors" && p1 == "rock")
                || (p2 == "rock" && p1 == "paper")
                    -> "Player 1 won!"
        else -> "Player 2 won!"
    }
}

//DOUBLING CHARACTERS
fun doubleChar(s: String): String {
    val myArrayedString = s.toList().map {"$it" + "$it"}
    return myArrayedString.joinToString("")
}

//SUMMING POSITIVE NUMBERS ONLY
fun sumPositives(numbers: IntArray): Int {
    val ourArray = numbers.filter {it > 0}
    return ourArray.sum()
}

//RETURNING REVERSED ARRAY FROM A REFERENCE
fun reverseSeq(n: Int): List<Int> {
    val ourList = mutableListOf<Int>()
    for(n in 1..n) {
        ourList.add(n)
    }
    print(ourList.reverse()) // this will update the mutable array regardless unless you use `reversed()` instead
    return ourList
}

// TEAM POINTS CALCULATION
fun points(games: List<String>): Int {
    var score = 0
    var newArr = games.map {it.split(":").map {it.toInt()}}
    print(newArr)
    for(n in newArr) {
        val x = n[0]
        val y = n[1]
        when {
            (x > y) -> score += 3
            (x < y) -> score += 0
            else -> score += 1
        }
    }
    return score
}