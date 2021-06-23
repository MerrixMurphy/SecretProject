package escape.secretproject

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build


class Notifications : Application() {

    companion object {
        const val CHANNEL_1_ID = "channel1"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val playpuzzle = NotificationChannel(
                CHANNEL_1_ID,
                "Haven't seen you in a bit.",
                NotificationManager.IMPORTANCE_HIGH
            )
            val missyou = NotificationChannel(
                CHANNEL_1_ID,
                "We Miss You!",
                NotificationManager.IMPORTANCE_HIGH
            )

            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.createNotificationChannel(playpuzzle)
            notificationManager.createNotificationChannel(missyou)
        }
    }
}