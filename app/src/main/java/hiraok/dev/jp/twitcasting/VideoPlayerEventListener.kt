package hiraok.dev.jp.twitcasting

import android.content.Context
import android.net.Uri

interface VideoPlayerEventListener {

    fun start(context: Context, uri: Uri)

    fun stop()

    fun pause()

    fun replay()

    fun isPlaying()
}