package com.example.bloodify

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val back = findViewById<ImageView>(R.id.back)
        val email = findViewById<EditText>(R.id.colinemail)
        val password = findViewById<EditText>(R.id.colinpassword)
        val buttonlogin = findViewById<Button>(R.id.buttonlogin)
        val askdaftar = findViewById<TextView>(R.id.askdaftar)

        // Jika icon "back" di klik
        // Intent digunakan untuk memanggil atau menampilam activity
        back.setOnClickListener {
            val intent = Intent (this, GetStartedActivity::class.java)
            startActivity(intent)

        }

        // Jika button login di klik
        buttonlogin.setOnClickListener {

            if (email.text.toString().contains("narassyp@gmail.com") && password.text.toString().contains("bulbo472")) {
                Toast.makeText(this,"Login berhasil!", Toast.LENGTH_SHORT ).show()
                val intent = Intent (this, MenuNavigasiActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this ,"User name atau Password Salah!", Toast.LENGTH_SHORT ).show()
            }

        }

        // Jika tidak memiliki akun
        askdaftar.setOnClickListener {
            val intent = Intent (this, DaftarActivity::class.java)
            startActivity(intent)
        }

    }


}