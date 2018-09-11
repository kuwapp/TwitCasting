package hiraok.dev.jp.twitcasting.ui.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import hiraok.dev.jp.twitcasting.api.model.NewLive
import hiraok.dev.jp.twitcasting.api.repository.TwitCastingRepository

class HomeViewModel : ViewModel() {

    val twitCastingObservable: LiveData<List<NewLive>> = TwitCastingRepository.getNewLiveList()
}
