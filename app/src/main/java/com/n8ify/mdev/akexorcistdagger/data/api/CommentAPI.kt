package com.n8ify.mdev.akexorcistdagger.data.api

import com.n8ify.mdev.akexorcistdagger.data.model.Comment
import io.reactivex.Single
import retrofit2.http.GET

interface CommentAPI {

    @GET("comments")
    fun getComments() : Single<List<Comment>>
}