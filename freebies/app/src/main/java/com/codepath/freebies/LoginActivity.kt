package com.codepath.freebies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.parse.ParseObject
import com.parse.ParseUser

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.bt_signup).setOnClickListener {
            val username = findViewById<EditText>(R.id.et_username).text.toString()
            val password = findViewById<EditText>(R.id.et_password).text.toString()
            userSignUp(username,password)
        }

    }

    private fun userSignUp(username: String, password: String){

            // Create the ParseUser
            val user = ParseUser()

            // Set fields for the user to be created
            user.setUsername(username)
            user.setPassword(password)

            user.signUpInBackground { e ->
                if (e == null) {
                    Toast.makeText(this, "Successfully signed up", Toast.LENGTH_SHORT).show()
                } else {
                    e.printStackTrace()
                    Toast.makeText(this,"Failed to sign up", Toast.LENGTH_SHORT).show()
                }
            }
        }

    companion object{
        const val TAG = "LoginActivity"
    }
}