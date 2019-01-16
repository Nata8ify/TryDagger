package com.n8ify.mdev.akexorcistdagger.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.n8ify.mdev.akexorcistdagger.common.BaseActivity
import com.n8ify.mdev.akexorcistdagger.common.BaseApplication
import com.n8ify.mdev.akexorcistdagger.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

object AppInjector {
    fun init(baseApplication: BaseApplication) {
        DaggerApplicationComponent.builder().bindBaseApplication(baseApplication).build().inject(baseApplication)
        baseApplication.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) {
            }

            override fun onActivityResumed(activity: Activity?) {
            }

            override fun onActivityStarted(activity: Activity?) {
            }

            override fun onActivityDestroyed(activity: Activity?) {
            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
            }

            override fun onActivityStopped(activity: Activity?) {
            }

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                /* Note : Detecting anytime when activity is on create, then do inject with 'AndroidInjection.inject(..)' or 'AndroidSupportInjection.inject(..)'.  */
                handleInjection(activity)
            }
        })
    }

    /* Note : This method will determinate how the android component will be injected. */
    fun handleInjection(activity: Activity?) {
        when (activity) {
            is HasSupportFragmentInjector -> {
                println("Inject Act!")
                AndroidInjection.inject(activity)
            }
            is FragmentActivity -> {
                activity.supportFragmentManager.registerFragmentLifecycleCallbacks(object :
                    FragmentManager.FragmentLifecycleCallbacks() {
                    override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
                        super.onFragmentCreated(fm, f, savedInstanceState)
                        if (f is Injectable) {
                            AndroidSupportInjection.inject(f)
                        }
                    }
                }, true)

            }
        }
    }
}