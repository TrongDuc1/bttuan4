package com.example.btt2screen

import androidx.lifecycle.ViewModelProvider
import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.btt2screen.databinding.ActivityLoginScreenBinding
import kotlinx.android.synthetic.main.activity_recyclerview.*


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

        listenerSuccessEvent()
        listenerErrorEvent()

    }
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
                Toast.makeText(this, "LogIn Success", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Recyclerview::class.java))
            }
        }
    }
}

