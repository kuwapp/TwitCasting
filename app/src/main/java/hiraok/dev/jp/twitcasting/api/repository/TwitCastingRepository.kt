package hiraok.dev.jp.twitcasting.api.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import hiraok.dev.jp.twitcasting.api.AuthHeader
import hiraok.dev.jp.twitcasting.api.TwitCastingService
import hiraok.dev.jp.twitcasting.api.model.NewLive
import hiraok.dev.jp.twitcasting.di.NetworkModule
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

object TwitCastingRepository {

    @Inject
    lateinit var networkModule: NetworkModule

    fun getNewLiveList(): LiveData<List<NewLive>> {
        val data: MutableLiveData<List<NewLive>> = MutableLiveData()
        networkModule.provideTwitCastingService(networkModule.provideRetrofit(networkModule.provideOkHttpClient())).getNewLiveList("ja").enqueue(object : Callback<List<NewLive>> {
            override fun onResponse(call: Call<List<NewLive>>, response: Response<List<NewLive>>) {
                //To change body of created functions use File | Settings | File
                // Templates.
            }

            override fun onFailure(call: Call<List<NewLive>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
        return data
    }

}