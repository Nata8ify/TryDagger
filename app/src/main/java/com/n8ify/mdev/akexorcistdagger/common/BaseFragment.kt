package com.n8ify.mdev.akexorcistdagger.common

import android.os.Bundle
import android.support.v4.app.Fragment
import com.n8ify.mdev.akexorcistdagger.di.Injectable
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

abstract class BaseFragment : Fragment(), Injectable{

    var TAG : String = BaseFragment::class.java.simpleName

    lateinit var activity : BaseActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.activity = getActivity() as BaseActivity
    }

    fun doOnUnexpectedError(throwable: Throwable) {
        activity.doOnUnexpectedError(throwable)
    }

}