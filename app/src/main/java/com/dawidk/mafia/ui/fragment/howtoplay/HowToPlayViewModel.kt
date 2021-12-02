package com.dawidk.mafia.ui.fragment.howtoplay

import androidx.lifecycle.ViewModel
import com.dawidk.mafia.ui.fragment.howtoplay.state.HowToPlayEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class HowToPlayViewModel : ViewModel() {

    private val _event: MutableSharedFlow<HowToPlayEvent> =
        MutableSharedFlow(extraBufferCapacity = 1)
    val event: SharedFlow<HowToPlayEvent> = _event

    fun navigateBack() {
        _event.tryEmit(HowToPlayEvent.NavigateBack)
    }
}