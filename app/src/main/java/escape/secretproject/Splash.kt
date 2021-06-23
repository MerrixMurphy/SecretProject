package escape.secretproject

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class Splash : AppCompatActivity() {

    private val SPLASH_TIME = 3000
    private var ProgressStatus = 0
    private val Handler = android.os.Handler()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        overridePendingTransition(R.anim.nav_default_pop_enter_anim, R.anim.nav_default_pop_exit_anim)

        val ProgressBar: ProgressBar = findViewById(R.id.progressBar)
        val LoadingText: TextView = findViewById(R.id.loading)

        fun start() {
            val ran = arrayListOf(9, 10, 11, 12, 13, 14, 15, 16)
            val x = ran.random()
            val calender = Calendar.getInstance()
            calender.set(Calendar.HOUR_OF_DAY, x)
            val intent = Intent(applicationContext, Notification_receiver::class.java)
            val pending = PendingIntent.getBroadcast(applicationContext,100, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            val AlarmManager =
                getSystemService(Context.ALARM_SERVICE) as AlarmManager
            AlarmManager.setRepeating(android.app.AlarmManager.RTC_WAKEUP,calender.timeInMillis,android.app.AlarmManager.INTERVAL_HALF_DAY, pending)
        }
        start()

        Thread(Runnable {
            while (ProgressStatus < 100) {
                ProgressStatus++
                SystemClock.sleep(30)
                Handler.post { ProgressBar.progress = ProgressStatus }
            }
            Handler.post { LoadingText.visibility = View.VISIBLE }
        }).start()

        android.os.Handler().postDelayed({
            val v: TextView = findViewById(R.id.vsplash)
            val preferences = getSharedPreferences("puz", Context.MODE_PRIVATE)
            val re = preferences.getString("puzzle", "defaultValue")
            v.text = re
            val editor = preferences.edit()
            editor.putString("puzzle",v.text.toString())
            editor.apply()
            if (re == "puzzleone"){
                val puzzleone = Intent(this@Splash, Loading::class.java)
                startActivity(puzzleone)
            }
            if (re == "puzzletwo"){
                val puzzletwo = Intent(this@Splash, MainActivity::class.java)
                startActivity(puzzletwo)
            }
            if (re == "puzzlethree"){
                val puzzlethree = Intent(this@Splash, Main2Activity::class.java)
                startActivity(puzzlethree)
            }
            if (re == "puzzlefour"){
                val puzzlefour = Intent(this@Splash, Main3Activity::class.java)
                startActivity(puzzlefour)
            }
            if (re == "puzzlefive"){
                val puzzlefive = Intent(this@Splash, Main4Activity::class.java)
                startActivity(puzzlefive)
            }
            if (re == "puzzlesix"){
                val puzzlesix = Intent(this@Splash, Main5Activity::class.java)
                startActivity(puzzlesix)
            }
            if (re == "puzzlelist"){
                val puzzlelist = Intent(this@Splash, puzzlelist::class.java)
                startActivity(puzzlelist)
            }
            if (re == "defaultValue") {
                val Splash = Intent(this@Splash, Loading::class.java)
                startActivity(Splash)
            }
        }, SPLASH_TIME.toLong())
    }

}
