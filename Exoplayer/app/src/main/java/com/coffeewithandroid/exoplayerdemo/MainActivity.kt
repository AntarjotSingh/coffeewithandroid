package com.coffeewithandroid.exoplayerdemo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RawRes
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.*
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var videoplayer: SimpleExoPlayer
    lateinit var audioplayer: SimpleExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createVideoPlayer()
        createAudioPlayer()
        setupVideoPlayer()
        setupAudioPlayer(URL)
        play.setOnClickListener {
            audioplayer.playWhenReady = true
        }
        pause.setOnClickListener {
            audioplayer.playWhenReady = false
        }
        playerView.player = videoplayer
    }

    fun setupAudioPlayer(url: String) {
        audioplayer.prepare(createUrlMediaSource(url))
    }

    fun setupVideoPlayer() {
        videoplayer.prepare(createRawMediaSource(R.raw.sports))
    }

    /*  */
    fun createVideoPlayer() {
        val trackselector = DefaultTrackSelector()
        val loadcontrol = DefaultLoadControl()
        val renderersfactory = DefaultRenderersFactory(this)

        videoplayer = ExoPlayerFactory.newSimpleInstance(this, renderersfactory, trackselector, loadcontrol)

        videoplayer.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
    }

    /*  */
    fun createAudioPlayer() {
        val trackselector = DefaultTrackSelector()
        val loadcontrol = DefaultLoadControl()
        val renderersfactory = DefaultRenderersFactory(this)

        audioplayer = ExoPlayerFactory.newSimpleInstance(this, renderersfactory, trackselector, loadcontrol)
    }

    /*  */
    fun createUrlMediaSource(url: String): MediaSource {
        val useragent = Util.getUserAgent(this, getString(R.string.app_name))

        return ExtractorMediaSource
            .Factory(DefaultDataSourceFactory(this, useragent))
            .setExtractorsFactory(DefaultExtractorsFactory())
            .createMediaSource(Uri.parse(url))
    }

    /*  */
    fun createRawMediaSource(@RawRes rawId: Int): MediaSource {
        val rawresourcedatasource = RawResourceDataSource(this)
        val dataspec = DataSpec(RawResourceDataSource.buildRawResourceUri(rawId))
        rawresourcedatasource.open(dataspec)

        return ExtractorMediaSource.Factory(DataSource.Factory {
            rawresourcedatasource
        }).createMediaSource(rawresourcedatasource.uri)
    }

    companion object {
        const val URL = "https://www.blogtalkradio.com/psaradio/2019/08/11/math-hoffa.mp3"
      //  const val URL = "https://traffic.libsyn.com/secure/watchbattles/DIZASTER_vs_DANNY_MYERS_with_YUKMOUTH_DIZASTER_DANNY_MYERS_and_BEAZT_GATLIN.mp3?dest-id=519171"
    }
}
