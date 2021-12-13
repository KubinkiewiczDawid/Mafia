package com.dawidk.mafia.model

sealed class Role {
    object Citizen : Role()
    object Police : Role()
    object Mafia : Role()
}
