package com.n8ify.mdev.akexorcistdagger.di.module

import android.content.Context
import android.content.SharedPreferences
import com.n8ify.mdev.akexorcistdagger.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/* Note : A module which providing instantiated object/instance. */
@Module
class ApplicationModule {

    /* Note : Provide a 'SharedPreferences' instance.
     * Note : 'BaseApplication' is provided by  @BindsInstance's bindBaseApplication(..) which available on 'ApplicationComponent'. */
    @Provides
    @Singleton
    fun provideSharedPreferences(baseApplication: BaseApplication) : SharedPreferences {
        return baseApplication.getSharedPreferences("app", Context.MODE_PRIVATE)
    }


}