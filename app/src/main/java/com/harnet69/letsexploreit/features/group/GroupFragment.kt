package com.harnet69.letsexploreit.features.group

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.harnet69.letsexploreit.databinding.FragmentGroupBinding
import javax.inject.Inject

class GroupFragment @Inject constructor() : Fragment() {

    private val groupViewModel: GroupViewModel by viewModels()
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
            binding.fabAddMember.setOnClickListener {
                groupViewModel.addNewMember()
                Snackbar.make(view, "Add a new groups member", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}