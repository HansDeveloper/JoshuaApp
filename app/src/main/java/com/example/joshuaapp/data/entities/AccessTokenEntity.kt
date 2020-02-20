package com.example.joshuaapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "accessToken")
data class AccessTokenEntity(@PrimaryKey
                       @NotNull
                       @ColumnInfo(name = "id")
                       val tokenId : String,
                             @ColumnInfo(name = "access_token")
                       val accessToken: String
)