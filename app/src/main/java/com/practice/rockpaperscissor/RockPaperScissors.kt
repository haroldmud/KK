package com.practice.rockpaperscissor


fun main() {
   val sum = handleSum("bozhe bomogi mne")
    print(sum)
}

fun handleSum(txt: String?): Int {
    val text = txt
    return text!!.length
}
