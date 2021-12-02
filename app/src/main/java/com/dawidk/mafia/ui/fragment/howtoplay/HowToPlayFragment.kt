package com.dawidk.mafia.ui.fragment.howtoplay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.dawidk.mafia.databinding.HowToPlayFragmentBinding
import com.dawidk.mafia.ui.fragment.howtoplay.state.HowToPlayEvent
import com.dawidk.mafia.utils.setUpInfinityScroll
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HowToPlayFragment : Fragment() {

    private lateinit var binding: HowToPlayFragmentBinding
    private val viewModel by viewModel<HowToPlayViewModel>()
    private lateinit var howToPlayItemsProvider: HowToPlayItemsProvider
    private var carouselAdapter: CarouselAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HowToPlayFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewmodel = viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        howToPlayItemsProvider = HowToPlayItemsProvider(requireContext())

        carouselAdapter = CarouselAdapter()
        binding.viewpager.apply {
            carouselAdapter?.let {
                adapter = it
                setUpInfinityScroll { it.getOriginalItemCount() }
            }
        }
        carouselAdapter?.submitList(howToPlayItemsProvider.howToPlayItems)
        binding.viewpager.offscreenPageLimit = howToPlayItemsProvider.howToPlayItems.size

        registerEventListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        carouselAdapter = null
    }

    private fun registerEventListener() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect { event ->
                    when (event) {
                        is HowToPlayEvent.NavigateBack -> navigateBack()
                    }
                }
            }
        }
    }

    private fun navigateBack() {
        findNavController().popBackStack()
    }
}