package com.route.islamic37fri

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.route.islamic37fri.quran.QuranActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper())
            .postDelayed({
                startQuranActivity();
            }, 2000);
    }

    fun startQuranActivity() {
        val intent = Intent(
            this@SplashActivity,
            QuranActivity::class.java
        )
        startActivity(intent)
    }
}