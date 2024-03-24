package com.example.loginpage.core.dataSource.remote

import com.example.loginpage.core.model.Comment
import com.example.loginpage.core.model.Post
import com.example.loginpage.core.model.response.UserResponse
import com.example.loginpage.core.model.body.LoginBody
//import com.example.loginpage.core.model.response.ResponsesUsersList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
   // @GET("/api/users")
           //suspend fun getUsers(): Response<ResponsesUsersList>
           @GET("/posts")
           suspend fun getPosts():Response<List<Post>>//All posts
           @GET("/posts")
           suspend fun getPostsById(@Query("userId")userId:Int): Response<List<Post>>// User Posts
           @GET("posts/{postId}/comments")
           suspend fun getPostComments(@Path("postId")postId:Int): Response<ArrayList<Comment>>// Post Comments
            @POST("auth/login")
           suspend fun login(@retrofit2.http.Body body: LoginBody): Response<UserResponse> //User auth
}
