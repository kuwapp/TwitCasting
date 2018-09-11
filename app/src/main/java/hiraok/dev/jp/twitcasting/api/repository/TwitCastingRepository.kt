package hiraok.dev.jp.twitcasting.api.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import hiraok.dev.jp.twitcasting.api.TwitCastingService
import hiraok.dev.jp.twitcasting.api.model.NewLive
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TwitCastingRepository {

    private var service: TwitCastingService

    init {

        val client = OkHttpClient.Builder().addInterceptor {
            val header = AuthHeader.makeHeader(it) ?: AuthHeader.makeHeader()
            val request = it.request().newBuilder().headers(header).build()
            it.proceed(request)
        }.build()

        val retrofit = Retrofit.Builder().baseUrl("https://apiv2.twitcasting.tv").addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(TwitCastingService::class.java)
    }


    fun getNewLiveList(): LiveData<List<NewLive>> {
        var data: MutableLiveData<List<NewLive>> = MutableLiveData()

        service.getNewLiveList("ja").enqueue(object : Callback<List<NewLive>> {
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