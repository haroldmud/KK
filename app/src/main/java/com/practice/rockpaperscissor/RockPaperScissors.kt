package com.practice.rockpaperscissor


fun main() {
   myparentloop@ for(i in 10 downTo  -5 step 2) {
       println("$i: loop me")
       for( i in 1..3) {
           println("***ok")
           if(i == 2) {
               break@myparentloop
           }
       }
   }
}
