package com.practice.rockpaperscissor


fun main() {
   val sum = handleSum()
    val texter = sendText()
    print("$sum: $texter")
}

fun handleSum(txt: String? = sendText()): Int {
    val text = txt
    return text!!.length
}

fun sendText(): String {
    return "it is just a russian song"
}
