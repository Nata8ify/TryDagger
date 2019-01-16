package com.n8ify.mdev.akexorcistdagger.di.component

import com.n8ify.mdev.akexorcistdagger.common.BaseApplication
import com.n8ify.mdev.akexorcistdagger.di.module.ActivityBuilder
import com.n8ify.mdev.akexorcistdagger.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/* Note : To make AndroidInjection.inject(..) and AndroidSupportInjection.inject() to function
 * 'AndroidSupportInjectionModule::class', 'AndroidInjectionModule::class' must be included. */
@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ApplicationModule::class, ActivityBuilder::class])
interface ApplicationComponent {

    /* Note : Target inject here... */
    fun inject(baseApplication: BaseApplication)

    /* Note : To provide which instance will be use in each module, we must define the method which receive its instance as parameter
     * and also annotate the method with '@BindsInstance'. */
    @Component.Builder
    interface Builder {
        @BindsInstance fun bindBaseApplication(baseApplication: BaseApplication) : Builder
        fun build() : ApplicationComponent
    }

}