package com.dawidk.mafia.di

import com.dawidk.mafia.ui.fragment.game.GameSharedViewModel
import com.dawidk.mafia.ui.fragment.game.assignment.RolesAssignmentViewModel
import com.dawidk.mafia.ui.fragment.howtoplay.HowToPlayViewModel
import com.dawidk.mafia.ui.fragment.menu.GameMenuViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { GameMenuViewModel() }
    viewModel { HowToPlayViewModel() }
    viewModel { GameSharedViewModel() }
    viewModel { RolesAssignmentViewModel() }
}
