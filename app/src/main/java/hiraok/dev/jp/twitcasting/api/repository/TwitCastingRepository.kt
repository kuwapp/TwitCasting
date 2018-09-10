package hiraok.dev.jp.twitcasting.api.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import hiraok.dev.jp.twitcasting.api.TwitCastingService
import hiraok.dev.jp.twitcasting.api.model.NewLive
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TwitCastingRepository() {

    private var service: TwitCastingService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://apiv2.twitcasting.tv")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        service = retrofit.create(TwitCastingService::class.java)
    }


    fun getNewLiveList(): LiveData<List<NewLive>> {
        var data: MutableLiveData<List<NewLive>> = MutableLiveData()

        service.getNewLiveList("ja").enqueue(object : Callback<List<NewLive>> {
            override fun onResponse(call: Call<List<NewLive>>, response: Response<List<NewLive>>) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFailure(call: Call<List<NewLive>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
        return data
    }

}