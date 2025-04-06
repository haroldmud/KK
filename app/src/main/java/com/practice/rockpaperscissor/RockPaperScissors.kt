package com.practice.rockpaperscissor

fun main() {
   val names: Array<String> = arrayOf("john", "harold", "jonas", "jonzing")
    for (i in (names.size - 1).downTo(0)) {
        println(names[i])
    }
    var n = 0;
    while (n > names.size) {
        n++
        println(names[n])
    }
}
