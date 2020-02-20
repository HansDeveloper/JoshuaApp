package com.example.joshuaapp.screens.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.joshuaapp.R
import com.example.joshuaapp.screens.DetailAdminActivity

class MyAdapterDetailEmployee(private val myDataSet : ArrayList<EmployeeDetail>,
                              private var contet : Context) : RecyclerView.Adapter<MyAdapterDetailEmployee.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var entrada : TextView? = null
        var salida : TextView? = null
        //var context : Context
        //var dataset : ArrayList<String>

        init {
            this.entrada = view.findViewById(R.id.textview_entrada)
            this.salida= view.findViewById(R.id.textview_salida)
          //  this.context = context
            //this.dataset = data
            //view.setOnClickListener(this)
        }

        /*override fun onClick(p0: View?) {
            var intent = Intent(context, DetailAdminActivity::class.java)
            context.startActivity(intent)
        }*/
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        val recyclerView = LayoutInflater.from(parent.context).inflate(R.layout.single_admin_employee_list, parent, false)

        return MyViewHolder(recyclerView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.entrada?.text = myDataSet[position].entrada
        holder.salida?.text = myDataSet[position].salida
    }

    override fun getItemCount(): Int {
        return myDataSet.size
    }
}