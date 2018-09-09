package hiraok.dev.jp.twitcasting.api

import android.arch.lifecycle.LiveData
import retrofit2.http.GET
import retrofit2.http.Query

interface TwitCastingService {

    @GET("/search/lives?type=new&limit=50")
    fun getNewLiveList(@Query("lang") lang:String)
    :

}