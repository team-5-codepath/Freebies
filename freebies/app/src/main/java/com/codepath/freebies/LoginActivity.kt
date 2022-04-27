package com.codepath.freebies

import android.content.Intent
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

        if (ParseUser.getCurrentUser() != null) {
            goToMainActivity()
        }

        findViewById<Button>(R.id.bt_signup).setOnClickListener {
            val username = findViewById<EditText>(R.id.et_username).text.toString()
            val password = findViewById<EditText>(R.id.et_password).text.toString()
            userSignUp(username,password)
        }

        findViewById<Button>(R.id.bt_login).setOnClickListener {
            val username = findViewById<EditText>(R.id.et_username).text.toString()
            val password = findViewById<EditText>(R.id.et_password).text.toString()
            loginUser(username, password)
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

    private fun loginUser(username: String, password: String) {
        ParseUser.logInInBackground(username, password,({ user, e ->
            if (user != null) {
                Log.i(TAG, "Successfully Logged in user")
                goToMainActivity()
            } else {
                //Signup failed. Look at the ParseException to see what happened.
                e.printStackTrace()
                Toast.makeText(this, "Error logging in", Toast.LENGTH_SHORT).show()
            }})
        )
    }

    private fun goToMainActivity() {
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    companion object{
        const val TAG = "LoginActivity"
    }
}