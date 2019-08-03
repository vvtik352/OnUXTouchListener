package com.example.uxanalitic

import android.os.Build
import android.util.Log
import android.view.MotionEvent
import android.view.View
import java.util.*



object TouchAnalysis {
    lateinit var touchInfo: TouchModel

    lateinit var cache: ArrayList<TouchModel>

    fun getInfo(view: View?, motionEvent: MotionEvent?, username: String) {
        when(motionEvent?.action) {
            MotionEvent.ACTION_DOWN ->  {
                val x = motionEvent.x
                val y = motionEvent.y

                val viewName = view.toString()

                Log.d("TEST__", viewName)

                touchInfo = TouchModel(username, viewName, x, y)

                cache.add(touchInfo)

//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                    cache.forEach{
//                        Log.d("TOUCH_INFO", it.toString())
//                    }
//                }

            }
        }
    }
}