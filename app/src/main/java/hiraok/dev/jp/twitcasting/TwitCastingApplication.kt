package hiraok.dev.jp.twitcasting

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class TwitCastingApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate() {
        super.onCreate()
    }
}