package com.dawidk.mafia.ui.fragment.howtoplay

import android.content.Context
import com.dawidk.mafia.R
import com.dawidk.mafia.model.HowToPlayItem

class HowToPlayItemsProvider(context: Context) {

    private val resources = context.resources

    val howToPlayItems = listOf(
        HowToPlayItem(
            resources.getString(R.string.game_introduction_title),
            resources.getString(R.string.game_introduction_description),
            R.drawable.game_title
        ),
        HowToPlayItem(
            resources.getString(R.string.game_prepare_instruction_title),
            resources.getString(R.string.game_prepare_instruction_description),
            R.drawable.phone_image
        ),
        HowToPlayItem(
            resources.getString(R.string.roles_instruction_title),
            resources.getString(R.string.roles_instruction_description),
            R.drawable.question_mark
        ),
        HowToPlayItem(
            resources.getString(R.string.mafiosi_role_instruction_title),
            resources.getString(R.string.mafiosi_role_instruction_description),
            R.drawable.gangster_aiming
        ),
        HowToPlayItem(
            resources.getString(R.string.police_role_instruction_title),
            resources.getString(R.string.police_role_instruction_description),
            R.drawable.police_officer
        ),
        HowToPlayItem(
            resources.getString(R.string.citizens_role_instruction_title),
            resources.getString(R.string.citizens_role_instruction_description),
            R.drawable.citizen
        ),
        HowToPlayItem(
            resources.getString(R.string.game_beginning_instruction_title),
            resources.getString(R.string.game_beginning_instruction_description),
            R.drawable.menu_screen
        ),
        HowToPlayItem(
            resources.getString(R.string.game_drawing_roles_instruction_title),
            resources.getString(R.string.game_drawing_roles_instruction_description),
            R.drawable.assign_card_front
        ),
        HowToPlayItem(
            resources.getString(R.string.game_hiding_roles_instruction_title),
            resources.getString(R.string.game_hiding_roles_instruction_description),
            R.drawable.assign_card_back
        ),
        HowToPlayItem(
            resources.getString(R.string.game_flow_instruction_title),
            resources.getString(R.string.game_flow_1_instruction_description),
            R.drawable.mafia_sleeps
        ),
        HowToPlayItem(
            resources.getString(R.string.game_flow_instruction_title),
            resources.getString(R.string.game_flow_2_instruction_description),
            R.drawable.mafia_sleeps
        ),
        HowToPlayItem(
            resources.getString(R.string.night_phase_instruction_title),
            resources.getString(R.string.night_phase_instruction_description),
            R.drawable.city_sleeps
        ),
        HowToPlayItem(
            resources.getString(R.string.game_mafia_turn_instruction_title),
            resources.getString(R.string.game_mafia_turn_instruction_description),
            R.drawable.mafia_screen
        ),
        HowToPlayItem(
            resources.getString(R.string.game_police_turn_instruction_title),
            resources.getString(R.string.game_police_turn_instruction_description),
            R.drawable.police_screen
        ),
        HowToPlayItem(
            resources.getString(R.string.day_phase_instruction_title),
            resources.getString(R.string.day_phase_instruction_description),
            R.drawable.killed_screen
        ),
        HowToPlayItem(
            resources.getString(R.string.talk_time_instruction_title),
            resources.getString(R.string.talk_time_instruction_description),
            R.drawable.talk_screen
        ),
        HowToPlayItem(
            resources.getString(R.string.vote_instruction_title),
            resources.getString(R.string.vote_instruction_1_description),
            R.drawable.vote_card_front
        ),
        HowToPlayItem(
            resources.getString(R.string.vote_instruction_title),
            resources.getString(R.string.vote_instruction_2_description),
            R.drawable.vote_card_back
        ),
        HowToPlayItem(
            resources.getString(R.string.vote_summary_instruction_title),
            resources.getString(R.string.vote_summary_instruction_description),
            R.drawable.vote_summary
        ),
        HowToPlayItem(
            resources.getString(R.string.instruction_summary_title),
            resources.getString(R.string.instruction_summary_description),
            R.drawable.menu_screen
        )
    )
}