package com.n8ify.mdev.akexorcistdagger.common

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    fun getContext() : Context {
        return itemView.context
    }


    fun getBaseActivity() : BaseActivity {
        return (itemView.context as BaseActivity)
    }

}