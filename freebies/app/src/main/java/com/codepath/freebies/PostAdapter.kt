package com.codepath.freebies

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


const val POST_EXTRA = "POST_EXTRA"

private const val TAG = "PostAdapter"


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

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val itemName: TextView
        val ivImage: ImageView
        val tvDescription: TextView

        init {
            itemName = itemView.findViewById(R.id.itemName)
            ivImage = itemView.findViewById(R.id.poster)
            tvDescription = itemView.findViewById(R.id.description)
            itemView.setOnClickListener(this)
        }

        fun bind(post: Post) {
            tvDescription.text = post.getDescription()
            itemName.text = post.getItemName()
            Glide.with(itemView.context).load(post.getImage()?.url).into(ivImage)
        }

        override fun onClick(v: View?) {
            var post = posts[adapterPosition]
            Toast.makeText(context,post.getDescription(), Toast.LENGTH_SHORT).show()

            val intent = Intent(context,DetailActivity::class.java)

//            intent.putExtra("Post_title",post.getItemName())
//            intent.putExtra("Post",post)

            intent.putExtra(POST_EXTRA,post)

            context.startActivity(intent)
        }
    }
}