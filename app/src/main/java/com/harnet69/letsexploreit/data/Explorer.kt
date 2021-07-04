package com.harnet69.letsexploreit.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "explorers")
data class Explorer(
    val name: String,
    val userName: String,
    val password: String,
    val profileImgUrl: String,
    @PrimaryKey(autoGenerate = true)
val id: Int? = null
)
