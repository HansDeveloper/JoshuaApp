package com.example.joshuaapp.viewmodels

import android.content.Context
import com.example.joshuaapp.api.UserClient
import com.example.joshuaapp.api.callback.LoginCallBack
import com.example.joshuaapp.api.callback.SucursalCallBack
import com.example.joshuaapp.api.walmart.response.SucursalesResponse
import com.example.joshuaapp.application.ApplicationController
import com.example.joshuaapp.screens.walmart.SucursalesActivity

class SucursalViewModel(val sucursalCallBack: SucursalCallBack,
                        val sucursalesActivity: SucursalesActivity) {

    fun getSucursalRequest(context : Context){

        var userClient = UserClient(context, ApplicationController.propertiesReader)
        var walmartApi = userClient.getWalmartApi()

        walmartApi.getSucursales()
            .subscribeOn(ApplicationController.rxSchedulers.io())
            .observeOn(ApplicationController.rxSchedulers.androidThread()).
                subscribe(
                    {
                        response : SucursalesResponse -> sucursalCallBack.onSuccess(response)
                    },
                    {
                        error : Throwable -> sucursalCallBack.onError(error)
                    }
                )
    }
}