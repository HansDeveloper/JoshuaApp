package com.example.joshuaapp.api.callback

import android.content.Context
import android.widget.Toast
import com.example.joshuaapp.api.walmart.response.SucursalesResponse
import io.reactivex.subjects.PublishSubject
import timber.log.Timber

class SucursalCallBack(val subject : PublishSubject<SucursalesResponse>,
                       val context : Context) : ApiCallBack{

    lateinit var response : Any

    override fun onSuccess(response: Any) {
        this.response = response as SucursalesResponse

        handleResponse(response)
    }

    override fun onError(e: Throwable) {
        Timber.e(e.toString())
    }

    private fun handleResponse(response : SucursalesResponse){
        if(response.codeMessage.equals(CODE_MESSAGE)){
            subject.onNext(response)
        }else{
            Toast.makeText(context, "No se puedo obtenr la informacion del WS", Toast.LENGTH_SHORT).show()
        }
    }

    companion object{
        const val CODE_MESSAGE = 0
    }
}