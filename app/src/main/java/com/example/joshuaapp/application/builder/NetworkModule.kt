package com.example.joshuaapp.application.builder

import android.content.Context
import com.example.joshuaapp.utils.rx.AppRxSchedulers
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

class NetworkModule private constructor(){
    companion object{
        const val TIMEOUT : Long = 90

        fun provideRetrofitClient(context : Context, baseUrl : String) : Retrofit{
            val gson = GsonBuilder().create()
            return Retrofit.Builder()
                .client(provideHttpClient(context))
                .baseUrl(baseUrl)
                .addConverterFactory(provideGsonConverter())
                .addCallAdapterFactory(provideRxAdapter())
                .build()
        }

        private fun provideHttpClient(context : Context) : OkHttpClient{
            val interceptor = provideInterceptor()
            val cache = provideCache(provideCacheFile(context))

            return OkHttpClient().newBuilder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .cache(cache)
                .build()
        }

        private fun provideInterceptor() : HttpLoggingInterceptor{
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return httpLoggingInterceptor
        }

        private fun provideCache(file : File) : Cache{
            return Cache(file, (10 * 10 * 1000).toLong())
        }

        private fun provideCacheFile(context: Context) : File{
            return context.filesDir
        }

       private fun provideRxAdapter() : RxJava2CallAdapterFactory{
            return RxJava2CallAdapterFactory.createWithScheduler(AppRxSchedulers.INTERNET_SCHEDULERS)
        }

        private fun provideGsonConverter() : GsonConverterFactory{
            return GsonConverterFactory.create()
        }
    }
}