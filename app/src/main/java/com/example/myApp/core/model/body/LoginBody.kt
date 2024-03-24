package com.example.loginpage.core.model.body

import com.google.gson.annotations.SerializedName

data class LoginBody
    (
    @SerializedName("username")
    var username:String,
    @SerializedName("password")
    var password:String
            )
