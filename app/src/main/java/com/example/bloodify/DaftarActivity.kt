package com.example.bloodify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class DaftarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        val back = findViewById<ImageView>(R.id.back)
        val colinnama = findViewById<EditText>(R.id.colinnama)
        val colinemail = findViewById<EditText>(R.id.colinemail)
        val colinpassword = findViewById<EditText>(R.id.colinpassword)
        val buttonbergabung = findViewById<Button>(R.id.buttonbergabung)
        val ask = findViewById<TextView>(R.id.ask)

        // Jika icon "back" di klik
        // Intent digunakan untuk memanggil atau menampilam activity
        back.setOnClickListener {
            val intent = Intent (this, GetStartedActivity::class.java)
            startActivity(intent)

        }

        // Jika button bergabung di klik
        buttonbergabung.setOnClickListener {
                val intent = Intent (this, TipeGoldarActivity::class.java)
                startActivity(intent)
                finish()
        }


        // Jika memiliki akun
        ask.setOnClickListener {
            val intent = Intent (this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
