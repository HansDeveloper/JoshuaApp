package com.example.joshuaapp.utils

import android.content.Context
import com.example.joshuaapp.data.AppDatabase

fun getDBInstance(context : Context) : AppDatabase{
    return AppDatabase.getInstance(context)
}