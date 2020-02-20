package com.example.joshuaapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.joshuaapp.data.entities.AccessTokenEntity
import com.example.joshuaapp.data.entities.UserEntity

@Dao
interface UserDao {

    /*@Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAccessToken(accessTokenEntity: AccessTokenEntity)*/

    @Query("SELECT access_token FROM user")
    fun getToken() : LiveData<String>

    @Query("SELECT id," +
            " nombre, " +
            "nombre_usuario, " +
            "apellidos, " +
            "e_mail, " +
            "curp, " +
            "nss, " +
            "num_celular, " +
            "remember_token, " +
            "id_puesto, " +
            "numero_economico, " +
            "estatus, " +
            "access_token FROM user")
    fun getUser() : LiveData<UserEntity>

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(userEntity: UserEntity)

}