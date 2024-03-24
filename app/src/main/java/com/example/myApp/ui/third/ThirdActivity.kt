package com.example.loginpage.ui.third

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginpage.databinding.ActivityThirdBinding
import com.example.loginpage.utilites.CommentAdapter

class ThirdActivity : AppCompatActivity() {

   private lateinit var  binding:ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityThirdBinding.inflate(layoutInflater)
        val viewModel=ThirdViewModel()
        setContentView(binding.root)
        //get post id from the second activity
        val postId=intent.extras?.getInt("POSTID")

        //get comments for post by post id
        viewModel.getComments(postId!!)
        viewModel.comments.observe(this)
        {
            if(it.isSuccessful)
            {
                binding.recycle.adapter= CommentAdapter(it.body()!!)
            }
            else
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
        }
    }
