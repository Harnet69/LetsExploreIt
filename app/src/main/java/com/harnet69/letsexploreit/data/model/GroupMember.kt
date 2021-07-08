package com.harnet69.letsexploreit.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "members")
data class GroupMember(
    val name: String,
    val userName: String,
    val password: String,
    val profileImgUrl: String,
    @PrimaryKey(autoGenerate = true)
val id: Int? = null
)
