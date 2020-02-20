package com.example.joshuaapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "id")
    val userId : Int,
    @ColumnInfo(name = "nombre")
    val nombre : String,
    @ColumnInfo(name = "apellidos")
    val apellidos : String,
    @ColumnInfo(name = "nombre_usuario")
    val nombreUsuario : String,
    @ColumnInfo(name = "e_mail")
    val email : String,
    @ColumnInfo(name = "curp")
    val curp : String,
    @ColumnInfo(name = "nss")
    val nss : String,
    @ColumnInfo(name = "num_celular")
    val numCelular : String,
    @ColumnInfo(name = "remember_token")
    val rememeberToken : String,
    @ColumnInfo(name = "id_puesto")
    val idPuesto : String,
    @ColumnInfo(name = "numero_economico")
    val numeroEconomico : String? = null,
    @ColumnInfo(name = "estatus")
    val estatus : String,
    @ColumnInfo(name = "access_token")
    val accessToken : String
) {
}