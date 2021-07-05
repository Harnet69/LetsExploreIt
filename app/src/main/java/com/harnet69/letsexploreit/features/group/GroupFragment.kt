package com.harnet69.letsexploreit.features.group

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.harnet69.letsexploreit.R
import com.harnet69.letsexploreit.databinding.FragmentGroupBinding
import javax.inject.Inject

class GroupFragment @Inject constructor(
    val groupRecyclerAdapter: GroupRecyclerAdapter
) : Fragment(R.layout.fragment_group) {
    private lateinit var groupViewModel: GroupViewModel
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
        groupViewModel = ViewModelProvider(requireActivity()).get(GroupViewModel::class.java)

        binding.fabAddMember.setOnClickListener {
            groupViewModel.addNewMember()
            Snackbar.make(view, "Add a new groups member", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        _binding?.groupMembersRecyclerView?.adapter = groupRecyclerAdapter
        _binding?.groupMembersRecyclerView?.layoutManager = LinearLayoutManager(requireContext())

        observeVIewModel()
    }

    private fun observeVIewModel(){
        groupViewModel.groupMembers.observe(viewLifecycleOwner, { newGroupMembers ->
            groupRecyclerAdapter.groupMembers = newGroupMembers
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}