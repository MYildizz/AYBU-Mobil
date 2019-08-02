package com.example.ybumobil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_food.*

class AdminPanel : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_panel)
    }

    fun addFootButton(view : View)
    {
        val posts : ArrayList<String> =ArrayList()



        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter=PostsAdapter(posts)

        for(i in 1..100)
        {
            posts.add("")

        }



    }
}
