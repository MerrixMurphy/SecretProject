package escape.secretproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import java.util.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        overridePendingTransition(R.anim.nav_default_pop_enter_anim, R.anim.nav_default_pop_exit_anim)

        val pb: ProgressBar = findViewById(R.id.progressBar)
        val reloadit: ImageView = findViewById(R.id.reloadit)
        val press: TextView = findViewById(R.id.press_me)
        val answer: TextView = findViewById(R.id.winlose)
        val ot: ImageView = findViewById(R.id.ot)
        val maintitle: TextView = findViewById(R.id.main_title)
        val win = "You Made It!!!"
        val lose = "You Died from Dysentery. Game Over."
        var ProgressStatus = 0
        val Handler = Handler()
        val min = 1
        val max = 20
        val r = Random()
        val bad = 10
        maintitle.text = ("Sometimes you have to go on a journey...")
        pb.isEnabled = false

        val backthree: ImageView = findViewById(R.id.backthree)
        backthree.setOnClickListener {
            val v: TextView = findViewById(R.id.vthree)
            val preferences = getSharedPreferences("puz", Context.MODE_PRIVATE)
            val na = "na"
            v.text = na
            val editor = preferences.edit()
            editor.putString("puzzle",v.text.toString())
            editor.apply()
            val goto = Intent(this@Main2Activity, puzzlelist::class.java)
            this@Main2Activity.startActivity(goto)
        }

        val checkthree = Runnable {
            val v: TextView = findViewById(R.id.vthree)
            val preferences = getSharedPreferences("puz", Context.MODE_PRIVATE)
            val re = preferences.getString("puzzle", "defaultValue")
            v.text = re
            val editor = preferences.edit()
            editor.putString("puzzle",v.text.toString())
            editor.apply()
            if (re != "puzzlelist") {
                backthree.visibility = View.GONE
                val puzzle = "puzzlethree"
                v.text = puzzle
                editor.putString("puzzle", v.text.toString())
                editor.apply()
            }
        }
        checkthree.run()

        pb.setOnClickListener {
            val output = r.nextInt((max - min) +1) + min

            if(ProgressStatus < 100) {
                ProgressStatus -= output
            }
            if(ProgressStatus <= 0){
                maintitle.text = ("So you're tired of journeys and you said forget them huh. Not sure if it is possible, but chill in your wagon and try.")
                ot.setOnClickListener {
                    val threeint = Intent(this@Main2Activity, Main3Activity::class.java)
                    this@Main2Activity.startActivity(threeint)
                }
                press.isEnabled = false
                reloadit.isEnabled = false
            }
            Thread(Runnable {
                Handler.post { pb.progress = ProgressStatus }
            }).start()
        }

        press.setOnClickListener{
            pb.isEnabled = true
            val output = r.nextInt((max - min) +1) + min

            if(ProgressStatus < 100 && output != bad) {
                ProgressStatus += output
            }
            if(ProgressStatus < 100 && output == bad){
                pb.isEnabled = false
                maintitle.text = ("And sometimes you die of Dysentery. Sucks to suck.")
                answer.text = ("" + lose)
                ot.visibility = View.GONE
                ProgressStatus = 0
                press.isEnabled = false
            }
            if(ProgressStatus >= 100){
                pb.isEnabled = false
                maintitle.text = ("And sometimes you make it. Congrats! But remember, there is always another journey.")
                answer.text = ("" + win)
                ot.visibility = View.GONE
                press.isEnabled = false
            }
            Thread(Runnable {
                Handler.post { pb.progress = ProgressStatus }
            }).start()
        }
        reloadit.setOnClickListener {
            ProgressStatus = 0
            Thread(Runnable {
                Handler.post { pb.progress = ProgressStatus }
            }).start()
            maintitle.text = ("Sometimes you have to go on a journey...")
            answer.text = ("")
            ot.visibility = View.VISIBLE
            press.isEnabled = true
        }
    }

    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }
}
