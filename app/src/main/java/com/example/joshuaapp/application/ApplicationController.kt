package com.example.joshuaapp.application

import android.app.Application
import com.example.joshuaapp.utils.PropertiesReader
import com.example.joshuaapp.utils.rx.AppRxSchedulers
import com.example.joshuaapp.utils.rx.RxSchedulers
import timber.log.BuildConfig
import timber.log.Timber

class ApplicationController : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        initPropertiesReader()
        initializeLogger()
        initRxSchedulers()
    }

    fun initPropertiesReader(){
        propertiesReader = PropertiesReader(baseContext, "application.properties")
    }

    fun initRxSchedulers(){
        rxSchedulers = AppRxSchedulers()
    }

    private fun initializeLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(object : Timber.Tree() {
                override fun log(priority: Int, tag: String, message: String, t: Throwable?) {
                    //TODO: Logging for Firebase or Fabric
                    return
                }
            })
        }
    }
    companion object{
        lateinit var instance: ApplicationController
        lateinit var rxSchedulers: RxSchedulers
        lateinit var propertiesReader : PropertiesReader

    }
}