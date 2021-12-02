package com.dawidk.mafia.ui.fragment.menu

import androidx.lifecycle.ViewModel
import com.dawidk.mafia.ui.fragment.menu.state.GameMenuEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

const val DEFAULT_PLAYERS_AMOUNT = 6
const val MIN_PLAYERS_AMOUNT = 6
const val MAX_PLAYERS_AMOUNT = 12

class GameMenuViewModel : ViewModel() {

    private val _playersAmount = MutableStateFlow(DEFAULT_PLAYERS_AMOUNT)
    val playersAmount: StateFlow<Int> = _playersAmount
    private val _event: MutableSharedFlow<GameMenuEvent> =
        MutableSharedFlow(extraBufferCapacity = 1)
    val event: SharedFlow<GameMenuEvent> = _event

    fun increasePlayersAmount() {
        if (_playersAmount.value < MAX_PLAYERS_AMOUNT)
            _playersAmount.value = _playersAmount.value.plus(1)
    }

    fun decreasePlayersAmount() {
        if (_playersAmount.value > MIN_PLAYERS_AMOUNT)
            _playersAmount.value = _playersAmount.value.minus(1)
    }

    fun navigateToHowToPlayFragment() {
        _event.tryEmit(GameMenuEvent.NavigateToHowToPlayFragment)
    }

    fun navigateToGameGraph() {
        _event.tryEmit(GameMenuEvent.NavigateToGameGraph(_playersAmount.value))
    }
}