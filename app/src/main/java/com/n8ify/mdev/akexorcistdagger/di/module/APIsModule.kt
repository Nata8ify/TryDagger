package com.n8ify.mdev.akexorcistdagger.di.module

import com.n8ify.mdev.akexorcistdagger.common.Const
import com.n8ify.mdev.akexorcistdagger.data.api.CommentAPI
import com.n8ify.mdev.akexorcistdagger.util.DecryptionInterceptor
import com.n8ify.mdev.akexorcistdagger.util.RxSchedulerProvider
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class APIsModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(DecryptionInterceptor())
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()
        return Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRxScheduler(): RxSchedulerProvider {
        return RxSchedulerProvider()
    }

    @Provides
    @Singleton
    fun provideCommentAPI(retrofit: Retrofit): CommentAPI {
        return retrofit.create(CommentAPI::class.java)
    }
}