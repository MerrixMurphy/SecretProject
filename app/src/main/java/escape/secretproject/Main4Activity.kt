package escape.secretproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        overridePendingTransition(R.anim.nav_default_pop_enter_anim, R.anim.nav_default_pop_exit_anim)

        val e: TextView = findViewById(R.id.easy)
        val m: TextView = findViewById(R.id.medium)
        val h: TextView = findViewById(R.id.hard)
        val ha: TextView = findViewById(R.id.hammer)
        val d: TextView = findViewById(R.id.dagger)
        val s: TextView = findViewById(R.id.sword)
        val hi: ImageView = findViewById(R.id.hammer_image)
        val si: ImageView = findViewById(R.id.sword_image)
        val di: ImageView = findViewById(R.id.dagger_image)
        val st: TextView = findViewById(R.id.start)
        val mon: ImageView = findViewById(R.id.monster)
        val monht: ProgressBar = findViewById(R.id.monster_health)
        val pyht: ProgressBar = findViewById(R.id.player_health)
        val monhttxt: TextView = findViewById(R.id.monster_health_text)
        val pyhttxt: TextView = findViewById(R.id.player_health_text)
        val attack: TextView = findViewById(R.id.attack)
        val action: TextView = findViewById(R.id.action)
        val outcome: TextView = findViewById(R.id.outcome)
        val hitmiss: TextView = findViewById(R.id.hitmiss)
        val reload: TextView = findViewById(R.id.reload)
        val name: TextView = findViewById(R.id.player_name)
        val gold: TextView = findViewById(R.id.gold)
        val tryagain: TextView = findViewById(R.id.tryagain)

        val handler = Handler()
        val ran = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val easy = 8
        val medium = 6
        val hard = 4
        var selecteddifficulty: Int? = null

        var damage: Int? = null
        var monsterdamage = 0
        var playerhealth = 100
        var delay = 0
        var lifsteal = 0
        var goldearned = 0
        var goldworth = 0

        val slime = "slime"
        val zombie = "zombie"
        val dragon = "dragon"
        val monster = arrayListOf(
            slime,
            zombie,
            dragon
        )
        var monsterhealth = 0
        var selectedmonster: String? = null

        val hammer = "You attacked with a hammer!"
        val sword = "You attacked with a Broadsword!"
        val dagger = "You attacked with a dagger!"
        var selectedweapon: String? = null
        var test = true

        val backfive: ImageView = findViewById(R.id.backfive)
        backfive.setOnClickListener {
            val v: TextView = findViewById(R.id.vfive)
            val preferences = getSharedPreferences("puz", Context.MODE_PRIVATE)
            val na = "na"
            v.text = na
            val editor = preferences.edit()
            editor.putString("puzzle",v.text.toString())
            editor.apply()
            val goto = Intent(this@Main4Activity, puzzlelist::class.java)
            this@Main4Activity.startActivity(goto)
        }

        val checkfive = Runnable {
            val v: TextView = findViewById(R.id.vfive)
            val preferences = getSharedPreferences("puz", Context.MODE_PRIVATE)
            val re = preferences.getString("puzzle", "defaultValue")
            v.text = re
            val editor = preferences.edit()
            editor.putString("puzzle",v.text.toString())
            editor.apply()
            if (re != "puzzlelist") {
                backfive.visibility = View.GONE
                val puzzle = "puzzlefive"
                v.text = puzzle
                editor.putString("puzzle", v.text.toString())
                editor.apply()
            }
        }
        checkfive.run()

        val dot: Runnable = object : Runnable {
            override fun run() {
                if (test) {
                    if (playerhealth <= 100) {
                        playerhealth -= monsterdamage
                        pyhttxt.text = ("$playerhealth HP")
                        handler.postDelayed(this, 3000)
                        val plstat = playerhealth
                        Thread(Runnable {
                            handler.post {
                                pyht.progress = plstat
                            }
                        }).start()
                    }
                    if (playerhealth <= 0) {
                        outcome.visibility = View.VISIBLE
                        outcome.text = ("Game Over")
                        gold.visibility = View.VISIBLE
                        mon.visibility = View.GONE
                        attack.visibility = View.GONE
                        tryagain.visibility = View.VISIBLE
                        playerhealth = 0
                        pyhttxt.text = ("$playerhealth HP")
                    }
                } else {
                    handler.postDelayed(this, 1000)
                }
            }
        }
        dot.run()

        e.setOnClickListener {
            selecteddifficulty = easy
            e.visibility = View.GONE
            m.visibility = View.GONE
            h.visibility = View.GONE
            ha.visibility = View.VISIBLE
            d.visibility = View.VISIBLE
            s.visibility = View.VISIBLE
            hi.visibility = View.VISIBLE
            si.visibility = View.VISIBLE
            di.visibility = View.VISIBLE
        }

        m.setOnClickListener {
            selecteddifficulty = medium
            e.visibility = View.GONE
            m.visibility = View.GONE
            h.visibility = View.GONE
            ha.visibility = View.VISIBLE
            d.visibility = View.VISIBLE
            s.visibility = View.VISIBLE
            hi.visibility = View.VISIBLE
            si.visibility = View.VISIBLE
            di.visibility = View.VISIBLE
        }

        h.setOnClickListener {
            selecteddifficulty = hard
            e.visibility = View.GONE
            m.visibility = View.GONE
            h.visibility = View.GONE
            ha.visibility = View.VISIBLE
            d.visibility = View.VISIBLE
            s.visibility = View.VISIBLE
            hi.visibility = View.VISIBLE
            si.visibility = View.VISIBLE
            di.visibility = View.VISIBLE
        }

        ha.setOnClickListener {
            selectedweapon = hammer
            damage = 20
            ha.visibility = View.GONE
            d.visibility = View.GONE
            s.visibility = View.GONE
            hi.visibility = View.GONE
            si.visibility = View.GONE
            di.visibility = View.GONE
            st.visibility = View.VISIBLE
            delay = 1500
            lifsteal = 10
        }

        d.setOnClickListener {
            selectedweapon = dagger
            damage = 5
            ha.visibility = View.GONE
            d.visibility = View.GONE
            s.visibility = View.GONE
            hi.visibility = View.GONE
            si.visibility = View.GONE
            di.visibility = View.GONE
            st.visibility = View.VISIBLE
            delay = 500
            lifsteal = 7
        }

        s.setOnClickListener {
            selectedweapon = sword
            damage = 10
            ha.visibility = View.GONE
            d.visibility = View.GONE
            s.visibility = View.GONE
            hi.visibility = View.GONE
            si.visibility = View.GONE
            di.visibility = View.GONE
            st.visibility = View.VISIBLE
            delay = 1000
            lifsteal = 5
        }

        st.setOnClickListener {
            val surprisemonster = monster.random()
            selectedmonster = surprisemonster
            if (surprisemonster == zombie) {
                mon.setImageResource(R.drawable.zombie)
                monsterhealth = 100
                monsterdamage = 7
                goldworth = 25
            }

            if (surprisemonster == slime) {
                mon.setImageResource(R.drawable.slime_water)
                monsterhealth = 60
                monsterdamage = 3
                goldworth = 15
            }

            if (surprisemonster == dragon) {
                mon.setImageResource(R.drawable.dragon)
                monsterhealth = 140
                monsterdamage = 10
                goldworth = 35
            }
            st.visibility = View.GONE
            gold.visibility = View.VISIBLE
            name.visibility = View.VISIBLE
            monht.visibility = View.VISIBLE
            monhttxt.visibility = View.VISIBLE
            action.visibility = View.VISIBLE
            attack.visibility = View.VISIBLE
            hitmiss.visibility = View.VISIBLE
            pyht.visibility = View.VISIBLE
            pyhttxt.visibility = View.VISIBLE
            mon.visibility = View.VISIBLE
            action.text = ("Attack! It's a $selectedmonster!")
            monhttxt.text = ("$monsterhealth HP")
            pyhttxt.text = ("$playerhealth HP")
            monht.max = monsterhealth
            val prostat = monsterhealth
            Thread(Runnable {
                handler.post {
                    monht.progress = prostat
                }
            }).start()
            val plstat = playerhealth
            Thread(Runnable {
                handler.post {
                    pyht.progress = plstat
                }
            }).start()
        }

        attack.setOnClickListener {
            if (monsterhealth > 0) {
                val randomNum = ran.random()
                if (randomNum < selecteddifficulty!!) {
                    monsterhealth -= damage!!
                    if (playerhealth < 100) {
                        playerhealth += lifsteal
                        if (playerhealth >= 101) {
                            playerhealth = 100
                        }
                    }
                    hitmiss.text = ("Hit")
                    monhttxt.text = ("$monsterhealth HP")
                    pyhttxt.text = ("$playerhealth HP")
                } else {
                    hitmiss.text = ("Miss")
                }

                if (monsterhealth == 0) {
                    outcome.visibility = View.VISIBLE
                    outcome.text = ("Win")
                    reload.visibility = View.VISIBLE
                    mon.visibility = View.GONE
                    attack.visibility = View.GONE
                    goldearned += goldworth
                    gold.text = ("Gold:$goldearned")
                    suspend { dot }
                    test = false
                    if (goldearned >= 100) {
                        val topuz = Intent(this@Main4Activity, puzzlelist::class.java)
                        startActivity(topuz)
                    }
                }
                attack.isClickable = false
                val delaycode = Runnable { attack.isClickable = true }
                val plstat = playerhealth
                Thread(Runnable {
                    handler.post {
                        pyht.progress = plstat
                    }
                }).start()
                handler.postDelayed(delaycode, delay.toLong())
                val prostat = monsterhealth
                Thread(Runnable {
                    handler.post {
                        monht.progress = prostat
                    }
                }).start()
            }
        }

        reload.setOnClickListener {
            test = true
            val surprisemonster = monster.random()
            selectedmonster = surprisemonster
            if (surprisemonster == zombie) {
                mon.setImageResource(R.drawable.zombie)
                monsterhealth = 100
                monsterdamage = 7
                goldworth = 25
            }

            if (surprisemonster == slime) {
                mon.setImageResource(R.drawable.slime_water)
                monsterhealth = 60
                monsterdamage = 3
                goldworth = 15
            }

            if (surprisemonster == dragon) {
                mon.setImageResource(R.drawable.dragon)
                monsterhealth = 140
                monsterdamage = 10
                goldworth = 35
            }
            outcome.visibility = View.GONE
            reload.visibility = View.GONE
            st.visibility = View.GONE
            name.visibility = View.VISIBLE
            monht.visibility = View.VISIBLE
            monhttxt.visibility = View.VISIBLE
            action.visibility = View.VISIBLE
            attack.visibility = View.VISIBLE
            hitmiss.visibility = View.VISIBLE
            pyht.visibility = View.VISIBLE
            pyhttxt.visibility = View.VISIBLE
            mon.visibility = View.VISIBLE
            action.text = ("Attack! It's a $selectedmonster!")
            monhttxt.text = ("$monsterhealth HP")
            pyhttxt.text = ("$playerhealth HP")
            monht.max = monsterhealth
            val prostat = monsterhealth
            Thread(Runnable {
                handler.post {
                    monht.progress = prostat
                }
            }).start()
        }
        tryagain.setOnClickListener {
            goldearned = 0
            gold.text = ("Gold:$goldearned")
            gold.visibility = View.GONE
            tryagain.visibility = View.GONE
            outcome.visibility = View.GONE
            monht.visibility = View.GONE
            monhttxt.visibility = View.GONE
            hitmiss.visibility = View.GONE
            pyht.visibility = View.GONE
            pyhttxt.visibility = View.GONE
            attack.visibility = View.GONE
            name.visibility = View.GONE
            e.visibility = View.VISIBLE
            m.visibility = View.VISIBLE
            h.visibility = View.VISIBLE
            playerhealth = 100

        }
    }
    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }
}
