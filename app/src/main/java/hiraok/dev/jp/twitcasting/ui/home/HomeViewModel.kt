package hiraok.dev.jp.twitcasting.ui.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import hiraok.dev.jp.twitcasting.api.model.NewLive
import hiraok.dev.jp.twitcasting.api.repository.TwitCastingRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: TwitCastingRepository) : ViewModel() {

    val twitCastingObservable: LiveData<List<NewLive>>

    init {
        twitCastingObservable = repository.getNewLiveList()
    }

    fun getProjectListObservable(): LiveData<List<NewLive>> {
        return twitCastingObservable
    }
}
