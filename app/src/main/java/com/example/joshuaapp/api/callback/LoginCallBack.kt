package com.example.joshuaapp.api.callback

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.joshuaapp.R
import com.example.joshuaapp.api.login.response.LoginResponse
import com.example.joshuaapp.data.entities.AccessTokenEntity
import com.example.joshuaapp.data.entities.UserEntity
import com.example.joshuaapp.data.repositories.UserRepository
import com.example.joshuaapp.screens.HomeAdminActivity
import com.example.joshuaapp.screens.LoginActivity
import io.reactivex.subjects.PublishSubject
import timber.log.Timber

class LoginCallBack(val subject: PublishSubject<LoginResponse>,
                    val userRepository: UserRepository,
                    val context: Context) : ApiCallBack{

    private lateinit var response: Any

    override fun onSuccess(response: Any) {
        this.response = response as LoginResponse

        handleResponse(response)
    }

    override fun onError(e: Throwable) {
        Timber.e(e.toString())
    }

    private fun handleResponse(response : LoginResponse){
        if(response.message.equals("token_generated")){
            var user = fillUserEntity(response)
            Thread(kotlinx.coroutines.Runnable {
                insertUser(user)
            }).start()
            subject.onNext(response)
        }
    }

    private fun insertUser(user : UserEntity){
        Log.d("COUROUTINE", "Entro a la corrutina")
        userRepository.insertUser(user, context)
    }

    private fun fillUserEntity(response : LoginResponse) : UserEntity{
        return UserEntity(nombre = response.data.user.nombre,
            apellidos = response.data.user.apellidos,
            nombreUsuario = response.data.user.nombre_Usuario,
            email = response.data.user.e_mail,
            curp = response.data.user.curp,
            nss = response.data.user.NSS,
            numCelular = response.data.user.num_celular,
            rememeberToken = response.data.user.remember_token,
            idPuesto = response.data.user.id_Puesto,
            numeroEconomico = response.data.user.numero_economico,
            estatus = response.data.user.estatus,
            accessToken = response.data.token,
            userId = 1)
    }

    /*private fun insertToken(token : AccessTokenEntity){
        userRepository.insertAccessToken(token, context)
    }*/

    private fun fillAccessTokenEntity(response : LoginResponse) : AccessTokenEntity{
        return AccessTokenEntity("1", response.data.token)
    }
}