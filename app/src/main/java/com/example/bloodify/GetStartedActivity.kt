package com.example.bloodify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GetStartedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        val loginButton = findViewById<Button>(R.id.buttonlogin)
        val registerButton = findViewById<Button>(R.id.buttonregist)

        loginButton.setOnClickListener {
            // Launch the login activity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        registerButton.setOnClickListener {
            // Launch the register activity
            val intent = Intent(this, DaftarActivity::class.java)
            startActivity(intent)
        }
    }
}