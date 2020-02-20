package com.example.joshuaapp.api.callback

interface ApiCallBack {

    fun onSuccess(response : Any)

    fun onError(e : Throwable)
}