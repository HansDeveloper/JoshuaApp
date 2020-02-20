package com.example.joshuaapp.data.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.joshuaapp.data.dao.UserDao
import com.example.joshuaapp.data.entities.AccessTokenEntity
import com.example.joshuaapp.data.entities.UserEntity
import com.example.joshuaapp.utils.getDBInstance

class UserRepository constructor(private val userDao : UserDao) {

    /*fun insertAccessToken(accessTokenEntity: AccessTokenEntity, context : Context){
        getDBInstance(context).userDao().insertAccessToken(accessTokenEntity)
    }*/

    fun insertUser(userEntity: UserEntity,
                   context: Context){
        getDBInstance(context).userDao().insertUser(userEntity)
    }

    fun getToken(context: Context) : LiveData<String>{
        return getDBInstance(context).userDao().getToken()
    }

    fun getUser(context: Context) : LiveData<UserEntity>{
        return getDBInstance(context).userDao().getUser()
    }
}