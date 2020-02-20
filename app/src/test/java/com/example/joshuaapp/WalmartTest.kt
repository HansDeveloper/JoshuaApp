package com.example.joshuaapp

import com.example.joshuaapp.api.walmart.response.Sucursal
import org.junit.Assert
import org.junit.Test

class WalmartTest {

    @Test
    fun fillSucursalTest(){
        val sucursal = Sucursal(1,
            "Correct answer",
            1,
            "34223",
            "34543",
            "Contreras",
            "Felipe angeles 21",
            "34568923",
            "Oscar Prieto",
            "07129",
            "1.545",
            "-1.3445",
            "1.23345",
            "8:00 AM - 9PM")

        Assert.assertEquals("Oscar Prieto", sucursal.manager)
    }
}