package com.example.loginpage.ui.login

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.loginpage.R
import com.example.loginpage.core.dataSource.local.Pref
import com.example.loginpage.ui.second.SecondActivity
import com.example.loginpage.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel:LoginViewModel
    lateinit var pref:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        pref=applicationContext.getSharedPreferences("MyData", MODE_PRIVATE)
        val editor=pref.edit()
        binding=ActivityMainBinding.inflate(layoutInflater)
        viewModel= LoginViewModel()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



//click login
        binding.login.setOnClickListener {
            //login
        viewModel.startLogin(binding.Email.text.toString(),binding.Password.text.toString())
        viewModel.loginData.observe(this)
            {
                Toast.makeText(this,it.body().toString(), Toast.LENGTH_LONG).show()
            }


           //Save data int shared pref
            editor.putString("USERNAME",binding.Email.text.toString())
            editor.putString("PASSWORD",binding.Password.text.toString())
            editor.putBoolean("LOGIN",true)
            editor.commit()
            //collect a text to show in a toast
            var sports=""
            if(binding.checkFootball.isChecked) sports+=" "+binding.checkFootball.text
            if(binding.checkHandball.isChecked)sports+=" "+binding.checkHandball.text
            if(binding.checkVollyball.isChecked)sports+=" "+binding.checkVollyball.text
            val gender=if(binding.radioButton2.isChecked) "Male" else "Female"
            Toast.makeText(this, "Hello ${binding.Email.text} favourite sports:${sports} Gender :$gender", Toast.LENGTH_SHORT).show()
            intent()
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.exit_btn ->{val dialogBuilder: AlertDialog.Builder =AlertDialog.Builder(this)
            dialogBuilder.setTitle("...")
            dialogBuilder.setMessage(getString(R.string.message))
            dialogBuilder.setCancelable(true)
            dialogBuilder.setPositiveButton("Yes",DialogInterface.OnClickListener {Dialog,which->
                finish()
            })

            dialogBuilder.setNegativeButton("No",DialogInterface.OnClickListener{Dialog,which->
                Toast.makeText(this, "okay", Toast.LENGTH_SHORT).show()
            })
            val alertDialog:AlertDialog=dialogBuilder.create()
            alertDialog.show()
            return true}
            R.id.goToNext ->
            {
               startActivity( Intent(this, SecondActivity::class.java))
                return true
            }

            else->
            {return super.onOptionsItemSelected(item)}
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//    if(requestCode==10)
//        if(resultCode==1)
//            Toast.makeText(this,"Login by Facebook",Toast.LENGTH_LONG).show()
//    else
//            Toast.makeText(this,"Login by Google",Toast.LENGTH_LONG).show()
//
//
}

private fun intent()
{
    startActivity(Intent(this@LoginActivity, SecondActivity::class.java))
    finish()
}


}
