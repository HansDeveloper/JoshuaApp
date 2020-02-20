package com.example.joshuaapp.screens.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.joshuaapp.R
import com.example.joshuaapp.databinding.ActivitySucursalesBinding
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.joshuaapp.api.callback.LoginCallBack
import com.example.joshuaapp.api.callback.SucursalCallBack
import com.example.joshuaapp.api.walmart.response.SucursalesResponse
import com.example.joshuaapp.screens.adapters.MyAdapterEmployee
import com.example.joshuaapp.screens.adapters.MySucursalAdapter
import com.example.joshuaapp.viewmodels.LoginViewModel
import com.example.joshuaapp.viewmodels.SucursalViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_home_admin.*

class SucursalesActivity : AppCompatActivity() {

    lateinit var binding : ActivitySucursalesBinding
    lateinit var sucursalCallBack: SucursalCallBack
    lateinit var sucursalViewModel: SucursalViewModel
    lateinit var subject : PublishSubject<SucursalesResponse>
    lateinit var disposable : CompositeDisposable
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter : RecyclerView.Adapter<*>
    private lateinit var  viewManager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this ,R.layout.activity_sucursales)
        subject = PublishSubject.create()
        disposable = CompositeDisposable()
        disposable.add(handlesubject(subject))

        sucursalCallBack = SucursalCallBack(subject, this)
        sucursalViewModel = SucursalViewModel(sucursalCallBack, this)

        callWS()
    }

    private fun callWS(){
        sucursalViewModel.getSucursalRequest(this)
    }

    private fun handlesubject(subject : PublishSubject<SucursalesResponse>) : Disposable {
        return subject.subscribe {t ->
            viewManager = LinearLayoutManager(this)
            viewAdapter = MySucursalAdapter(t.responseArray, this)

            recyclerView = binding.walmartList.apply {
                setHasFixedSize(true)
                layoutManager = viewManager
                adapter = viewAdapter
            }
        }
    }
}
