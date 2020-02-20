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
import com.example.joshuaapp.api.walmart.response.Sucursal
import com.example.joshuaapp.screens.DetailAdminActivity

class MySucursalAdapter(private val myDataset : ArrayList<Sucursal>, private var context : Context) : RecyclerView.Adapter<MySucursalAdapter.MyViewHolder>(){

    class MyViewHolder(view: View, context : Context, data : ArrayList<Sucursal>) : RecyclerView.ViewHolder(view), View.OnClickListener {
        var name : TextView? = null
        var phone : TextView? = null
        var zip : TextView? = null
        var horario : TextView? = null
        var context : Context
        var dataset : ArrayList<Sucursal>

        init {
            this.name = view.findViewById(R.id.sucursal_name)
            this.phone = view.findViewById(R.id.sucursal_phone)
            this.zip = view.findViewById(R.id.sucursal_zip)
            this.horario = view.findViewById(R.id.sucursal_horario)
            this.context = context
            this.dataset = data
            view.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            /*var intent = Intent(context, DetailAdminActivity::class.java)
            context.startActivity(intent)*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        val recyclerView = LayoutInflater.from(parent.context).inflate(R.layout.single_walmart_sucursales, parent, false)

        return MyViewHolder(recyclerView, context, myDataset)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.name?.text = myDataset[position].name
        holder.phone?.text = myDataset[position].telephone
        holder.zip?.text = myDataset[position].zipCode
        holder.horario?.text = myDataset[position].opens
    }


    override fun getItemCount(): Int {
        return myDataset.size
    }
}