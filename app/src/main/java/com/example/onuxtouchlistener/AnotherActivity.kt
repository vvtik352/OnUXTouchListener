package com.example.onuxtouchlistener

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.forEach

import kotlinx.android.synthetic.main.activity_another.*

class AnotherActivity : AppCompatActivity(), View.OnTouchListener {
    override fun onTouch(view: View?, motionEvent: MotionEvent?): Boolean {
        when(motionEvent?.action) {
            MotionEvent.ACTION_DOWN -> run {
                val x = motionEvent.x
                val y = motionEvent.y

                val viewName = view.toString()

                Log.d("TEST__", viewName)
            }
        }
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutInflater = layoutInflater.inflate(R.layout.activity_another, null, false)

        if(layoutInflater is ViewGroup)
            layoutInflater.forEach { v -> run {
                if ( v is ViewGroup)
                    v.forEach { v -> run {
                        v.setOnTouchListener(this)
                    } }
                v.setOnTouchListener(this)
            } }

        layoutInflater.setOnTouchListener(this)


        setContentView(layoutInflater)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}
