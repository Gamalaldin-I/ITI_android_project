package com.example.loginpage.core.dataSource.local

import android.app.Activity
import android.content.SharedPreferences

object Pref :Activity(){
    private lateinit var pref:SharedPreferences

    fun getInstance():SharedPreferences//Returning one sharedPreference for all
    {
        pref=applicationContext.getSharedPreferences("MyData", MODE_PRIVATE)
        return pref
    }
}
