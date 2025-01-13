package com.example.practical_8_046

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmBroadcastReceiver : BroadcastReceiver() {
    companion object {
        const val ALARM_KEY = "key"
        const val ALARM_START = "start"
        const val ALARM_STOP = "stop"
    }

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val data = intent.getStringExtra(ALARM_KEY)
        val intentService = Intent(context, AlarmService::class.java)

        if (data == ALARM_START) {
            context.startService(intentService)
        } else {
            context.stopService(intentService)
        }
    }
}