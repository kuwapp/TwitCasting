package hiraok.dev.jp.twitcasting

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import hiraok.dev.jp.twitcasting.di.NetworkModule

class TwitCastingApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder()
                .build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}