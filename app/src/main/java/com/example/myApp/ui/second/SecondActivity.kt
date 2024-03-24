package com.example.loginpage.ui.second
import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginpage.utilites.CustomAdapter
import com.example.loginpage.utilites.Listener
import com.example.loginpage.R
import com.example.loginpage.core.dataSource.local.Pref
import com.example.loginpage.ui.third.ThirdActivity
import com.example.loginpage.databinding.ActivitySecondBinding
import com.example.loginpage.core.model.Post
import com.example.loginpage.ui.login.LoginActivity
class SecondActivity:AppCompatActivity(), Listener {
    lateinit var pref:SharedPreferences
    private lateinit var viewModel: SecondViewModel
    private lateinit var binding: ActivitySecondBinding

    @SuppressLint("SuspiciousIndentation")

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivitySecondBinding.inflate(layoutInflater)
        viewModel=SecondViewModel()

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //get all posts
        viewModel.getAllPosts()
        viewModel.posts.observe(this)
        {
            if(it.isSuccessful)
            {
                binding.recycle.adapter= CustomAdapter(it.body()!!,this)
            }
            else Toast.makeText(this, "There is something", Toast.LENGTH_SHORT).show()
        }


        binding.button.setOnClickListener {
            //get posts by id
            val userid=
                if(binding.editTextText.text==null) 0
            else {
                    binding.editTextText.text.toString().toInt()
            }
            viewModel.getUserPosts(userid)
            viewModel.posts.observe(this)
            {
                if(it.isSuccessful)
                {
                    binding.recycle.adapter= CustomAdapter(it.body()!!,this)
                }
                else Toast.makeText(this, "There is something", Toast.LENGTH_SHORT).show()
            }
        }


        pref=applicationContext.getSharedPreferences("MyData", MODE_PRIVATE)
            binding.textView3.text = pref.getString("USERNAME", "none")
        }


       override fun onClicked(post: Post, position: Int) {
        intent = Intent(this, ThirdActivity::class.java)
        intent.putExtra("POSTID",post.id)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.second,menu)
        return true
    }

    @SuppressLint("CommitPrefEdits")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                pref.edit().remove("USERNAME").commit()
                pref.edit().remove("PASSWORD").commit()
                pref.edit().putBoolean("LOGIN",false).commit()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)

        }
    }

}
