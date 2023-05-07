package com.example.bloodify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.View.BaseSavedState
import android.view.View.OnCreateContextMenuListener
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import kotlinx.coroutines.selects.SelectInstance
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import java.text.FieldPosition
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val introSliderAdapter = IntroSliderAdapter(
        listOf(
            IntroSlide(
                "Mulai Gaya HIDUP SEHAT dengan DONOR DARAH",
                "Temukan jadwal dan event donor darah terdekat dan mulai menjaga kesehatan dengan donor darah rutin",
                R.drawable.landingpage_1
            ),
            IntroSlide(
                "Mereka SELAMAT, kita SEHAT",
                "Tahukan kamu bahwa melakukan donor darah akan mengurangi resiko penyakit Jantung?\n" +
                        "Dan yang paling utama adalah kalian menyelamatkan nyawa pasien!",
                R.drawable.landingpage_2
            ),
            IntroSlide(
                "Dapatkan REWARD atas kebaikan hati mu!",
                "Kumpulkan point mu, dan dapatkan penawaran menarik dari kami!<",
                R.drawable.landingpage_3
            ),

        )
    )

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager2 = findViewById<ViewPager2>(R.id.introSliderViewPager)
        viewPager2.adapter = introSliderAdapter
        setupIndicators()
        setCurrentIndicator(0)

        viewPager2.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)

                // menampilkan layout get started
                if (position == viewPager2.adapter?.itemCount?.minus(1)) {
                    setupGetStartedLayout()
                }


            }
        })
    }



    private fun setupIndicators () {
        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8, 0, 8, 0)
        val layoutdots = findViewById<LinearLayout>(R.id.layoutdots)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            layoutdots.addView(indicators[i])
        }
    }
    private fun setCurrentIndicator(index: Int) {
        val layoutdots = findViewById<LinearLayout>(R.id.layoutdots)
        val childCount = layoutdots.childCount
        for (i in 0 until childCount) {
            val imageView = layoutdots.getChildAt(i) as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }
    private fun setupGetStartedLayout() {
        val intent = Intent(this, GetStartedActivity::class.java)
        startActivity(intent)
    }

}
