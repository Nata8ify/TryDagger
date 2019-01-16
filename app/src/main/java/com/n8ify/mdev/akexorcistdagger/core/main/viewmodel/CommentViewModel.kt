package com.n8ify.mdev.akexorcistdagger.core.main.viewmodel

import com.n8ify.mdev.akexorcistdagger.common.BaseViewModel
import com.n8ify.mdev.akexorcistdagger.data.api.CommentAPI
import com.n8ify.mdev.akexorcistdagger.data.model.Comment
import io.reactivex.Single
import javax.inject.Inject

class CommentViewModel : BaseViewModel() {

    @Inject
    lateinit var commentAPI: CommentAPI

    fun getComments() : Single<List<Comment>>{
        return commentAPI.getComments().compose(schedulerProvider.getSingleProvider())
    }
}