package com.n8ify.mdev.akexorcistdagger.core.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.n8ify.mdev.akexorcistdagger.R
import com.n8ify.mdev.akexorcistdagger.core.main.adapter.viewholder.CommentViewHolder
import com.n8ify.mdev.akexorcistdagger.data.model.Comment

class CommentAdapter(private val comments : List<Comment>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return CommentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_comment, parent, false))
    }

    override fun getItemCount(): Int {
        return this@CommentAdapter.comments.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        (viewHolder as CommentViewHolder).bind(this@CommentAdapter.comments[position])
    }
}