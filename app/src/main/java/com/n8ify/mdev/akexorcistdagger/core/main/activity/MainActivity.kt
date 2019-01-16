package com.n8ify.mdev.akexorcistdagger.core.main.activity

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.PersistableBundle
import com.n8ify.mdev.akexorcistdagger.R
import com.n8ify.mdev.akexorcistdagger.common.BaseActivity
import com.n8ify.mdev.akexorcistdagger.core.main.fragment.CommentFragment
import com.n8ify.mdev.akexorcistdagger.core.main.viewmodel.CommentViewModel

class MainActivity : BaseActivity() {

    init {
        TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this@MainActivity.initFragment()
    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        this@MainActivity.initFragment()
    }

    override fun initFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.ll_comments, CommentFragment.newInstance(), "CommentFragment").commit()
    }
}
