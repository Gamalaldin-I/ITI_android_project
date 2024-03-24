package com.example.loginpage.utilites

import com.example.loginpage.core.model.Post

interface Listener {
    fun onClicked(post : Post, position:Int)
}
