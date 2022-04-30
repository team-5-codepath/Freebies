package com.codepath.freebies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {

    private lateinit var tvPosName: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvUser: TextView
    private lateinit var tvImages: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tvPosName = findViewById(R.id.tvPostName)
        tvDescription = findViewById(R.id.tvGetDescription)
        tvUser = findViewById(R.id.tvGetUser)
        tvImages = findViewById(R.id.tvImages1)



        val post = intent.getParcelableExtra<Post>(POST_EXTRA) as Post
        Log.i(TAG, "Post is $post")

        tvPosName.text = post.getItemName()
        tvDescription.text = post.getDescription()
        tvUser.text = post.getUser()?.username
        Glide.with(applicationContext).load(post.getImage()?.url).into(tvImages)

    }
}