package hiraok.dev.jp.twitcasting

import android.net.Network
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import hiraok.dev.jp.twitcasting.api.repository.TwitCastingRepository
import hiraok.dev.jp.twitcasting.di.HomeActivityBuilder
import hiraok.dev.jp.twitcasting.di.NetworkModule

@Component(modules = [
    AndroidSupportInjectionModule::class,
    NetworkModule::class,
    HomeActivityBuilder::class])
interface ApplicationComponent : AndroidInjector<TwitCastingApplication> {

    @Component.Builder
    interface Builder {

        fun build(): ApplicationComponent

    }

    fun inject(twitCastingRepository: TwitCastingRepository)
}