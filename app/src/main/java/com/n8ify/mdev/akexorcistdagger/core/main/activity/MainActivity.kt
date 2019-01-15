package com.n8ify.mdev.akexorcistdagger.core.main.activity

import android.arch.lifecycle.ViewModelProviders
import android.content.SharedPreferences
import android.os.Bundle
import com.n8ify.mdev.akexorcistdagger.R
import com.n8ify.mdev.akexorcistdagger.common.BaseActivity
import com.n8ify.mdev.akexorcistdagger.core.main.viewmodel.MainViewModel
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private val mainViewModel by lazy { ViewModelProviders.of(this@MainActivity).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("sharedPreferences : $sharedPreferences")
        mainViewModel.getComments().subscribeBy(
            onSuccess = {
                it.forEach {
                    println("-> $it")
                }
            }
        )
    }
}
