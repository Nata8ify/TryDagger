package com.n8ify.mdev.akexorcistdagger.di.module

import com.n8ify.mdev.akexorcistdagger.core.main.fragment.CommentFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/* Note : Where injected fragment will belong. */
@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector
    abstract fun contributeCommentFragment() : CommentFragment

}