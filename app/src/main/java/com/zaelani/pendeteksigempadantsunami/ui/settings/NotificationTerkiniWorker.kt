package com.zaelani.pendeteksigempadantsunami.ui.settings

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent

import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.TaskStackBuilder

import androidx.preference.PreferenceManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.zaelani.pendeteksigempadantsunami.R
import com.zaelani.pendeteksigempadantsunami.data.remote.RemoteDataSource

import com.zaelani.pendeteksigempadantsunami.data.remote.response.terkini.InfoGempaTerkini
import com.zaelani.pendeteksigempadantsunami.network.ApiConfig

import com.zaelani.pendeteksigempadantsunami.ui.HomeActivity
import com.zaelani.pendeteksigempadantsunami.ui.home.HomeFragment.Companion.buffer
import com.zaelani.pendeteksigempadantsunami.utils.CHANNEL_NAME
import com.zaelani.pendeteksigempadantsunami.utils.NOTIFICATION_CHANNEL_ID
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NotificationTerkiniWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    

    private fun getPendingIntent(): PendingIntent? {
        val intent = Intent(applicationContext, HomeActivity::class.java).apply {

        }
        return TaskStackBuilder.create(applicationContext).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }
    }

    override fun doWork(): Result {

        val sharePreference = PreferenceManager.getDefaultSharedPreferences(applicationContext)

        val notify = sharePreference.getBoolean(
            applicationContext.getString(R.string.pref_key_notify),
            false
        )

        if (notify) {

            val pendingIntent = getPendingIntent()


            val notificationManager =
                applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val notification =
                NotificationCompat.Builder(applicationContext, NOTIFICATION_CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_notifications)
                    .setContentIntent(pendingIntent)
                    .setContentTitle("Gempa Terkini")
                    .setContentText(buffer.content)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setDefaults(NotificationCompat.DEFAULT_ALL)



            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    NOTIFICATION_CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_HIGH
                )
                channel.enableVibration(true)
                channel.vibrationPattern = longArrayOf(1000, 1000, 1000, 1000, 1000)

                notification.setChannelId(NOTIFICATION_CHANNEL_ID)
                notificationManager.createNotificationChannel(channel)
            }

            notificationManager.notify(1, notification.build())


        }
        return Result.success()
    }


}


