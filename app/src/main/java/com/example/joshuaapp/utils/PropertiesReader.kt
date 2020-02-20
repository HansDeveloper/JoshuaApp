package com.example.joshuaapp.utils

import android.content.Context
import java.util.*

class PropertiesReader {
    private val context: Context
    private val properties: Properties
    private val filename: String

    constructor(context: Context, filename: String){
        this.filename = filename
        this.context = context
        properties = Properties()
        loadProperties()
    }


    private fun loadProperties(){
        val inputStream = context.assets.open(filename)
        properties.load(inputStream)
    }

    private fun getProperty(propertyName: String): Any {
        return properties.getProperty(propertyName)
    }

    fun getBaseUrl(): String {
        return getProperty("base.url").toString()
    }

    fun getDatabaseName(): String {
        return getProperty("database.name").toString()
    }

    fun getDatabaseSchema(): String {
        return getProperty("database.schema").toString()
    }
}