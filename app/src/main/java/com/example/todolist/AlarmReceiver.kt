package com.example.todolist

import android.app.IntentService
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NotifyService : IntentService(NotifyService::class.simpleName) {
    fun onReceive(context: Context?, intent: Intent?) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        val builder = context?.let {
            NotificationCompat.Builder(it, "Chanel ID")
                .setSmallIcon(R.drawable.example_appwidget_preview)
                .setContentTitle("My notification")
                .setContentText("Hello World!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        }

        with(context?.let { NotificationManagerCompat.from(it) }) {
            // notificationId is a unique int for each notification that you must define
            if (builder != null) {
                this?.notify(0, builder.build())
            }
        }
    }

    override fun onHandleIntent(intent: Intent?) {
        TODO("Not yet implemented")
    }
}
