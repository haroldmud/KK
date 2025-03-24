package com.practice.rockpaperscissor

fun main() {

    println("rock, paper, scissor ??? Enter your choice \uD83D\uDE0A \n")
    var playerChoice = readln()
    val randomNumber = (1..3).random()
    var computerChoice = ""
    if (randomNumber == 1) {
        computerChoice = "rock"
    } else if (randomNumber == 2) {
        computerChoice = "paper"
    } else {
        computerChoice = "scissor"
    }

    when {
        (playerChoice == computerChoice) -> print("DRAW!!!!!...TRY AGAIN")
        (playerChoice == "rock" && computerChoice == "paper") -> print("You lost \uD83D\uDE14")
        (playerChoice == "paper" && computerChoice == "rock") -> print("you winn \uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89!!!")
        (playerChoice == "paper" && computerChoice == "scissor") -> print("You lost \uD83D\uDE14")

    }
}
