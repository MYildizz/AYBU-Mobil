package com.example.ybumobil

import android.app.Application
import com.parse.Parse

class ParseSettings : Application()
{
    override fun onCreate() {
        super.onCreate()

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG)

        Parse.initialize(Parse.Configuration.Builder(this)
            .applicationId("tNnqGUqEbAGOBtPrAQnayVRxOeJTnNRu1odIXTdW")
            .clientKey("MpKBk7n1gwet7ypxScHc4c8jRsPwPTWIuL9Emliu")
            .server("https://parseapi.back4app.com/")
            .build())

    }

}