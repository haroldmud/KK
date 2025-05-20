package com.practice.rockpaperscissor

fun main() {
    digitize(510000)
    maps(intArrayOf(3,23,4,5,34))
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
    mumbling("peekaboo")
    countRedBeads(67)
    moveTen("butuyalelonganalalite")
    hidePasswordFromConnection("https://www.codewars.com/kata/5a726f16373c2ee6c60000db/solutions/kotlin?password=12345&user=admin")
    searchMaxOrMin(
        searchMax = false,
        searchMin = true,
        intArrayOf(12,23,534,765,45,3,2,3,5,5,3,4,4,6,23,423,53,64563),
        arrayOf(-23, 32, 0,323, 0.242)
    )
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
    return base % factor == 0
}

//MAP AN ARRAY TO DOUBLE ITS ITEMS
fun maps(x: IntArray): IntArray {
    val doubled = x.map {it * 2}
    return doubled.toIntArray()
}

//SUM OF MIXED ARRAYS
fun mixedSum(mixed: List<Any>): Int {
    return mixed.sumOf {
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
    for(x in 1..n) {
        ourList.add(x)
    }
    print(ourList.reverse()) // this will update the mutable array regardless unless you use `reversed()` instead
    return ourList
}

// FOOTBALL TEAM POINTS CALCULATION
fun points(games: List<String>): Int {
    var score = 0
    val newArr = games.map {it.split(":").map {item -> item.toInt()}}
    print(newArr)
    for(n in newArr) {
        val x = n[0]
        val y = n[1]
        score += when {
            (x > y) -> 3
            (x < y) -> 0
            else ->  1
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
            it.lowercase().toCharArray().map {c -> c.code - asciiInit}
        }.map {c -> c.filter {it > 0}.sum()}

        return result.mapIndexed {index, value -> value * (index + 1)}.toIntArray()
}

// CAR -  MOUSE EASY VERSION
fun catMouse(s: String): String {
    return if(s.split("....").size == 2)  "Escaped!" else "Caught!"
}

//MUMBLING CHALLENGE
fun mumbling(str:String):String {
    val arrayed = str.mapIndexed {i, s -> s
        .uppercase() +
            s.toString() // because a set of concatenated characters should only be a string
                .lowercase()
                .repeat(i)}
    return (arrayed.joinToString("-"))
}

//COUNT BEADS: Two red beads are placed between every two blue beads count them
fun countRedBeads(nBlue: Int): Int {
    return if(nBlue < 2) 0 else (nBlue - 1) * 2
}

//MOVE 10: crypt a string by assigning to each character the 10th alphabet ahead of it
fun moveTen(s: String): String {
    val z = 'z'.code
    val a = 'a'.code
    val result = s.map{ item ->
        if(item.code + 10 <= z )
            (item.code + 10).toChar()
        else
            ((item.code + 10 - z) + a - 1).toChar()
    }.joinToString("")
    return result
}

//MAXIMUM NUMBER - Without using the max function
fun maxHandler(arr: IntArray): Int {
    var init = 0
    for(n in arr) {
        if(n > init) {
            init = n
        }
    }
    return init
}

//MINIMUM NUMBER - Without short cut functions
fun minHandler(arr: Array<Number>): Double {
    var init = arr[0].toDouble() // don't initialize with 0 unless your array is purely of ints just like 0
    for(n in arr) {
        if(n.toDouble() < init) {
            init = n.toDouble()
        }
    }
//    print(init)
    return init
}

//FIND MAXIMUM AND MINIMUM NUMBER
fun searchMaxOrMin(
    searchMax: Boolean,
    searchMin: Boolean,
    listMax: IntArray,
    listMin: Array<Number>
    ): Int {
    val max = maxHandler(listMax)
    val min: Double = minHandler(listMin)
  if(searchMax)  println("Here is the biggest number: $max")
  if(searchMin) print("Here is the smalles number: ${min.toInt()}")
    return -1
}

//HIDING PASSWORD IN URL
fun hidePasswordFromConnection(urlString: String): String {
    val result = urlString.split("password=").getOrNull(1)?.split("&")?.firstOrNull()
    val crypt = result?.map {"*"}?.joinToString("")
    return if(result != null && crypt != null)  urlString.replace(result, crypt) else ""
}

// GEOMETRICAL SEQUENCE(a: the initialize, r: the sequence, n: the number of sequence)
fun geometricSequenceElements(a: Int, r: Int, n: Int): String{
    val elements = mutableListOf<Int>()
    var init = a
    for(x in 1..<n) {
        if(x == 1) {
            elements.add(init)
        }
        elements.add(init * r)
        init *= r
    }
    return elements.joinToString(", ")
}

