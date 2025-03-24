package com.practice.rockpaperscissor

fun main() {
    print("Enter your age please\n")

    val age = readln().toIntOrNull() ?: -1
    if(age in 2..17) {
        println("you ain't allowed to enter ")
    } else if (age in 18..29) {
        println("you can get in the first stage")
    } else if (age < 1) {
        println("not supported, TRY AGAIN...")
    }
}
