package com.example.joshuaapp.fragments

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.joshuaapp.R
import com.example.joshuaapp.screens.adapters.EmployeeDetail
import com.example.joshuaapp.screens.adapters.MyAdapterDetailEmployee
import kotlinx.android.synthetic.main.fragment_employee.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [EmployeeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [EmployeeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EmployeeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter : RecyclerView.Adapter<*>
    private lateinit var  viewManager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewManager = LinearLayoutManager(activity)
        viewAdapter = MyAdapterDetailEmployee(fillList(), activity as Activity)

        recyclerView = employee_detail_list.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun fillList() : ArrayList<EmployeeDetail>{
        var dataSet = java.util.ArrayList<EmployeeDetail>()
        var dates : EmployeeDetail
        dates = EmployeeDetail("01/02/2020 - 08:30:34", "01/02/2020 - 04:30:34")
        dataSet.add(dates)
        dates = EmployeeDetail("02/02/2020 - 08:30:34", "02/02/2020 - 04:30:34")
        dataSet.add(dates)
        dates = EmployeeDetail("03/02/2020 - 08:30:34", "03/02/2020 - 04:30:34")
        dataSet.add(dates)
        dates = EmployeeDetail("04/02/2020 - 08:30:34", "04/02/2020 - 04:30:34")
        dataSet.add(dates)
        dates = EmployeeDetail("05/02/2020 - 08:30:34", "05/02/2020 - 04:30:34")
        dataSet.add(dates)
        dates = EmployeeDetail("06/02/2020 - 08:30:34", "06/02/2020 - 04:30:34")
        dataSet.add(dates)
        dates = EmployeeDetail("07/02/2020 - 08:30:34", "07/02/2020 - 04:30:34")
        dataSet.add(dates)

        return dataSet
    }

}
