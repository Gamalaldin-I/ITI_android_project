package com.example.loginpage.core.model.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("id")
    var id:Int,
    @SerializedName("username")
    var username: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("firstName")
    var firstName: String,
    @SerializedName("lastName")
    var lastName: String,
    @SerializedName("gender")
    var gender:String,
    @SerializedName("image")
    var image:String,
    @SerializedName("token")
    var token:String )
