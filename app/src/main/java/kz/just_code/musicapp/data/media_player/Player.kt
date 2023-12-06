package kz.just_code.musicapp.data.media_player

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder

object Player {
    private var player: MediaPlayerService? = null
    var serviceBound = false

    private var serviceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            val binder = service as MediaPlayerService.LocalBinder
            player = binder.service
            serviceBound = true
        }

        override fun onServiceDisconnected(name: ComponentName) {
            serviceBound = false
        }
    }


    fun playAudio(context: Context, media: String?) {
        if (!serviceBound) {
            val playerIntent = Intent(context, MediaPlayerService::class.java)
            playerIntent.putExtra("media", media)
            context.startService(playerIntent)
            context.bindService(playerIntent, serviceConnection, Context.BIND_AUTO_CREATE)
        } else {
            val broadcastIntent = Intent(MediaPlayerActions.PLAY_NEW_AUDIO.name)
            broadcastIntent.putExtra("media", media)
            context.sendBroadcast(broadcastIntent)
        }
    }
}