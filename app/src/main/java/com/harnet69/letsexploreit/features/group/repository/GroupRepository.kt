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
                "https://visualpharm.com/assets/30/User-595b40b85ba036ed117da56f.svg",
                1
            )
        )
        fakeMembers.add(
            GroupMember(
                "Member 2",
                "member2",
                "12345",
                "https://visualpharm.com/assets/622/Contact%20Info-595b40b65ba036ed117d36d5.svg",
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