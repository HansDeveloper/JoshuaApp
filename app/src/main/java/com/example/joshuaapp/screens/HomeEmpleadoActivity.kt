package com.example.joshuaapp.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.joshuaapp.R
import com.example.joshuaapp.databinding.ActivityHomeEmpleadoBinding
import androidx.databinding.DataBindingUtil.setContentView

class HomeEmpleadoActivity : AppCompatActivity() {

    lateinit var binding : ActivityHomeEmpleadoBinding
    lateinit var

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this, R.layout.activity_home_empleado)

        binding.homeEmployeeUserNameText.text = "Josué Marfil"

        binding.homeEmpleadoButton.setOnClickListener {
            Toast.makeText(this, R.string.succes_check_in, Toast.LENGTH_LONG).show()
            val intent = Intent(this, HomeEmpledoUnCheckActivity::class.java)
            startActivity(intent)
        }
    }

}
