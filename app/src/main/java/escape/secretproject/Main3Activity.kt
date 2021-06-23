package escape.secretproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        overridePendingTransition(R.anim.nav_default_pop_enter_anim, R.anim.nav_default_pop_exit_anim)

        val plusone: ImageView = findViewById(R.id.plusone)
        val plustwo: ImageView = findViewById(R.id.plustwo)
        val plusthree: ImageView = findViewById(R.id.plusthree)
        val plusfour: ImageView = findViewById(R.id.plusfour)
        val plusfive: ImageView = findViewById(R.id.plusfive)
        val minusone: ImageView = findViewById(R.id.minusone)
        val minustwo: ImageView = findViewById(R.id.minustwo)
        val minusthree: ImageView = findViewById(R.id.minusthree)
        val minusfour: ImageView = findViewById(R.id.minusfour)
        val minusfive: ImageView = findViewById(R.id.minusfive)
        var clicks1 = 0
        var clicks2 = 0
        var clicks3 = 0
        var clicks4 = 0
        var clicks5 = 0
        val one: TextView = findViewById(R.id.one)
        val two: TextView = findViewById(R.id.two)
        val three: TextView = findViewById(R.id.three)
        val four: TextView = findViewById(R.id.four)
        val five: TextView = findViewById(R.id.five)
        val codefail: TextView = findViewById(R.id.codefail)
        val registerbackgroundagain: TextView = findViewById(R.id.registerbackgroundagain)
        val codefailbutton: Button = findViewById(R.id.codefailbutton)
        val enter: Button = findViewById(R.id.button)
        var code1 = 0
        var code2 = 0
        var code3 = 0
        var code4 = 0
        var code5 = 0
        val coderange = arrayListOf(0,1,2,3,4,5,6,7,8,9)
        val code: TextView = findViewById(R.id.code)


        val backfour: ImageView = findViewById(R.id.backfour)
        backfour.setOnClickListener {
            val v: TextView = findViewById(R.id.vfour)
            val preferences = getSharedPreferences("puz", Context.MODE_PRIVATE)
            val na = "na"
            v.text = na
            val editor = preferences.edit()
            editor.putString("puzzle",v.text.toString())
            editor.apply()
            val goto = Intent(this@Main3Activity, puzzlelist::class.java)
            this@Main3Activity.startActivity(goto)
        }

        val checkfour = Runnable {
            val v: TextView = findViewById(R.id.vfour)
            val preferences = getSharedPreferences("puz", Context.MODE_PRIVATE)
            val re = preferences.getString("puzzle", "defaultValue")
            v.text = re
            val editor = preferences.edit()
            editor.putString("puzzle",v.text.toString())
            editor.apply()
            if (re != "puzzlelist") {
                backfour.visibility = View.GONE
                val puzzle = "puzzlefour"
                v.text = puzzle
                editor.putString("puzzle", v.text.toString())
                editor.apply()
            }
        }
        checkfour.run()

        val codecreate = Runnable {
            code1 = coderange.random()
            code2 = coderange.random()
            code3 = coderange.random()
            code4 = coderange.random()
            code5 = coderange.random()
            code.text = ("$code1$code2$code3$code4$code5")
        }
        codecreate.run()

        plusone.setOnClickListener {
            if (clicks1 < 9) {
                clicks1++
                one.text = (+clicks1).toString()
            } else {
                clicks1 = 0
                one.text = (+clicks1).toString()
            }
        }
        minusone.setOnClickListener {
            if (clicks1 > 0) {
                clicks1--
                one.text = (+clicks1).toString()
            } else {
                clicks1 = 9
                one.text = (+clicks1).toString()
            }
        }

        plustwo.setOnClickListener {
            if (clicks2 < 9) {
                clicks2++
                two.text = (+clicks2).toString()
            } else {
                clicks2 = 0
                two.text = (+clicks2).toString()
            }
        }
        minustwo.setOnClickListener {
            if (clicks2 > 0) {
                clicks2--
                two.text = (+clicks2).toString()
            } else {
                clicks2 = 9
                two.text = (+clicks2).toString()
            }
        }

        plusthree.setOnClickListener {
            if (clicks3 < 9) {
                clicks3++
                three.text = (+clicks3).toString()
            } else {
                clicks3 = 0
                three.text = (+clicks3).toString()
            }
        }
        minusthree.setOnClickListener {
            if (clicks3 > 0) {
                clicks3--
                three.text = (+clicks3).toString()
            } else {
                clicks3 = 9
                three.text = (+clicks3).toString()
            }
        }

        plusfour.setOnClickListener {
            if (clicks4 < 9) {
                clicks4++
                four.text = (+clicks4).toString()
            } else {
                clicks4 = 0
                four.text = (+clicks4).toString()
            }
        }
        minusfour.setOnClickListener {
            if (clicks4 > 0) {
                clicks4--
                four.text = (+clicks4).toString()
            } else {
                clicks4 = 9
                four.text = (+clicks4).toString()
            }
        }

        plusfive.setOnClickListener {
            if (clicks5 < 9) {
                clicks5++
                five.text = (+clicks5).toString()
            } else {
                clicks5 = 0
                five.text = (+clicks5).toString()
            }
        }
        minusfive.setOnClickListener {
            if (clicks5 > 0) {
                clicks5--
                five.text = (+clicks5).toString()
            } else {
                clicks5 = 9
                five.text = (+clicks5).toString()
            }
        }

        codefailbutton.setOnClickListener {
            registerbackgroundagain.visibility = View.GONE
            codefail.visibility = View.GONE
            codefailbutton.visibility = View.GONE
            enter.isClickable = true
            minusfive.isClickable = true
            minusfour.isClickable = true
            minusthree.isClickable = true
            minustwo.isClickable = true
            minusone.isClickable = true
            plusfive.isClickable = true
            plusfour.isClickable = true
            plusthree.isClickable = true
            plustwo.isClickable = true
            plusone.isClickable = true
        }

        enter.setOnClickListener {
            if (clicks1 == code1 && clicks2 == code2 && clicks3 == code3 && clicks4 == code4 && clicks5 == code5) {
                val fourint = Intent(this@Main3Activity, Main4Activity::class.java)
                this@Main3Activity.startActivity(fourint)
            } else {
                registerbackgroundagain.visibility = View.VISIBLE
                codefail.visibility = View.VISIBLE
                codefailbutton.visibility = View.VISIBLE
                enter.isClickable = false
                minusfive.isClickable = false
                minusfour.isClickable = false
                minusthree.isClickable = false
                minustwo.isClickable = false
                minusone.isClickable = false
                plusfive.isClickable = false
                plusfour.isClickable = false
                plusthree.isClickable = false
                plustwo.isClickable = false
                plusone.isClickable = false
            }
        }
    }
    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }
}
