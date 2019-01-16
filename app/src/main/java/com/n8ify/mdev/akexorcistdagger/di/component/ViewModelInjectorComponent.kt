package com.n8ify.mdev.akexorcistdagger.di.component

import com.n8ify.mdev.akexorcistdagger.common.BaseViewModel
import com.n8ify.mdev.akexorcistdagger.core.main.viewmodel.CommentViewModel
import com.n8ify.mdev.akexorcistdagger.di.module.APIsModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [APIsModule::class])
interface ViewModelInjectorComponent {

    /* Note : To (manually) provide the module into the view model. */
    fun inject(baseViewModel: BaseViewModel)
    fun inject(mainViewModel: CommentViewModel)
    // TODO : Add more 'inject(..) view model here.'
}