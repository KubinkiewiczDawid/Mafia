package com.dawidk.mafia.ui.fragment.game.assignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.dawidk.mafia.databinding.RolesAssignmentFragmentBinding
import com.dawidk.mafia.ui.fragment.game.GameSharedViewModel
import com.dawidk.mafia.utils.hideKeyboardOnAction
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs: RolesAssignmentFragmentArgs by navArgs()

        binding.cardFrontAssignmentFrame.assignLayoutFrame.playerNameEditText.hideKeyboardOnAction(
            requireContext(),
            EditorInfo.IME_ACTION_DONE
        )
        viewModel.initialize(safeArgs.playersAmount)
    }
}