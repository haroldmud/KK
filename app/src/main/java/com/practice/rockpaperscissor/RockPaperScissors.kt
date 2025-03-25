package com.practice.rockpaperscissor

fun main() {
    makeCoffee(30)
}

fun makeCoffee(spoons: Int) {
    var countSpoons = 0
    while(countSpoons  in 0 .. spoons - 1 ) {
        countSpoons ++
        print("$countSpoons:we've added $spoons spoons of sugar \n")
    }
}
