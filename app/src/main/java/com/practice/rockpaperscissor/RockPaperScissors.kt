package com.practice.rockpaperscissor

fun main() {

    println("rock, paper, scissor ??? Enter your choice \uD83D\uDE0A \n")
    var playerChoice = readln()
    val randomNumber = (1..3).random()
    var computerChoice = ""
    computerChoice = when (randomNumber) {
        1 -> "rock"
        2 -> "paper"
        else -> "scissor"
    }
    print("computer chooses: $computerChoice \n\n")
    when {
        (playerChoice == computerChoice) -> {
            print("DRAW!!!!!...TRY AGAIN, enter your choice");
            playerChoice =  readln()
        }
        (playerChoice == "rock" && computerChoice == "paper") -> print("You lost \uD83D\uDE14")
        (playerChoice == "paper" && computerChoice == "rock") -> print("you winn \uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89!!!")
        (playerChoice == "paper" && computerChoice == "scissor") -> print("You lost \uD83D\uDE14")
        (playerChoice == "rock" && computerChoice == "scissor") -> print("YOU ARE THE WINNER \uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89!!!")
        (playerChoice == "scissor" && computerChoice == "rock") -> print("You lost \uD83D\uDE14")
        (playerChoice == "scissor" && computerChoice == "paper") -> print("YOU ARE THE WINNER \uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89!!!")
        else -> print("what was that...come on try again")
    }
}
