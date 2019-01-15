package com.n8ify.mdev.akexorcistdagger.common

import android.arch.lifecycle.ViewModel
import com.n8ify.mdev.akexorcistdagger.core.main.viewmodel.MainViewModel
import com.n8ify.mdev.akexorcistdagger.di.component.DaggerViewModelInjectorComponent
import com.n8ify.mdev.akexorcistdagger.di.component.ViewModelInjectorComponent
import com.n8ify.mdev.akexorcistdagger.util.RxSchedulerProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
abstract class BaseViewModel : ViewModel() {

    private var injector : ViewModelInjectorComponent = DaggerViewModelInjectorComponent.builder().build()

    init {
        inject()
    }

    private fun inject() {
        when(this){
            is MainViewModel -> {
                this@BaseViewModel.injector.inject(this as MainViewModel)
            }
        }


        /* Note : 'BaseViewModel' will inject itself anytime for make some object/instance injectable and share to its child.
         * 'RxSchedulerProvider' for the example. */
        this@BaseViewModel.injector.inject(this@BaseViewModel)

    }

    @Inject
    lateinit var schedulerProvider: RxSchedulerProvider

}