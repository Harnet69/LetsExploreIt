package com.harnet69.letsexploreit.features.group

import android.util.Log
import androidx.lifecycle.ViewModel
import com.harnet69.letsexploreit.features.group.repository.IGroupRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GroupViewModel @Inject constructor(
    // in tests we fake this repository
    //TODO here is the problem with injection!!!
    private val repository: IGroupRepository
) : ViewModel() {
    val groupMembers = repository.getAllGroupMembers()

    fun addNewMember() {
        Log.i("groupModelView", "addNewMember: ")
    }
}