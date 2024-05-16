package com.example.disneycharacaters

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.disneycharacaters.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

     lateinit var binding: ActivityLoginBinding
     companion object{
         lateinit var auth:FirebaseAuth
     }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        auth = FirebaseAuth.getInstance()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            if(email.isNotEmpty() && password.isNotEmpty())
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener{
                    if(it.isSuccessful){
                        startActivity(Intent(this,MainActivity::class.java))
                    }
                }.addOnFailureListener{
                    Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
                }
        }

        }


    private fun isVerifiedUser() {

        }


}
