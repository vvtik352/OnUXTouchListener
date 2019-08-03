package com.example.onuxtouchlistener

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.forEach
import com.example.uxanalitic.TouchAnalysis

class MainActivity : AppCompatActivity(), View.OnTouchListener {

    override fun onTouch(view: View?, motionEvent: MotionEvent?): Boolean {
        TouchAnalysis.getInfo(view, motionEvent, this.toString())
        return false
    }

    private lateinit var _mButtonView: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val layoutInflater = layoutInflater.inflate(R.layout.activity_main, null, false)
        //comment )for commit
        if (layoutInflater is ViewGroup)
            layoutInflater.forEach { v ->
                run {
                    if (v is ViewGroup)
                        v.forEach { v ->
                            run {
                                v.setOnTouchListener(this)
                            }
                        }
                    v.setOnTouchListener(this)
                }
            }

        layoutInflater.setOnTouchListener(this)


        setContentView(layoutInflater)

        _mButtonView = findViewById(R.id.button_view)

        _mButtonView.setOnClickListener {
            val anotherActivity = Intent(this, AnotherActivity::class.java)

            startActivity(anotherActivity)
            finish()
        }

    }
}
