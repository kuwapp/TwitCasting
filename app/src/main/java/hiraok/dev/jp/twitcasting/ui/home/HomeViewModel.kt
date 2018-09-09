package hiraok.dev.jp.twitcasting.ui.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _data = MutableLiveData<String>()
    val data: LiveData<String>
    get() = _data
}
