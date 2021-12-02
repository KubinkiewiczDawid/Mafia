package com.dawidk.mafia.ui.fragment.game.assignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dawidk.mafia.databinding.RolesAssignmentFragmentBinding
import com.dawidk.mafia.ui.fragment.game.GameSharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RolesAssignmentFragment : Fragment() {

    private val sharedViewModel by sharedViewModel<GameSharedViewModel>()
    private lateinit var binding: RolesAssignmentFragmentBinding
    private val viewModel by viewModel<RolesAssignmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RolesAssignmentFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewmodel = viewModel
        }
        return binding.root
    }
}