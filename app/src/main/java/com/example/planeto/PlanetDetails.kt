package com.example.planeto

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_planet_details.button_info
import kotlinx.android.synthetic.main.activity_planet_details.distance_info
import kotlinx.android.synthetic.main.activity_planet_details.gravity_info
import kotlinx.android.synthetic.main.activity_planet_details.overview_info
import kotlinx.android.synthetic.main.activity_planet_details.planet_img_info
import kotlinx.android.synthetic.main.activity_planet_details.title_info

class PlanetDetails : AppCompatActivity() {
    private lateinit var obj:PlanetData
    private var planetImg:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_details)
        window.decorView.apply { systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN }
        obj = intent.getParcelableExtra("planet")!!
        planetImg= intent.getIntExtra("planetImage",-1)
            setData(obj, planetImg!!)
        button_info.setOnClickListener{
            val intent= Intent(this,finalActivity::class.java)
            startActivity(intent )
        }
    }
    private fun setData(obj:PlanetData,planetImage:Int)
    {
        title_info.text=obj.title
        distance_info.text=obj.distance+"m km"
        gravity_info.text=obj.gravity+" m/ss"
        overview_info.text=obj.overview
        gravity_info.text=obj.galaxy
        planet_img_info.setImageResource(planetImage)
    }
}