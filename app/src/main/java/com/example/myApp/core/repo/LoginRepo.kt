package com.example.loginpage.core.repo

import com.example.loginpage.core.dataSource.remote.RetrofitClient
import com.example.loginpage.core.model.body.LoginBody
import com.example.loginpage.core.model.response.UserResponse
import retrofit2.Response

class LoginRepo {
    val retrofit =RetrofitClient.getInstance("https://dummyjson.com/")
    suspend fun login(username:String,password:String):Response<UserResponse>
    {
        return retrofit.login(LoginBody(username, password))
    }
}
