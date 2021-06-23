package escape.secretproject

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.collections.ArrayList

class Main5Activity: AppCompatActivity() {

    private var x: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        overridePendingTransition(
            R.anim.nav_default_pop_enter_anim,
            R.anim.nav_default_pop_exit_anim
        )

        val heavy: MutableList<Int> = ArrayList()
        val standard: MutableList<Int> = ArrayList()
        val light: MutableList<Int> = ArrayList()

        heavy.add(R.raw.teen_titans)
        heavy.add(R.raw.santeria)
        heavy.add(R.raw.fade_to_black)
        heavy.add(R.raw.from_design_to_disease)
        standard.add(R.raw.unravel)
        standard.add(R.raw.not_gonna_die)
        standard.add(R.raw.hamilton)
        standard.add(R.raw.love_the_way_you_lie)
        light.add(R.raw.thrift_shop)
        light.add(R.raw.rap_god)
        light.add(R.raw.kda)
        light.add(R.raw.number_one)

        var randomIntheavy = (Random().nextInt(heavy.size))
        var soundheavy = heavy[randomIntheavy]
        var heavylist=MediaPlayer.create(this@Main5Activity,soundheavy)
        var randomIntlight = (Random().nextInt(light.size))
        var soundlight = light[randomIntlight]
        var lightlist=MediaPlayer.create(this@Main5Activity,soundlight)
        var randomIntstan = (Random().nextInt(standard.size))
        var soundstan = standard[randomIntstan]
        var stanlist=MediaPlayer.create(this@Main5Activity,soundstan)

        val heavymusicarr: ImageView = findViewById(R.id.heavymusicarr)
        val stndmusicarr: ImageView = findViewById(R.id.stndmusicarr)
        val lightmusicarr: ImageView = findViewById(R.id.lightmusicarr)

        heavymusicarr.setOnClickListener {
            if(heavylist.isPlaying){
                heavylist.stop()
                randomIntheavy = (Random().nextInt(heavy.size))
                soundheavy = heavy[randomIntheavy]
                heavylist=MediaPlayer.create(this@Main5Activity,soundheavy)
            }
            if(lightlist.isPlaying){
                lightlist.stop()
                randomIntlight = (Random().nextInt(light.size))
                soundlight = light[randomIntlight]
                lightlist=MediaPlayer.create(this@Main5Activity,soundlight)
            }
            if(stanlist.isPlaying){
                stanlist.stop()
                randomIntstan = (Random().nextInt(standard.size))
                soundstan = standard[randomIntstan]
                stanlist=MediaPlayer.create(this@Main5Activity,soundstan)
            }
            heavylist.start()
            x=heavylist
        }
        stndmusicarr.setOnClickListener {
            if(heavylist.isPlaying){
                heavylist.stop()
                randomIntheavy = (Random().nextInt(heavy.size))
                soundheavy = heavy[randomIntheavy]
                heavylist=MediaPlayer.create(this@Main5Activity,soundheavy)
            }
            if(lightlist.isPlaying){
                lightlist.stop()
                randomIntlight = (Random().nextInt(light.size))
                soundlight = light[randomIntlight]
                lightlist=MediaPlayer.create(this@Main5Activity,soundlight)
            }
            if(stanlist.isPlaying){
                stanlist.stop()
                randomIntstan = (Random().nextInt(standard.size))
                soundstan = standard[randomIntstan]
                stanlist=MediaPlayer.create(this@Main5Activity,soundstan)
            }
            stanlist.start()
            x=stanlist
        }
        lightmusicarr.setOnClickListener {
            if(heavylist.isPlaying){
                heavylist.stop()
                randomIntheavy = (Random().nextInt(heavy.size))
                soundheavy = heavy[randomIntheavy]
                heavylist=MediaPlayer.create(this@Main5Activity,soundheavy)
            }
            if(lightlist.isPlaying){
                lightlist.stop()
                randomIntlight = (Random().nextInt(light.size))
                soundlight = light[randomIntlight]
                lightlist=MediaPlayer.create(this@Main5Activity,soundlight)
            }
            if(stanlist.isPlaying){
                stanlist.stop()
                randomIntstan = (Random().nextInt(standard.size))
                soundstan = standard[randomIntstan]
                stanlist=MediaPlayer.create(this@Main5Activity,soundstan)
            }
            lightlist.start()
            x=lightlist
        }

