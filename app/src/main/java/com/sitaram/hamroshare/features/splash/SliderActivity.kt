package com.sitaram.hamroshare.features.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.sitaram.hamroshare.R
import com.sitaram.hamroshare.features.login.LoginActivity

class SliderActivity : AppCompatActivity() {
    private var mSliderViewPager: ViewPager? = null
    private var mDotLayout: LinearLayout? = null
    private var btnSkip: TextView? = null
    private var btnBack: TextView? = null
    private var btnNext: TextView? = null
    private lateinit var dots: Array<TextView?>
    private var sliderAdapter: SliderAdapter? = null
    private var editor: SharedPreferences.Editor? = null

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)

        // initialize the variable
        btnSkip = findViewById(R.id.tvSliderSkip)
        btnBack = findViewById(R.id.tvSliderBack)
        btnNext = findViewById(R.id.tvSliderNext)
        btnBack?.visibility = View.INVISIBLE

        // SharedPreferences
        val sharedPreferences = getSharedPreferences("SelfPrefs", MODE_PRIVATE)
        val hasViewedSlider = sharedPreferences.getBoolean("has_viewed_slider", false)
        if (hasViewedSlider) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            // skip button
            btnSkip?.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }

            // back button
            btnBack?.setOnClickListener(View.OnClickListener { v: View? ->
                if (getItem(0) > 0) {
                    mSliderViewPager!!.setCurrentItem(getItem(-1), true)
                }
            })

            // next button
            btnNext?.setOnClickListener(View.OnClickListener { v: View? ->
                if (getItem(0) < 2) {
                    mSliderViewPager!!.setCurrentItem(getItem(1), true)
                } else {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            })

            // initialize the mSliderViewPager and mDotLayout
            mSliderViewPager = findViewById(R.id.sliderViewPager)
            mDotLayout = findViewById(R.id.indicator_layout)
            // create an object of sliderAdapter and call the setAdapter methods
            sliderAdapter = SliderAdapter(this)
            mSliderViewPager?.adapter = sliderAdapter
            setUpIndicator(0) // call this method where it is accept the one integer parameter
            mSliderViewPager?.addOnPageChangeListener(viewListener)

            // Save the preference to indicate that the user has viewed the slider screen
            editor = sharedPreferences.edit()
            editor?.putBoolean("has_viewed_slider", true)
            editor?.apply()
        }
    }

    fun setUpIndicator(position: Int) {
        dots = arrayOfNulls(3)
        mDotLayout!!.removeAllViews()

        // using the for loop
        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i]!!.text = "\u2022"
            dots[i]!!.textSize = 35f
            dots[i]!!.setTextColor(resources.getColor(R.color.inactive, applicationContext.theme))
            mDotLayout!!.addView(dots[i])
        }
        // setTextColor for slider position
        dots[position]!!.setTextColor(resources.getColor(R.color.active, applicationContext.theme))
    }

    private var viewListener: OnPageChangeListener = object : OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int) {
            // the user is scrolling through the ViewPager
        }

        @SuppressLint("SetTextI18n")
        override fun onPageSelected(position: Int) {
            setUpIndicator(position)
            if (position > 0) {
                btnBack!!.visibility = View.VISIBLE
            } else {
                btnBack!!.visibility = View.INVISIBLE
            }
            if (position == 2) {
                btnNext!!.text = "Start"
            } else {
                btnNext!!.text = "Next"
            }
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }

    // count the slider item
    private fun getItem(item: Int): Int {
        return mSliderViewPager?.currentItem!! + item
    }
}