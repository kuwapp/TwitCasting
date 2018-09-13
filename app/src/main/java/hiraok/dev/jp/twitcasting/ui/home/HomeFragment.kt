package hiraok.dev.jp.twitcasting.ui.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hiraok.dev.jp.twitcasting.R
import hiraok.dev.jp.twitcasting.ui.adapter.TwitCastingAdapter
import javax.inject.Inject

class HomeFragment : Fragment(){

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: HomeViewModel

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewModel = ViewModelProviders.of(activity!!, viewModelFactory)
                .get(HomeViewModel::class.java)
        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: HomeViewModel) {
        viewModel.getProjectListObservable()
                .observe(this, Observer { data ->
                    TwitCastingAdapter(context, data)
                })
    }

}
