package hiraok.dev.jp.twitcasting.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import hiraok.dev.jp.twitcasting.ui.home.HomeFragment

@Module
interface HomeActivityModule {

    @ContributesAndroidInjector
    fun contributeHomeFragment(): HomeFragment

}