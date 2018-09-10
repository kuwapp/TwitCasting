package hiraok.dev.jp.twitcasting.api

import hiraok.dev.jp.twitcasting.api.model.NewLive
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TwitCastingService {

    @GET("/search/lives?type=new&limit=50")
    fun getNewLiveList(@Query("lang") lang: String)
            : Call<List<NewLive>>
}