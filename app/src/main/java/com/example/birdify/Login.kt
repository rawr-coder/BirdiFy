package com.example.birdify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.Email)
        passwordEditText = findViewById(R.id.Password)
        loginButton = findViewById(R.id.SignIn)
        auth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            auth.signInWithEmailAndPassword(username, password)
                .addOnSuccessListener { authResult ->
                    // The user has been successfully logged in
                    val user = authResult.user

                    // Start the main activity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .addOnFailureListener { exception ->
                    // The login failed
                    Toast.makeText(this, "The login failed: ${exception.message}", Toast.LENGTH_SHORT).show()
                }
        }

        val signup = findViewById<Button>(R.id.LogBtn)
        signup.setOnClickListener {
            try {
                // Navigate to the SignUp activity
                val intent = Intent(this@Login, SignUp::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}