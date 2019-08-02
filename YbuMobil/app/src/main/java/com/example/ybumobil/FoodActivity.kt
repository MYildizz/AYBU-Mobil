package com.example.ybumobil

import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.RatingBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.parse.GetCallback
import com.parse.ParseAnalytics
import com.parse.ParseObject
import com.parse.ParseQuery
import kotlinx.android.synthetic.main.activity_food.*
import kotlinx.android.synthetic.main.row_posts.*
import java.util.*
import kotlin.collections.ArrayList




class FoodActivity : AppCompatActivity() {

    val RatingList : ArrayList<Float> =ArrayList()

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)



        ParseAnalytics.trackAppOpenedInBackground(intent)

        val query = ParseQuery.getQuery<ParseObject>("Foods")



        query.findInBackground{ objects, e ->

            println("size  "+objects.size)

            if(e!=null)
            {
                Toast.makeText(applicationContext,"error",Toast.LENGTH_LONG).show()
            }
            else {
                if (objects.size > 0)
                {
                    val posts : ArrayList<String> =ArrayList()

                    // val RatingList : ArrayList<Float> =ArrayList()

                    println("size  "+objects.size)

                    var i=0
                    for(parseObject in objects)
                    {
                        var average : Double
                        val name=parseObject.get("menu") as String

                        println("aylık menu "+i+name)

                        i+=1
                        posts.add(name)


                        val pastStar=parseObject.get("PastStar") as Int
                        val oneStar=parseObject.get("OneStar") as Int
                        val onePastStar=parseObject.get("OnePastStar") as Int
                        val twoStar=parseObject.get("TwoStar") as Int
                        val twoPastStar=parseObject.get("TwoPastStar") as Int
                        val threeStar=parseObject.get("TreeStar") as Int
                        val threePastStar=parseObject.get("ThreePastStar") as Int
                        val fourStar=parseObject.get("FourStar") as Int
                        val fourPastStar=parseObject.get("FourPastStar") as Int
                        val fiveStar=parseObject.get("FiveStar") as Int

                        if((pastStar+oneStar+onePastStar+twoStar+twoPastStar+threeStar+threePastStar+fourStar+fourPastStar+fiveStar)!=0)
                        {
                            average=((pastStar*0.5)+(oneStar*1.0)+(onePastStar*1.5)+(twoStar*2.0)+(twoPastStar*2.5)+(threeStar*3.0)+(threePastStar*3.5)+(fourStar*4.0)+(fourPastStar*4.5)+(fiveStar*5))/(pastStar+oneStar+onePastStar+twoStar+twoPastStar+threeStar+threePastStar+fourStar+fourPastStar+fiveStar)
                            RatingList.add(average.toFloat())

                        }
                        else
                        {
                            average=1.0
                            RatingList.add(average.toFloat())
                        }

                        println(average)




                    }



                    recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
                    recyclerView.adapter=PostsAdapter(posts)



                    val snapHelper : SnapHelper=LinearSnapHelper()
                    snapHelper.attachToRecyclerView(recyclerView)


                    val calendar = Calendar.getInstance()
                    val day = calendar.get(Calendar.DAY_OF_MONTH)

                    println(day)
                    recyclerView.scrollToPosition(day-1)

                     val generalRating: RatingBar =findViewById<RatingBar>(R.id.generalRating)

                    //generalRating.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->  }




                    val personalRating=findViewById<RatingBar>(R.id.PersonalRating)

                    if(personalRating!=null)
                    {
                        val sendRating=findViewById<Button>(R.id.sendRating)


                        sendRating?.setOnClickListener {

                            var msg=personalRating.rating
                            Toast.makeText(applicationContext,msg.toString(),Toast.LENGTH_LONG).show()


                        }


                    }




                }
            }


        }






    }



    }








