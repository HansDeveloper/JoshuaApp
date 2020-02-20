package com.example.joshuaapp.api.login.response

data class User(var id_Usuario : Int,
                var nombre : String,
                var apellidos : String,
                var nombre_Usuario : String,
                var e_mail : String,
                var curp : String,
                var NSS : String,
                var num_celular : String,
                var remember_token : String,
                var id_Puesto : String,
                var numero_economico : String,
                var estatus : String) {
}