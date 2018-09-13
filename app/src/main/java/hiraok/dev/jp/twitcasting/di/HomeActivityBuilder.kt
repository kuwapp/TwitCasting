package hiraok.dev.jp.twitcasting.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import hiraok.dev.jp.twitcasting.HomeActivity

@Module
interface HomeActivityBuilder {

    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    fun contributeHomeActivity(): HomeActivity

}