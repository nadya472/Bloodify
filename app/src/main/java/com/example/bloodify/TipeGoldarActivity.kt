package com.example.bloodify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class TipeGoldarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipe_goldar)

        val back = findViewById<ImageView>(R.id.back)
        val unknowngoldarImageButton = findViewById<ImageView>(R.id.unknowngoldarImageButton)
        val buttonlanjut = findViewById<Button>(R.id.buttonlanjut)


        // Jika icon "back" di klik
        // Intent digunakan untuk memanggil atau menampilam activity
        back.setOnClickListener {
            val intent = Intent (this, DaftarActivity::class.java)
            startActivity(intent)

        }

        // Jika button unknown goldar di klik
        unknowngoldarImageButton.setOnClickListener {
            val intent = Intent (this, MenuNavigasiActivity::class.java)
            startActivity(intent)
            finish()
        }


        // Jika klik lanjut
        buttonlanjut.setOnClickListener {
            val intent = Intent (this, MenuNavigasiActivity::class.java)
            startActivity(intent)
        }
    }
}