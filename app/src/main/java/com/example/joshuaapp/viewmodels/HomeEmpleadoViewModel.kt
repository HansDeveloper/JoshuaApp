package com.example.joshuaapp.viewmodels

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.joshuaapp.data.entities.UserEntity
import com.example.joshuaapp.data.repositories.UserRepository
import io.reactivex.subjects.PublishSubject

class HomeEmpleadoViewModel(var subject : PublishSubject<String>,
                            var userRepository: UserRepository,
                            var context: Context) {

    fun getUserName(context: Context){
        userRepository.getUser(context).observe(context as LifecycleOwner,
            object : Observer<UserEntity> {
                override fun onChanged(user: UserEntity?) {
                    subject.onNext(user?.nombre + user?.apellidos)
                }
            })
    }
}