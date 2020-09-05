package com.alyndroid.tabbedviews.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.alyndroid.tabbedviews.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        goToHome()
    }
    fun goToHome() {
        Handler().postDelayed({
            startActivity(
                Intent(
                    this@SplashScreen,
                    MainActivity::class.java
                )
            )
            finish()
        }, 2000)
    }
}