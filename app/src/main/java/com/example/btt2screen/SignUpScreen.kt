package com.example.btt2screen


import android.content.Intent
import androidx.databinding.DataBindingUtil
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.btt2screen.databinding.ActivitySignUpScreenBinding

class SignUpScreen : AppCompatActivity() {
    private lateinit var viewModel: SignUpViewModel
    private lateinit var  binding: ActivitySignUpScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up_screen)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[SignUpViewModel::class.java]
        binding.viewModel = viewModel

        binding.textlogin.setOnClickListener {
            startActivity(Intent(this, LoginScreen::class.java))
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
                DataStore.userDataStore.add(
                    mutableMapOf("fullName" to binding.inputFullname.text.toString(),
                        "email" to binding.inputEmail.text.toString(),
                        "password" to binding.inputPassword1.text.toString())
                )
                Toast.makeText(this, "SignUp Success", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
