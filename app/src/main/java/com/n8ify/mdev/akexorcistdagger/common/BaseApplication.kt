package com.n8ify.mdev.akexorcistdagger.common

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.n8ify.mdev.akexorcistdagger.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class BaseApplication : Application(), HasActivityInjector {

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this@BaseApplication)
    }


    /* Note > : Tell a dagger to know there activity(s) to inject */
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this@BaseApplication)
    }
}