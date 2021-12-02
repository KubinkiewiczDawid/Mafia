package com.dawidk.mafia.ui.fragment.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.dawidk.mafia.databinding.GameMenuFragmentBinding
import com.dawidk.mafia.ui.fragment.menu.state.GameMenuEvent
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameMenuFragment : Fragment() {

    private lateinit var binding: GameMenuFragmentBinding
    private val viewModel by viewModel<GameMenuViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = GameMenuFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewmodel = viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerStateListeners()
        registerEventListener()
    }

    private fun registerStateListeners() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.playersAmount.collect {
                    handleQuestionMarks(it)
                }
            }
        }
    }

    private fun registerEventListener() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect { event ->
                    when (event) {
                        is GameMenuEvent.NavigateToHowToPlayFragment -> {
                            navigateToHowToPlayFragment()
                        }
                        is GameMenuEvent.NavigateToGameGraph -> {
                            menuFadeOut()
                            imageAnimation().let {
                                it.setAnimationListener(object : Animation.AnimationListener {
                                    override fun onAnimationStart(animation: Animation) {}
                                    override fun onAnimationEnd(animation: Animation) {
                                        navigateToGameGraph(event.playersAmount)
                                    }

                                    override fun onAnimationRepeat(animation: Animation) {}
                                })
                                binding.gangsterImage.startAnimation(it)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun navigateToHowToPlayFragment() {
        findNavController().navigate(
            GameMenuFragmentDirections.actionGameMenuFragmentToHowToPlayFragment()
        )
    }

    private fun navigateToGameGraph(playersAmount: Int) {
        findNavController().navigate(
            GameMenuFragmentDirections.actionGameMenuFragmentToGameNavGraph(playersAmount)
        )
    }

    private fun handleQuestionMarks(position: Int) {
        val numberOfVisibleQuestionMarks =
            (binding.questionMarksFrame.questionMarksView as ViewGroup)
                .children
                .filter {
                    it.alpha > 0.0
                }
                .toList().size - 2
        if (position != numberOfVisibleQuestionMarks) {
            (binding.questionMarksFrame.questionMarksView as ViewGroup)
                .getChildAt(
                    if (position > numberOfVisibleQuestionMarks)
                        position - 1
                    else
                        position
                ).let {
                    it.animate()
                        .alpha(
                            if (it.alpha > 0.0) 0.0f
                            else 0.6f
                        )
                        .setDuration(300)
                        .start()
                }
        }
    }

    private fun imageAnimation(): Animation {
        return ScaleAnimation(
            1f, 1f,  // Start and end values for the X axis scaling
            1f, 2f,  // Start and end values for the Y axis scaling
            Animation.RELATIVE_TO_SELF, 0f,  // Pivot point of X scaling
            Animation.RELATIVE_TO_SELF, 1f
        ).apply {
            fillAfter = false // Needed to keep the result of the animation
            duration = 1000
        } // Pivot point of Y scaling


    }

    private fun menuFadeOut() {
        binding.apply {
            gameTitle.animate()
                .alpha(0.0f)
                .setDuration(1000)
                .start()
            gangsterImage.animate()
                .alpha(0.0f)
                .setDuration(1000)
                .start()
            gameMenuPlayerCount.animate()
                .alpha(0.0f)
                .setDuration(1000)
                .start()
            gameMenuHowToPlayButton.animate()
                .alpha(0.0f)
                .setDuration(1000)
                .start()
            gameMenuPlayButton.animate()
                .alpha(0.0f)
                .setDuration(1000)
                .start()
            questionMarks.animate()
                .alpha(0.0f)
                .setDuration(1000)
                .start()
        }
    }
}