package com.n8ify.mdev.akexorcistdagger.di.module

import com.n8ify.mdev.akexorcistdagger.core.main.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/* Note : This module will provide an injected instance to the activity which the method is annotated
 * with '@ContributesAndroidInjector' annotation and also return its target activity. */
@Module
abstract class ActivityBuilder {

    /* Note : 'MainActivity' can access instance which is provided by 'ApplicationModule' (and another module) now. */
    /* Important! : Contributing to its target super class may not function as well, contribute to the target activity directly is highly recommended. */
    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity

}