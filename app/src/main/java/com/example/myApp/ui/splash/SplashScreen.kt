package com.example.loginpage.ui.splash
import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginpage.core.dataSource.local.Pref
import com.example.loginpage.databinding.ActivitySplashScreenBinding
import com.example.loginpage.ui.login.LoginActivity
import com.example.loginpage.ui.second.SecondActivity

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    lateinit var pref:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {

        binding= ActivitySplashScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.root.alpha=0f
        binding.root.animate().setDuration(3000).alpha(1f).withEndAction{
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
           //start Activity
            pref=applicationContext.getSharedPreferences("MyData", MODE_PRIVATE)
            val login=pref.getBoolean("LOGIN",false)
            if(login){   startActivity(Intent(this, SecondActivity::class.java))}
            else {
                startActivity(Intent(this, LoginActivity::class.java))}

            finish()
    }
    }
}
