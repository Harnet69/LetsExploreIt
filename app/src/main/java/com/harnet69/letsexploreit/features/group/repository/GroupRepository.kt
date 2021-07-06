package com.harnet69.letsexploreit.features.group.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.harnet69.letsexploreit.data.model.GroupMember

class GroupRepository : IGroupRepository {
    override fun createNewGroup() {
        TODO("Not yet implemented")
    }

    override fun deleteGroup() {
        TODO("Not yet implemented")
    }

    override fun getAllGroupMembers(): LiveData<List<GroupMember>> {
        val fakeMembers = ArrayList<GroupMember>()
        fakeMembers.add(
            GroupMember(
                "Member 1",
                "member1",
                "12345",
                "https://www.clipartmax.com/png/middle/296-2969961_no-image-user-profile-icon.png",
                1
            )
        )
        fakeMembers.add(
            GroupMember(
                "Member 2",
                "member2",
                "12345",
                "https://www.clipartmax.com/png/middle/162-1623921_stewardess-510x510-user-profile-icon-png.png",
                2
            )
        )
        val fakeMembersLiveData = MutableLiveData<List<GroupMember>>(fakeMembers)
        return fakeMembersLiveData
    }

    override fun addNewGroupMember() {
        TODO("Not yet implemented")
    }

    override fun deleteGroupMember() {
        TODO("Not yet implemented")
    }
}