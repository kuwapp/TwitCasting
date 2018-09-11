package hiraok.dev.jp.twitcasting.ui

import android.content.Context
import android.net.Uri
import android.os.Handler
import android.webkit.WebView
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveVideoTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelectionArray
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import hiraok.dev.jp.twitcasting.VideoPlayerEventListener

class VideoPlayer(context: Context?) : VideoPlayerEventListener {

    private val player: SimpleExoPlayer

    init {
        val trackSelectionFactory = AdaptiveVideoTrackSelection.Factory(DefaultBandwidthMeter())
        player = ExoPlayerFactory.newSimpleInstance(context, DefaultTrackSelector(trackSelectionFactory), DefaultLoadControl()).apply {
            playWhenReady = true
            addListener(object : ExoPlayer.EventListener {
                override fun onTracksChanged(trackGroups: TrackGroupArray?, trackSelections: TrackSelectionArray?) {
                }

                override fun onPlayerError(error: ExoPlaybackException?) {
                }

                override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {

                }

                override fun onLoadingChanged(isLoading: Boolean) {
                }

                override fun onPositionDiscontinuity() {
                }

                override fun onTimelineChanged(timeline: Timeline?, manifest: Any?) {
                }

            })
        }
    }

    fun getPlayer(): SimpleExoPlayer {
        return player
    }

    override fun start(context: Context, uri: Uri) {
        val mediaSource = createMediaSource(context, uri)
        player.prepare(mediaSource)
    }

    override fun stop() {
    }

    override fun pause() {
    }

    override fun replay() {
    }

    override fun isPlaying() {
    }

    private fun createMediaSource(context: Context, uri: Uri): MediaSource {
        val ua = WebView(context).settings.userAgentString
        val factory = DefaultHttpDataSourceFactory(ua)
        return HlsMediaSource(uri, factory, Handler(), null)
    }

}