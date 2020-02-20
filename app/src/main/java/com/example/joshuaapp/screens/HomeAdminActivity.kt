package com.example.joshuaapp.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.joshuaapp.R
import com.example.joshuaapp.databinding.ActivityLoginBinding
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.joshuaapp.screens.adapters.MyAdapterEmployee
import kotlinx.android.synthetic.main.activity_home_admin.*

class HomeAdminActivity : AppCompatActivity() {

    //lateinit var binding : ActivityLoginBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter : RecyclerView.Adapter<*>
    private lateinit var  viewManager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = setContentView(this, R.layout.activity_home_admin)
        setContentView(R.layout.activity_home_admin)

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapterEmployee(fillList(), this)

        recyclerView = employee_list.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }

    private fun fillList() : ArrayList<String>{
        var employee = arrayListOf("Adriana Roblez Valadez", "Alberto Gonzalez Gardunio", "Juan Lopez Estrada", "Heriberto Perez Rosales", "Tania Sanchez Gonzalez", "Chonchuas Gonzalez", "Hans Jhonnson", "Christian Trejo Arrollo")

        return employee
    }
}
