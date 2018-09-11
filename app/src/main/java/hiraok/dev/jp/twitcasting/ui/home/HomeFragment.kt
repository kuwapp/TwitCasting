package hiraok.dev.jp.twitcasting.ui.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hiraok.dev.jp.twitcasting.R
import hiraok.dev.jp.twitcasting.ui.adapter.TwitCastingAdapter

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: HomeViewModel) {
        viewModel.twitCastingObservable.observe(this, Observer { data ->
            TwitCastingAdapter(context, data)
        })
    }

}
