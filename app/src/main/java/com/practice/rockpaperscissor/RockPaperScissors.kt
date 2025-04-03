package com.practice.rockpaperscissor

fun main() {
   val names: Array<String> = arrayOf("john", "harold")
    for (i in (names.size - 1).downTo(0)) {
        println(names[i])
    }
    var n = 0;
    do {
        n++
        println(names[n])
    } while (n > names.size)
}
