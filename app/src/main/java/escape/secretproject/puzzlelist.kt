package escape.secretproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class puzzlelist : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puzzlelist)
        overridePendingTransition(R.anim.nav_default_pop_enter_anim, R.anim.nav_default_pop_exit_anim)

        val one: ImageView = findViewById(R.id.one)
        val two: ImageView = findViewById(R.id.two)
        val three: ImageView = findViewById(R.id.three)
        val four: ImageView = findViewById(R.id.four)
        val five: ImageView = findViewById(R.id.five)
        val six: ImageView = findViewById(R.id.six)

        val v: TextView = findViewById(R.id.v)
        val puzzlelist = "puzzlelist"
        v.text = puzzlelist
        val preferences = getSharedPreferences("puz", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString("puzzle", v.text.toString())
        editor.apply()

        one.setOnClickListener {
            val one2 = Intent(this@puzzlelist, Loading::class.java)
            startActivity(one2)
        }

        two.setOnClickListener {
            val two2 = Intent(this@puzzlelist, MainActivity::class.java)
            startActivity(two2)

        }

        three.setOnClickListener {
            val three2 = Intent(this@puzzlelist, Main2Activity::class.java)
            startActivity(three2)
        }

        four.setOnClickListener {
            val four2 = Intent(this@puzzlelist, Main3Activity::class.java)
            startActivity(four2)
        }

        five.setOnClickListener {
            val five2 = Intent(this@puzzlelist, Main4Activity::class.java)
            startActivity(five2)
        }
        six.setOnClickListener {
            val six2 = Intent(this@puzzlelist, Main5Activity::class.java)
            startActivity(six2)
        }
    }
    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }
}
