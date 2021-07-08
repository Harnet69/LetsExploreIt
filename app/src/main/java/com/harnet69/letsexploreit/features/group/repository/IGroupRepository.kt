package com.harnet69.letsexploreit.features.group.repository

import androidx.lifecycle.LiveData
import com.harnet69.letsexploreit.data.model.GroupMember

interface IGroupRepository {
    fun isInGroup(): LiveData<Boolean>
    fun createNewGroup()
    fun deleteGroup()

    fun getAllGroupMembers(): LiveData<List<GroupMember>>
    fun addNewGroupMember()
    fun deleteGroupMember()
}