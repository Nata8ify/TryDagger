package com.n8ify.mdev.akexorcistdagger.common

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


/* Important : 'HasSupportFragmentInjector' was implemented to told the dagger to know there are child fragment(s) in this activity which need to do DI(Dependency Injection). */
abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {

    var TAG : String = BaseActivity::class.java.simpleName

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    /* Note > : Tell a dagger to know there are fragment(s) to inject */
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    override fun supportFragmentInjector(): AndroidInjector<Fragment>  = dispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    /** To implement the fragment action. */
    internal open fun initFragment() {
        Log.i(TAG, "Step -> Initial Fragment")
    }

    /** To implement the observing action. */
    internal open fun initObserving() {
        Log.i(TAG, "Step -> Initial Observing")
    }

    fun doOnUnexpectedError(throwable: Throwable){
        throwable.printStackTrace()
        Toast.makeText(this@BaseActivity, "Unexpected error! caused by ${throwable.message}", Toast.LENGTH_LONG)
    }

}