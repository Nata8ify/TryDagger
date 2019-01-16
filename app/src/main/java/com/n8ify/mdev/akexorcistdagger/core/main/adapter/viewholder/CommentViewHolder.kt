package com.n8ify.mdev.akexorcistdagger.core.main.adapter.viewholder

import android.content.Intent
import android.view.View
import com.jakewharton.rxbinding2.view.RxView
import com.n8ify.mdev.akexorcistdagger.common.BaseViewHolder
import com.n8ify.mdev.akexorcistdagger.data.model.Comment
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.card_comment.view.*

class CommentViewHolder(itemView : View) : BaseViewHolder(itemView) {

    fun bind(comment : Comment){
        itemView.tv_title.text = "${comment.name} [${comment.email}]"
        itemView.tv_body.text = "${comment.body}"
    }

}