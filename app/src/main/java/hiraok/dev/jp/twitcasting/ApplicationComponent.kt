package hiraok.dev.jp.twitcasting

import dagger.Component
import hiraok.dev.jp.twitcasting.api.repository.TwitCastingRepository
import hiraok.dev.jp.twitcasting.di.NetworkModule

@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(twitCastingRepository: TwitCastingRepository)
}