package com.dawidk.mafia.ui.fragment.menu.state

sealed class GameMenuEvent {
    object NavigateToHowToPlayFragment : GameMenuEvent()
    data class NavigateToGameGraph(val playersAmount: Int) : GameMenuEvent()
}