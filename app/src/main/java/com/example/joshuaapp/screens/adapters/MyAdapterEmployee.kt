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
import kotlinx.android.synthetic.main.single_admin_list.view.*
import org.w3c.dom.Text

class MyAdapterEmployee(private val myDataset : ArrayList<String>, private var context : Context) : RecyclerView.Adapter<MyAdapterEmployee.MyViewHolder>(){

    class MyViewHolder(view: View, context : Context, data : ArrayList<String>) : RecyclerView.ViewHolder(view), View.OnClickListener {
        var text : TextView? = null
        var imageEmp : ImageView? = null
        var context : Context
        var dataset : ArrayList<String>

        init {
            this.text = view.findViewById(R.id.text_admin_employee)
            this.imageEmp = view.findViewById(R.id.image_list_emp)
            this.context = context
            this.dataset = data
            view.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            var intent = Intent(context, DetailAdminActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        val recyclerView = LayoutInflater.from(parent.context).inflate(R.layout.single_admin_list, parent, false)

        return MyViewHolder(recyclerView, context, myDataset)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.text?.text = myDataset[position]
        holder.imageEmp?.setImageResource(R.drawable.ic_usersvg)
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }
}