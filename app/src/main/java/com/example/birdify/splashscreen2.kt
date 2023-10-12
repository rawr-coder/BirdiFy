package com.example.birdify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class splashscreen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen1)
        val loginButton = findViewById<Button>(R.id.button)
        loginButton.setOnClickListener { // Create an Intent to navigate to LoginActivity
            val intent = Intent(this@splashscreen2, Login::class.java)
            startActivity(intent)
        }
    }
}