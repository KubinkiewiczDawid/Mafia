package com.dawidk.mafia.ui.fragment.game.assignment

import androidx.lifecycle.ViewModel
import com.dawidk.mafia.model.Player
import com.dawidk.mafia.model.Role
import com.dawidk.mafia.ui.fragment.game.assignment.state.RolesAssignmentEvent
import com.dawidk.mafia.utils.generateRandomNumbers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

class RolesAssignmentViewModel : ViewModel() {

    private val playersList: MutableList<Player> = mutableListOf()
    private var playersAmount = 0
    private var numberOfMafia = 0
    private var numberOfPolice = 0
    private var playerIndex = 0;
    private val _playerName = MutableStateFlow("")
    val playerName: StateFlow<String> = _playerName
    private val _event: MutableSharedFlow<RolesAssignmentEvent> =
        MutableSharedFlow(extraBufferCapacity = 1)
    val event: SharedFlow<RolesAssignmentEvent> = _event

    fun initialize(playersAmount: Int) {
        this.playersAmount = playersAmount
        setRolesCount()
        setPlayersRoles()
    }

    private fun setRolesCount() {
        when (playersAmount) {
            6, 7 -> {
                numberOfMafia = 1
                numberOfPolice = 1
            }
            8, 9, 10 -> {
                numberOfMafia = 2
                numberOfPolice = 1
            }
            11, 12, 13 -> {
                numberOfMafia = 2
                numberOfPolice = 2
            }
        }
    }

    private fun setPlayersRoles() {
        repeat(playersAmount) {
            playersList.add(Player.EMPTY.copy())
        }
        generateRandomNumbers(
            numbersInterval = playersAmount,
            numbersAmount = numberOfMafia + numberOfPolice
        ).map {
            if (numberOfMafia > 0) {
                playersList[it].role = Role.Mafia
                numberOfMafia--
            } else {
                playersList[it].role = Role.Police
                numberOfPolice--
            }
        }
    }

    fun afterPlayerNameChange(s: CharSequence) {
        this._playerName.value = s.toString()
    }

    fun savePlayerName() {
        playersList[playerIndex].name = _playerName.value
        playerIndex++
        _playerName.value = ""
        _event.tryEmit(RolesAssignmentEvent.ShowPlayerRole)
    }
}