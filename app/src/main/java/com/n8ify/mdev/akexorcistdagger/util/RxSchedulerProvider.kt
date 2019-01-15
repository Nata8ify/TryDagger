package com.n8ify.mdev.akexorcistdagger.util

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RxSchedulerProvider {

    fun <T> getSingleProvider() : (Single<T>) -> Single<T>{
        return {single -> single.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())}
    }
}