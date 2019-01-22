package th.or.gsb.corporate.di.module

import com.n8ify.mdev.akexorcistdagger.di.module.Something
import com.n8ify.mdev.akexorcistdagger.di.module.SomethingImpl
import dagger.Binds
import dagger.Module
import javax.inject.Inject

@Module
abstract class SomethingModule {
    @Binds
    abstract fun bindSomething(something : SomethingImpl) : Something
}
