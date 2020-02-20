package com.example.joshuaapp.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.joshuaapp.R
import com.example.joshuaapp.databinding.ActivityHomeEmpledoUnCheckBinding
import androidx.databinding.DataBindingUtil.setContentView

class HomeEmpledoUnCheckActivity : AppCompatActivity() {

    lateinit var binding : ActivityHomeEmpledoUnCheckBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this, R.layout.activity_home_empledo_un_check)

        binding.homeEmpleadoUncheckButton.setOnClickListener {
            val intent = Intent(this, HomeEmpleadoActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, R.string.succes_uncheck_in, Toast.LENGTH_LONG).show()
        }
    }
}
