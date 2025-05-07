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
    maxDiffHandler(arrayOf("lana", "del", "rey"), arrayOf("able", "tesfaye") )
    smallEnough(intArrayOf(12,34,54), 56)
    nameValue(arrayOf("digitize", "get ascii", "checkFactor"))
    catMouse("C..................m")
    accum("pekapeka")
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

// FOOTBALL TEAM POINTS CALCULATION
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

//MAXIMUM LENGTH DIFFERENCE
fun maxDiffHandler(a1:Array<String>, a2:Array<String>):Int {
    if(a1.isEmpty() || a2.isEmpty()) return -1
    val highX = a1.maxByOrNull {it.length}.toString().length
    val lowX = a1.minByOrNull {it.length}.toString().length
    val highY = a2.maxByOrNull {it.length}.toString().length
    val lowY = a2.minByOrNull {it.length}.toString().length
    val result1 = highX - lowY
    val result2 = highY - lowX
    val result =  listOf(result1, result2).maxByOrNull { it }
    return if(result is Int ) result else -1
}

//SMALL ENOUGH ? -- BEGINNER LEVEL
fun smallEnough(a : IntArray, limit : Int) : Boolean {
    return a.maxBy { it } <= limit
}

// WORD INTO VALUES
fun nameValue(arr: Array<String>): IntArray {
        val asciiInit = 96

        val result = arr.map {
            it.lowercase().toCharArray().map {it.code - asciiInit}
        }.map {it.filter {it > 0}.sum()}

        return result.mapIndexed {index, value -> value * (index + 1)}.toIntArray()
}

// CAR -  MOUSE EASY VERSION
fun catMouse(s: String): String {
    return if(s.split("....").size == 2)  "Escaped!" else "Caught!"
}

fun accum(str:String):String {
    val arrayed = str.mapIndexed {i, s -> s
        .toChar()
        .uppercase() +
            s.toString()
                .lowercase()
                .repeat(i)};
    return (arrayed.joinToString("-"))
}