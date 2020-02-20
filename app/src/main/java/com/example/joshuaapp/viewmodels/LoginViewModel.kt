package com.example.joshuaapp.viewmodels

import android.content.Context
import com.example.joshuaapp.api.UserClient
import com.example.joshuaapp.api.callback.LoginCallBack
import com.example.joshuaapp.api.login.request.LoginRequest
import com.example.joshuaapp.api.login.response.LoginResponse
import com.example.joshuaapp.application.ApplicationController
import com.example.joshuaapp.data.repositories.UserRepository
import com.example.joshuaapp.screens.LoginActivity

class LoginViewModel(val loginCallBack: LoginCallBack,
                     val loginActivity: LoginActivity) {

    fun loginRequest(context: Context,
                     loginRequest: LoginRequest){
        var userClient = UserClient(context, ApplicationController.propertiesReader)
        var loginApi = userClient.getLoginApi()

        loginApi.login(loginRequest)
            .subscribeOn(ApplicationController.rxSchedulers.io())
            .observeOn(ApplicationController.rxSchedulers.androidThread())
            .subscribe(
                {
                    response : LoginResponse ->

                    loginCallBack.onSuccess(response)
                },
                {
                    error : Throwable ->
                    loginCallBack.onError(error)
                }
            )
    }
}