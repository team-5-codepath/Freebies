package com.codepath.freebies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PostAdapter(val context: Context, val posts: List<Post>): RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        val post = posts.get(position)
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView
        val ivImage: ImageView
        val tvDescription: TextView

        init {
            itemName = itemView.findViewById(R.id.itemName)
            ivImage = itemView.findViewById(R.id.poster)
            tvDescription = itemView.findViewById(R.id.description)
        }

        fun bind(post: Post) {
            tvDescription.text = post.getDescription()
            itemName.text = post.getItemName()
            Glide.with(itemView.context).load(post.getImage()?.url).into(ivImage)
        }
    }
}