        val dust: TextView = findViewById(R.id.dust)
        val Maria: TextView = findViewById(R.id.Maria)
        val puff: TextView = findViewById(R.id.puff)
        val plane: TextView = findViewById(R.id.plane)
        val nights: TextView = findViewById(R.id.nights)
        val grace: TextView = findViewById(R.id.grace)
        val dusts: MutableList<Int> = ArrayList()
        dusts.add(R.raw.dust)
        val d = dusts[0]
        val Marias: MutableList<Int> = ArrayList()
        Marias.add(R.raw.maria)
        val m = Marias[0]
        val puffs: MutableList<Int> = ArrayList()
        puffs.add(R.raw.puff)
        val pu = puffs[0]
        val planes: MutableList<Int> = ArrayList()
        planes.add(R.raw.plane)
        val pl = planes[0]
        val nightss: MutableList<Int> = ArrayList()
        nightss.add(R.raw.night)
        val n = nightss[0]
        val graces: MutableList<Int> = ArrayList()
        graces.add(R.raw.amazing)
        val g = graces[0]
        val play1=MediaPlayer.create(this@Main5Activity,d)
        val play2=MediaPlayer.create(this@Main5Activity,m)
        val play3=MediaPlayer.create(this@Main5Activity,pu)
        val play4=MediaPlayer.create(this@Main5Activity,pl)
        val play5=MediaPlayer.create(this@Main5Activity,n)
        val play6=MediaPlayer.create(this@Main5Activity, g)

        dust.setOnClickListener {
            play1.start()
            x=play1
        }
        Maria.setOnClickListener {
            play2.start()
            x=play2
        }
        puff.setOnClickListener {
            play3.start()
            x=play3
        }
        plane.setOnClickListener {
            play4.start()
            x=play4
        }
        nights.setOnClickListener {
            play5.start()
            x=play5
        }
        grace.setOnClickListener {
            play6.start()
            x=play6
        }

        val backsix: ImageView = findViewById(R.id.backsix)
        backsix.setOnClickListener {
            val v: TextView = findViewById(R.id.vsix)
            val preferences = getSharedPreferences("puz", Context.MODE_PRIVATE)
            val na = "na"
            v.text = na
            val editor = preferences.edit()
            editor.putString("puzzle",v.text.toString())
            editor.apply()
            heavylist.stop()
            lightlist.stop()
            stanlist.stop()
            play1.stop()
            play2.stop()
            play3.stop()
            play4.stop()
            play5.stop()
            play6.stop()
            val goto = Intent(this@Main5Activity, puzzlelist::class.java)
            this@Main5Activity.startActivity(goto)
        }

        val checkfive = Runnable {
            val v: TextView = findViewById(R.id.vsix)
            val preferences = getSharedPreferences("puz", Context.MODE_PRIVATE)
            val re = preferences.getString("puzzle", "defaultValue")
            v.text = re
            val editor = preferences.edit()
            editor.putString("puzzle",v.text.toString())
            editor.apply()
            if (re != "puzzlelist") {
                backsix.visibility = View.GONE
                val puzzle = "puzzlefive"
                v.text = puzzle
                editor.putString("puzzle", v.text.toString())
                editor.apply()
            }
        }
        checkfive.run()
    }

    override fun onPause() {
        super.onPause()
        x?.pause()
    }

    override fun onResume() {
        super.onResume()
        x?.start()
    }

    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }
}