package com.tokbox.sample.basicvideochat

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class MicrophoneForegroundService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        when (intent.action) {
                Actions.START.toString() -> start()
                Actions.STOP.toString()-> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun start()
    {
        var notification = NotificationCompat.Builder(this, "microphone_channel")
            .setContentTitle("Microphone notification")
            .setContentText("Microphone is on")
            .build()
        startForeground(1, notification)
    }

    public enum class Actions {
        START,
        STOP
    }
}
