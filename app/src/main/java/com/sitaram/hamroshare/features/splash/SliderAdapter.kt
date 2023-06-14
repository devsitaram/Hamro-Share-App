package com.sitaram.hamroshare.features.splash

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.sitaram.hamroshare.R

class SliderAdapter(context: Context) : PagerAdapter() {

    private var context: Context? = context

    // image for intArrayOf
    private val image = intArrayOf(
        R.mipmap.img_first_slider,
        R.mipmap.img_second_slider,
        R.mipmap.img_thirs_slider
    )

    // description for intArrayOf
    private val description = intArrayOf(
        R.string.tv_first_description,
        R.string.tv_second_description,
        R.string.tv_third_description
    )

    // count the number of images
    override fun getCount(): Int {
        return image.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        val view: View = LayoutInflater.from(context).inflate(R.layout.slider_layout, container, false)
        val sliderImage = view.findViewById<ImageView>(R.id.ivSliderImage)
        val textViewDescription = view.findViewById<TextView>(R.id.tvSliderDescribtion)

        // set the image and text for next slider page
        sliderImage.setImageResource(image[position])
        textViewDescription.setText(description[position])
        container.addView(view)
        return view
    }

    // this methods can destroy item when complete the items
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}