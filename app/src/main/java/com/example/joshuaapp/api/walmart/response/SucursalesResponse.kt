package com.example.joshuaapp.api.walmart.response

data class SucursalesResponse(var codeMessage : Int,
                              var message : String,
                              var responseArray : ArrayList<Sucursal>) {
}