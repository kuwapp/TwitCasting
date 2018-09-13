package hiraok.dev.jp.twitcasting.di

import dagger.Module
import dagger.Provides
import hiraok.dev.jp.twitcasting.api.AuthHeader
import hiraok.dev.jp.twitcasting.api.TwitCastingService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
open class NetworkModule {

    companion object {
        val instance = NetworkModule()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
            OkHttpClient.Builder().addInterceptor {
                val header = AuthHeader.createHeader("eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImM1NWEwNDllYTczYWQwNmZmMWE1ZWFmMzc2MjUwNjg5OTM3YjBiYWRkMDdkMDk0YjVlYzIzNGI3ZDJiNjVlYjIyODVkZjJiZGUyNWIyNjhiIn0.eyJhdWQiOiJjaGlyYW9rLjJkNDM4ZDJlZmI1NjczNmFlYTdjMjgyZjZlMTkwNGI4MjQ0ZDcwN2RmZjY2MGEwM2M2MWMzMDhhYWM4MTRlODIiLCJqdGkiOiJjNTVhMDQ5ZWE3M2FkMDZmZjFhNWVhZjM3NjI1MDY4OTkzN2IwYmFkZDA3ZDA5NGI1ZWMyMzRiN2QyYjY1ZWIyMjg1ZGYyYmRlMjViMjY4YiIsImlhdCI6MTUzNjY4MjQ5MywibmJmIjoxNTM2NjgyNDkzLCJleHAiOjE1NTIyMzQ0OTMsInN1YiI6ImM6aGlyYW9rIiwic2NvcGVzIjpbInJlYWQiLCJ3cml0ZSJdfQ.R-EbEXp5z9wokGJ5Af_cwQcLI7Yd76Kx_po8TlMwmuFQdDx3zcaKsgFdgwO27ZwVYZT-eJW7694PitDgz4qOog2hcGi_3p64dXXZLH_JPHrJnTf-OyfjGJk7F0QY5vhIXBJponGziYv4wHI9iTVtOwav5N5hIOAwvEVta7rBuXRLPbp1o9Aeur_Lfe4h7TpqOBIuMi7IJfZI6fuSACnjHFmDL3BLJUvlu1x0a6Bm5UJcINzhTGkJIulGKh-0uu8HDb5giH-D34LNYIVZ8HqDaW4O_Pwu5vNqU4vGjEuLG_kOv5qyp52PmDA3NW5mPl-UuBZ1gt5kj0a-GeY_WUljgQ")
                val request = it.request()
                        .newBuilder()
                        .headers(header)
                        .build()
                it.proceed(request)
            }.build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .baseUrl("https://apiv2.twitcasting.tv")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

    @Singleton
    @Provides
    fun provideTwitCastingService(retrofit: Retrofit): TwitCastingService {
        return retrofit.create(TwitCastingService::class.java)
    }

}