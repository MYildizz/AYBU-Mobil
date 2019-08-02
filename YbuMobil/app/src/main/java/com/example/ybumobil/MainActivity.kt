package com.example.ybumobil

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun selectFood(wiew : View)
    {
        val intent=Intent(applicationContext,FoodActivity::class.java)
        startActivity(intent)
    }

    fun selectObs(view : View)
    {
        val intent=Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("https://obs.ybu.edu.tr/"))
        startActivity(intent)

    }

    fun selectSocialMedia(view: View)
    {

    }

    fun selectGame(view: View)
    {

    }

    fun selectWebSite(view: View)
    {
        val intent=Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("https://aybu.edu.tr/"))
        startActivity(intent)
    }

}
