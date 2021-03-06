package com.example.android_mvc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_mvc.model.Post

class PostAdapter(var activity: MainActivity, var items: ArrayList<Post>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_posts_list, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post: Post = items[position]
        if (holder is PostViewHolder) {
            val ll_poster = holder.ll_poster
            val tv_title = holder.tv_title
            val tv_body = holder.tv_body
            tv_title.text = post.title.uppercase()
            tv_body.text = post.body
            ll_poster.setOnClickListener{
                activity.deletePostDialog(post)
                false
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PostViewHolder(view: View):RecyclerView.ViewHolder(view){
        var ll_poster = view.findViewById<CardView>(R.id.ll_poster)
        var tv_title = view.findViewById<TextView>(R.id.tv_title)
        var tv_body = view.findViewById<TextView>(R.id.tv_body)
    }
}