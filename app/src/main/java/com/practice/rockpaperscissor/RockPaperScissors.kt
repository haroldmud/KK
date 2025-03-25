package com.practice.rockpaperscissor


fun main() {
    println("please enter your name")
    val coffeeFetcher: String = readln()
    println("How many spoons of sugar you want us to add in your coffee")
    val sugarSpoons: Int = readln().toInt()
    makeCoffee(sugarSpoons, coffeeFetcher)
}

fun makeCoffee(spoons: Int, name: String) {
    var isDone = false
    while (!isDone) {
        var isExceed = false
        val isConfirmed = readln()
        when (spoons) {
            in 1..<5 -> {
                print("$name, we added $spoons ${if (spoons == 1) "spoon" else "spoons"} of sugar in your coffee\n")
                isDone = true
            }
            in 5..10 -> {
                isExceed = true
                if(isConfirmed != "yes") {
                    println("$name, Are you sure you want to add this much ? yes/no \n")
                }
            }
            0 -> {
                print("$name, your coffee is sugar free, Enjoy it")
                isDone = true
            }
        }
        if(isExceed && isConfirmed == "yes") {
            isExceed = false
            println("$name, We added $spoons of sugar in your coffee, but it's not good for your health")
            isDone = true
        } else if(!isExceed && isConfirmed !== "yes") {
            println("$name, I think something went wrong")
            isDone = true
        }
    }
}
