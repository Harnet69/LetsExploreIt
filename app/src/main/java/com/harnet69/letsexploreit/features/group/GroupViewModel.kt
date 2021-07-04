package com.harnet69.letsexploreit.features.group

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harnet69.letsexploreit.features.group.repository.IGroupRepository

class GroupViewModel @ViewModelInject constructor(
    // in tests we fake this repository
    //TODO here is the problem with injection!!!
    private val repository: IGroupRepository
) : ViewModel() {
    val groupMembers = repository.getAllGroupMembers()

    fun addNewMember() {
        Log.i("groupModelView", "addNewMember: ")
    }
}