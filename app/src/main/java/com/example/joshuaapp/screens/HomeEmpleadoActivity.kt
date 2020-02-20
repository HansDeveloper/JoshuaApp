package com.example.joshuaapp.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.joshuaapp.R
import com.example.joshuaapp.databinding.ActivityHomeEmpleadoBinding
import androidx.databinding.DataBindingUtil.setContentView
import com.example.joshuaapp.data.repositories.UserRepository
import com.example.joshuaapp.utils.getDBInstance
import com.example.joshuaapp.viewmodels.HomeEmpleadoViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

class HomeEmpleadoActivity : AppCompatActivity() {

    lateinit var binding : ActivityHomeEmpleadoBinding
    lateinit var homeEmpleadoViewModel: HomeEmpleadoViewModel
    lateinit var subject : PublishSubject<String>
    lateinit var disposable : CompositeDisposable
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this, R.layout.activity_home_empleado)

        subject = PublishSubject.create()
        disposable = CompositeDisposable()
        disposable.add(handleSubject(subject))
        userRepository = UserRepository(getDBInstance(this).userDao())
        homeEmpleadoViewModel = HomeEmpleadoViewModel(subject, userRepository, this)

        binding.homeEmployeeUserNameText.text = "Josué Marfil"

        binding.homeEmpleadoButton.setOnClickListener {
            Toast.makeText(this, R.string.succes_check_in, Toast.LENGTH_LONG).show()
            val intent = Intent(this, HomeEmpledoUnCheckActivity::class.java)
            startActivity(intent)
        }
    }

    private fun handleSubject(subject: PublishSubject<String>) : Disposable?{
        return null
    }
}
