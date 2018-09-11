package hiraok.dev.jp.twitcasting.ui.adapter

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import hiraok.dev.jp.twitcasting.R
import hiraok.dev.jp.twitcasting.api.model.NewLive
import hiraok.dev.jp.twitcasting.ui.VideoPlayer

class TwitCastingAdapter(val context: Context?, val data: List<NewLive>?) : RecyclerView.Adapter<TwitCastingAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.live_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val videoPlayer = VideoPlayer(context)
        if (position % 5 == 0) holder.playerView.player = videoPlayer.getPlayer()
        videoPlayer.start(context!!, Uri.parse(data?.get(position)?.hls_url))
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val playerView: SimpleExoPlayerView = itemView.findViewById(R.id.playerview)
    }
}