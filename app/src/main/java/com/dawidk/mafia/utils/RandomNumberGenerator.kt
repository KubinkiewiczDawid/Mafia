package com.dawidk.mafia.utils

import java.util.*
import kotlin.collections.ArrayList

fun generateRandomNumbers(numbersInterval: Int, numbersAmount: Int): List<Int> {
    val numbers = ArrayList<Int>()
    val randomGenerator = Random()
    while (numbers.size < numbersAmount) {
        val random = randomGenerator.nextInt(numbersInterval)
        if (!numbers.contains(random)) {
            numbers.add(random)
        }
    }
    return numbers
}