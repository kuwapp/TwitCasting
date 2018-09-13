package hiraok.dev.jp.twitcasting.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import hiraok.dev.jp.twitcasting.TwitCastingApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    NetworkModule::class])
interface AppComponent : AndroidInjector<TwitCastingApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: TwitCastingApplication): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: TwitCastingApplication?)
}