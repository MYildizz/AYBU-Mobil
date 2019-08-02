package com.example.ybumobil




import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_posts.view.*



class PostsAdapter(val posts: ArrayList<String>) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {

    override fun onBindViewHolder(holder: PostsAdapter.PostsViewHolder, position: Int) {
        holder.username.text=posts[position]
        holder.layoutPosition


    }


    override fun getItemCount() = posts.size



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val view: View=LayoutInflater.from(parent.context).inflate(R.layout.row_posts,parent,false)
        return PostsViewHolder(view)
    }



    class PostsViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)
    {
        val username : TextView = itemView.username
    }
}





