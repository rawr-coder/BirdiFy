package com.example.birdify

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashScreen1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen1)
        val nextButton = findViewById<ImageButton>(R.id.circular_button)
        nextButton.setOnClickListener {
            val intent = Intent(this@SplashScreen1, SignUp::class.java)
            startActivity(intent)
        }
        val skipButton = findViewById<TextView>(R.id.skip_button)
        skipButton.setOnClickListener { // Navigate to the login page
            val intent = Intent(this@SplashScreen1, Login::class.java)
            startActivity(intent)
        }
    }
}
