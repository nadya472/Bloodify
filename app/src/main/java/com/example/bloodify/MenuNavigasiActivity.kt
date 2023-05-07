package com.example.bloodify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import com.example.bloodify.databinding.ActivityDaftarBinding
import com.example.bloodify.databinding.ActivityMainBinding
import com.example.bloodify.databinding.ActivityMenuNavigasiBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MenuNavigasiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuNavigasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuNavigasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnClickListener {

            when(it.id) {

                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.jadwal -> {
                    replaceFragment(JadwalFragment())
                    true
                }
                R.id.artikel -> {
                    replaceFragment(ArtikelFragment())
                    true
                }
                R.id.settings -> {
                    replaceFragment(SettingsFragment())
                    true
                }

                else -> false
            }

        }

    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()

    }
}