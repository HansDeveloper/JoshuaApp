package com.example.joshuaapp.api.walmart

import com.example.joshuaapp.api.walmart.response.SucursalesResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface WalmartApi {

    @GET("walmart-services/mg/address/storeLocatorCoordinates")
    fun getSucursales() : Observable<SucursalesResponse>
}