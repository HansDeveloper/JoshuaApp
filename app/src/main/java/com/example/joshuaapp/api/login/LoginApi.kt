package com.example.joshuaapp.api.login

import com.example.joshuaapp.api.login.request.LoginRequest
import com.example.joshuaapp.api.login.response.LoginResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface LoginApi {

    @POST("auth")
    fun login(@Body request : LoginRequest) : Observable<LoginResponse>
}