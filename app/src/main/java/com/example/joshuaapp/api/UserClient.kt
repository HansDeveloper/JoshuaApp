package com.example.joshuaapp.api

import android.content.Context
import com.example.joshuaapp.api.login.LoginApi
import com.example.joshuaapp.api.walmart.WalmartApi
import com.example.joshuaapp.application.builder.NetworkModule
import com.example.joshuaapp.utils.PropertiesReader

class UserClient constructor(val context: Context, val propertiesReader: PropertiesReader) {

    fun getLoginApi() : LoginApi {
        val baseUrl = propertiesReader.getBaseUrl()
        return NetworkModule.provideRetrofitClient(context, baseUrl).create(LoginApi::class.java)
    }

    fun getWalmartApi() : WalmartApi{
        val baseUrl = propertiesReader.getBaseUrl()
        return NetworkModule.provideRetrofitClient(context, baseUrl).create(WalmartApi::class.java)
    }

}