package com.example.btt2screen

import androidx.lifecycle.ViewModelProvider
import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.btt2screen.databinding.ActivityLoginScreenBinding


class LoginScreen : AppCompatActivity() {
    private lateinit var binding: ActivityLoginScreenBinding
    private lateinit var viewModel: LoginInViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_screen)
        viewModel = ViewModelProvider(this)[LoginInViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.textsignup.setOnClickListener {
            startActivity(Intent(this, SignUpScreen::class.java))
        }
        binding.back.setOnClickListener {
            startActivity(Intent(this, SignUpScreen::class.java))
        }
//        btn_login.setOnClickListener {
//            login()
//        }
        listenerSuccessEvent()
        listenerErrorEvent()
    }
//    private fun login(){
//        if(input_email.text.toString().equals(Util.ACCOUNT) && input_password.text.toString().equals(Util.PASS_WORD)) {
//            val builder = android.app.AlertDialog.Builder(this)
//            builder.setMessage("Login success")
//                .setPositiveButton("Ok", { dialogInterface: DialogInterface, i: Int -> goHome() })
//                .show()
//        } else {
//            val builder = android.app.AlertDialog.Builder(this)
//            builder.setMessage("Login faild")
//                .setNegativeButton("Ok", { dialogInterface: DialogInterface, i: Int ->})
//                .show()
//        }
//    }
//    object Util {
//        val ACCOUNT = "username@gmail.com"
//        val PASS_WORD = "123456"
//    }
//    private fun goHome() {
//        startActivity(Intent(this, ProfileScreen::class.java))
//    }
    private fun listenerErrorEvent() {
        viewModel.isErrorEvent.observe(this) { errMsg ->
            Toast.makeText(this, errMsg, Toast.LENGTH_SHORT).show()
        }
    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(this) { isSuccess ->
            if(isSuccess)
            {
                // Success
                Toast.makeText(this, "SignIn Success", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ProfileScreen::class.java))
            }
        }
    }
}

