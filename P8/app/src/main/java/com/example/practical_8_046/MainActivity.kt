package com.example.practical_8_046

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import java.text.SimpleDateFormat
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addAlarm: MaterialButton = findViewById(R.id.createAlarm)
        val card: MaterialCardView = findViewById(R.id.mcv1)
        card.visibility = View.GONE

        addAlarm.setOnClickListener {
            TimePickerDialog(
                this,
                { tp, hour, minute -> setAlarmTime(hour, minute) },
                Calendar.getInstance().get(Calendar.HOUR),
                Calendar.getInstance().get(Calendar.MINUTE),
                false
            ).show()
            card.visibility = View.VISIBLE
        }

        val cancelAlarm: MaterialButton = findViewById(R.id.createAlarmmcv1)
        cancelAlarm.setOnClickListener {
            stop()
            card.visibility = View.GONE
        }
    }

    private fun setAlarmTime(hour: Int, minute: Int) {
        val alarmTime = Calendar.getInstance()
        val year = alarmTime.get(Calendar.YEAR)
        val month = alarmTime.get(Calendar.MONTH)
        val date = alarmTime.get(Calendar.DATE)
        alarmTime.set(year, month, date, hour, minute, 0)

        val textAlarmTime : TextClock = findViewById(R.id.textClock)

        textAlarmTime.text = SimpleDateFormat("hh:mm:ss a").format(alarmTime.time)

        setAlarm(alarmTime.timeInMillis, AlarmBroadcastReceiver.ALARM_START)
        Toast.makeText(this, "Alarm Set", Toast.LENGTH_LONG).show()
    }

    private fun stop() {
        setAlarm(-1, AlarmBroadcastReceiver.ALARM_STOP)
    }

    private fun setAlarm(milliTime: Long, action: String) {
        val intentAlarm = Intent(applicationContext, AlarmBroadcastReceiver::class.java)
        intentAlarm.putExtra(AlarmBroadcastReceiver.ALARM_KEY, action)
        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            4356,
            intentAlarm,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager

        if (action == AlarmBroadcastReceiver.ALARM_START) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val canScheduleExact = alarmManager.canScheduleExactAlarms()
                if (!canScheduleExact) {
                    // Handle the case where scheduling exact alarms is not permitted
                    // You can show a message to the user or take appropriate action.
                }
            }
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, milliTime, pendingIntent)
        } else if (action == AlarmBroadcastReceiver.ALARM_STOP) {
            alarmManager.cancel(pendingIntent)
            sendBroadcast(intentAlarm)
        }
    }
}