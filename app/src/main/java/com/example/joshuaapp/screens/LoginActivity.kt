package com.example.joshuaapp.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts
import android.widget.Toast
import com.example.joshuaapp.R
import com.example.joshuaapp.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*
import androidx.databinding.DataBindingUtil.setContentView
import com.example.joshuaapp.api.callback.LoginCallBack
import com.example.joshuaapp.api.login.request.LoginRequest
import com.example.joshuaapp.api.login.response.LoginResponse
import com.example.joshuaapp.data.repositories.UserRepository
import com.example.joshuaapp.utils.getDBInstance
import com.example.joshuaapp.viewmodels.LoginViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var loginCallback : LoginCallBack
    lateinit var loginViewModel : LoginViewModel
    lateinit var subject: PublishSubject<LoginResponse>
    lateinit var disposable: CompositeDisposable
    lateinit var userRepository : UserRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this,  R.layout.activity_login)

        subject = PublishSubject.create()
        disposable = CompositeDisposable()
        disposable.add(handleSubject(subject))

        userRepository = UserRepository(getDBInstance(this).userDao())
        loginCallback = LoginCallBack(subject, userRepository, this)
        loginViewModel = LoginViewModel(loginCallback, this)

        binding.buttonLogin.setOnClickListener {
            login()
        }

        /*buttonLogin.setOnClickListener {
            val user = login_user_edit.text.toString().trim()
            val pass = login_password_edit.text.toString().trim()

            if(user.equals(ADMIN_USER) && pass.equals(ADMIN_PASS)){
                val intent = Intent(this, HomeAdminActivity::class.java)
                startActivity(intent)
            }else if(user.equals(EMPLOYEE_USER) && pass.equals(EMPLOYEE_PASS)){
                var intent = Intent(this, HomeEmpleadoActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Usuario o contraseña invalidos", Toast.LENGTH_SHORT).show()
            }
        }*/
    }

    private fun login(){
        var user = binding.loginUserEdit.text.trim().toString()
        var pass = binding.loginPasswordEdit.text.trim().toString()

        var loginRequest = generateLoginRequest(user, pass)

        loginViewModel.loginRequest(this, loginRequest)
    }

    private fun generateLoginRequest( user : String, pass : String) : LoginRequest{
        return LoginRequest(user, pass)
    }

    private fun handleSubject(subject : PublishSubject<LoginResponse>) : Disposable{
        return subject.subscribe {t ->
            if(t.data.user.id_Puesto.equals("3") && t.data.user.estatus.equals("Activo")){
                val intent = Intent(this, HomeAdminActivity::class.java)
                startActivity(intent)
            }else if (!(t.data.user.id_Puesto.equals("3")) && (t.data.user.estatus.equals("Activo"))){
                val intent = Intent(this, HomeEmpleadoActivity::class.java)
                startActivity(intent)
            }
        }
    }

    companion object{
        const val ADMIN_PASS = "admin123"
        const val EMPLOYEE_PASS = "emp123"
        const val ADMIN_USER = "admin"
        const val EMPLOYEE_USER = "user"
    }
}
