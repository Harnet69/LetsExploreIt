package com.harnet69.letsexploreit.features.group

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.harnet69.letsexploreit.R
import com.harnet69.letsexploreit.databinding.FragmentGroupBinding
import javax.inject.Inject

class GroupFragment @Inject constructor(
    private val groupRecyclerAdapter: GroupRecyclerAdapter
) : Fragment(R.layout.fragment_group) {
    private lateinit var viewModel: GroupViewModel
    private var _binding: FragmentGroupBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGroupBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(requireActivity()).get(GroupViewModel::class.java)

        binding.fabAddMember.setOnClickListener {
            viewModel.addNewMember()
            Snackbar.make(view, "Add a new groups member", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        _binding?.groupMembersRecyclerView?.adapter = groupRecyclerAdapter
        _binding?.groupMembersRecyclerView?.layoutManager = LinearLayoutManager(requireContext())

        observeVIewModel()
    }

    private fun observeVIewModel() {
        viewModel.isInGroup.observe(viewLifecycleOwner, {
//            binding.groupMembersRecyclerView.isVisible = it
        })

        viewModel.groupMembers.observe(viewLifecycleOwner, { newGroupMembers ->
            if (newGroupMembers.isNotEmpty()) {
                binding.groupMembersRecyclerView.isVisible
                groupRecyclerAdapter.groupMembers = newGroupMembers
            } else {

            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}