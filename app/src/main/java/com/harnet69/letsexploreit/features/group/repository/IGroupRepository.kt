package com.harnet69.letsexploreit.features.group.repository

interface IGroupRepository {
    fun createNewGroup()
    fun deleteGroup()

    fun getAllGroupMembers()
    fun addNewGroupMember()
    fun deleteGroupMember()
}