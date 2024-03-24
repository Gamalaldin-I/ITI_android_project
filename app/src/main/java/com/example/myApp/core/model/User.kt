package com.example.loginpage.core.model

import com.google.gson.annotations.SerializedName

public data class User(
@SerializedName("id")
    var id:Int,
@SerializedName("first_name")
    var firstName:String,
@SerializedName("last_name")
    var lastName:String,
@SerializedName("avatar")
    var avatar:String,
@SerializedName("email")
    var email:String
)

