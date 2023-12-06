package kz.just_code.musicapp.data.media_player

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log
import java.io.IOException


class MediaPlayerService : Service(), MediaPlayer.OnCompletionListener,
    MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener,
    AudioManager.OnAudioFocusChangeListener {

    private val binder: IBinder = LocalBinder()
    private var player: MediaPlayer? = null
    private var mediaLink: String? = null
    private var resumePosition: Int = 0
    private var audioManager: AudioManager? = null

    override fun onCreate() {
        super.onCreate()
        registerPlayNewAudio()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        try {
            intent?.extras?.getString("media")?.let {
                mediaLink = it
            }
        } catch (e: NullPointerException) {
            stopSelf()
        }

        if (!requestAudioFocus()) {
            stopSelf()
        }

        if (mediaLink != null && mediaLink !== "") initPlayer()

        return super.onStartCommand(intent, flags, startId)
    }

    private fun initPlayer() {
        player = MediaPlayer()
        player?.setOnCompletionListener(this)
        player?.setOnErrorListener(this)
        player?.setOnPreparedListener(this)
        player?.reset()

        player?.setAudioAttributes(
            AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build()
        )
        try {
            // Set the data source to the mediaFile location
            player?.setDataSource(mediaLink)
        } catch (e: IOException) {
            e.printStackTrace()
            stopSelf()
        }
        player?.prepareAsync()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return binder
    }

    override fun onCompletion(p0: MediaPlayer?) {
        stopMedia()
        stopSelf()
    }

    override fun onPrepared(p0: MediaPlayer?) {
        playMedia()
    }

    override fun onError(p0: MediaPlayer?, what: Int, extra: Int): Boolean {
        when (what) {
            MediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK -> Log.d(
                "MediaPlayer Error",
                "MEDIA ERROR NOT VALID FOR PROGRESSIVE PLAYBACK $extra"
            )

            MediaPlayer.MEDIA_ERROR_SERVER_DIED -> Log.d(
                "MediaPlayer Error",
                "MEDIA ERROR SERVER DIED $extra"
            )

            MediaPlayer.MEDIA_ERROR_UNKNOWN -> Log.d(
                "MediaPlayer Error",
                "MEDIA ERROR UNKNOWN $extra"
            )
        }
        return false
    }

    override fun onAudioFocusChange(focusState: Int) {
        when (focusState) {
            AudioManager.AUDIOFOCUS_GAIN -> {
                // resume playback
                if (player == null) initPlayer() else if (player?.isPlaying != null) player?.start()
                player?.setVolume(1.0f, 1.0f)
            }

            AudioManager.AUDIOFOCUS_LOSS -> {
                // Lost focus for an unbounded amount of time: stop playback and release media player
                if (player?.isPlaying == true) player?.stop()
                player?.release()
                player = null
            }

            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ->             // Lost focus for a short time, but we have to stop
                // playback. We don't release the media player because playback
                // is likely to resume
                if (player?.isPlaying == true) player?.pause()

            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK ->             // Lost focus for a short time, but it's ok to keep playing
                // at an attenuated level
                if (player?.isPlaying == true) player?.setVolume(0.1f, 0.1f)
        }
    }

    private fun requestAudioFocus(): Boolean {
        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
        val result = audioManager?.requestAudioFocus(
            this,
            AudioManager.STREAM_MUSIC,
            AudioManager.AUDIOFOCUS_GAIN
        )
        return result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED
    }

    private fun removeAudioFocus(): Boolean {
        return AudioManager.AUDIOFOCUS_REQUEST_GRANTED ==
                audioManager?.abandonAudioFocus(this)
    }

    private fun playMedia() {
        if (player?.isPlaying != true) {
            player?.start()
        }
    }

    private fun stopMedia() {
        if (player == null) return
        if (player?.isPlaying == true) {
            player?.stop()
        }
    }

    private fun pauseMedia() {
        if (player?.isPlaying == true) {
            player?.pause()
            resumePosition = player?.currentPosition ?: 0
        }
    }

    private fun resumeMedia() {
        if (player?.isPlaying != true) {
            player?.seekTo(resumePosition)
            player?.start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (player != null) {
            stopMedia()
            player?.release()
        }
        unregisterReceiver(playNewAudio)
        removeAudioFocus()
    }

    class LocalBinder : Binder() {
        val service: MediaPlayerService
            get() = MediaPlayerService()
    }

    private val playNewAudio: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {

            //Get the new media index form SharedPreferences
            intent.extras?.getString("media")?.let {
                mediaLink = it
            }
            if (mediaLink.isNullOrBlank()) {
                stopSelf()
            }

            stopMedia()
            player?.reset()
            initPlayer()
        }
    }

    private fun registerPlayNewAudio() {
        val filter = IntentFilter(MediaPlayerActions.PLAY_NEW_AUDIO.name)
        registerReceiver(playNewAudio, filter)
    }
}

enum class MediaPlayerActions {
    PLAY_NEW_AUDIO,
}