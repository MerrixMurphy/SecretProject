package escape.secretproject

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class Notification_receiver: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val title1 = "Haven't seen you in a bit."
        val text1 = "Have you solved all the puzzles yet?"
        val title2 = "We Miss You!"
        val text2 = "We know the puzzles are hard, try again!"
        val title3 = "Easter Egg"
        val text3 = "We know you're reading..."
        val title4 = "Are you a loser?"
        val text4 = "We know you're not! Try again!"
        val title5 = "You did it!"
        val text5 = "You have successfully stayed away from our app!"
        val rantitle = arrayListOf(title1, title2, title3, title4, title5)
        val title = rantitle.random()
        var text = ""
        if (title == title1){
            text = text1
        }
        if (title == title2){
            text = text2
        }
        if (title == title3){
            text = text3
        }
        if (title == title4){
            text = text4
        }
        if (title == title5){
            text = text5
        }

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val repeat = Intent(context, Splash::class.java)
        repeat.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        val pendingintent = PendingIntent.getActivity(context, 100, repeat, PendingIntent.FLAG_UPDATE_CURRENT)
        val notification =
            NotificationCompat.Builder(context, Notifications.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle(title)
                .setContentText(text)
                .setAutoCancel(true)
                .setContentIntent(pendingintent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build()
        notificationManager.notify(100, notification)
    }
}