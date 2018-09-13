package hiraok.dev.jp.twitcasting.api.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import hiraok.dev.jp.twitcasting.api.model.NewLive
import hiraok.dev.jp.twitcasting.di.NetworkModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class TwitCastingRepository @Inject constructor(private val networkModule: NetworkModule) {

    fun getNewLiveList(): LiveData<List<NewLive>> {
        val data: MutableLiveData<List<NewLive>> = MutableLiveData()
        networkModule.provideTwitCastingService(networkModule.provideRetrofit(networkModule.provideOkHttpClient()))
                .getNewLiveList("ja")
                .enqueue(object : Callback<List<NewLive>> {
                    override fun onResponse(call: Call<List<NewLive>>, response: Response<List<NewLive>>) {

                    }

                    override fun onFailure(call: Call<List<NewLive>>, t: Throwable) {

                    }
                })
        return data
    }

}