package com.dawidk.mafia.model

data class Player(
    var name: String,
    var role: Role,
    val isAlive: Boolean
) {

    companion object {

        val EMPTY = Player("", Role.Citizen, true)
    }
}
