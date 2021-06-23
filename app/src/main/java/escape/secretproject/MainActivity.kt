package escape.secretproject

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        overridePendingTransition(R.anim.nav_default_pop_enter_anim, R.anim.nav_default_pop_exit_anim)

        val registerbutton: TextView = findViewById(R.id.registerbutton)
        val registerfail: TextView = findViewById(R.id.registerfail)
        val registerfailbutton: Button = findViewById(R.id.registerfailbutton)
        val usernametext: EditText  = findViewById(R.id.username)
        val passwordtext: EditText = findViewById(R.id.password)
        val login: Button = findViewById(R.id.buttonlogin)
        val forgotpassword: TextView = findViewById(R.id.forgotbutton)
        val registerbackground: TextView = findViewById(R.id.registerbackground)
        val logo: ImageView = findViewById(R.id.logo)
        val leftturn: TextView = findViewById(R.id.leftturn)
        val rightturn: TextView = findViewById(R.id.rightturn)

        val backtwo: ImageView = findViewById(R.id.backtwo)
        backtwo.setOnClickListener {
            val v: TextView = findViewById(R.id.vtwo)
            val preferences = getSharedPreferences("puz", Context.MODE_PRIVATE)
            val na = "na"
            v.text = na
            val editor = preferences.edit()
            editor.putString("puzzle",v.text.toString())
            editor.apply()
            val goto = Intent(this@MainActivity, puzzlelist::class.java)
            this@MainActivity.startActivity(goto)
        }

        val checktwo = Runnable {
            val v: TextView = findViewById(R.id.vtwo)
            val preferences = getSharedPreferences("puz", Context.MODE_PRIVATE)
            val re = preferences.getString("puzzle", "defaultValue")
            v.text = re
            val editor = preferences.edit()
            editor.putString("puzzle",v.text.toString())
            editor.apply()
            if (re != "puzzlelist") {
                backtwo.visibility = View.GONE
                val puzzle = "puzzletwo"
                v.text = puzzle
                editor.putString("puzzle", v.text.toString())
                editor.apply()
            }
        }
        checktwo.run()

        var rotate = 0
        var slide = 0

        leftturn.setOnClickListener{
            rotate -= 90
            logo.animate().rotation(rotate.toFloat()).start()
        }
        rightturn.setOnClickListener{
            rotate += 90
            logo.animate().rotation(rotate.toFloat()).start()
        }
        leftturn.setOnLongClickListener{
            slide -= 800
            logo.animate().translationX(slide.toFloat()).start()
            leftturn.isLongClickable = slide != -800
            rightturn.isLongClickable = slide != 800
            return@setOnLongClickListener true
        }
        rightturn.setOnLongClickListener{
            slide += 800
            logo.animate().translationX(slide.toFloat()).start()
            leftturn.isLongClickable = slide != -800
            rightturn.isLongClickable = slide != 800
            return@setOnLongClickListener true
        }

        registerbutton.setOnClickListener{
            registerbutton.paintFlags = registerbutton.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            registerfail.visibility = View.VISIBLE
            registerfailbutton.visibility = View.VISIBLE
            registerbackground.visibility = View.VISIBLE
            registerfail.text = ("Sorry, it looks like accounts can't be created at the moment. Please try again in a couple of hours.")
            usernametext.isEnabled = false
            passwordtext.isEnabled = false
            login.isClickable = false
            forgotpassword.isClickable = false
            registerbutton.isClickable = false
            rightturn.isLongClickable = false
            leftturn.isLongClickable = false
            rightturn.isClickable = false
            leftturn.isClickable = false
        }
        registerfailbutton.setOnClickListener{
            registerbutton.paintFlags = registerbutton.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            forgotpassword.paintFlags = forgotpassword.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            registerfail.visibility = View.GONE
            registerfailbutton.visibility = View.GONE
            registerbackground.visibility = View.GONE
            registerfail.text = ("")
            usernametext.isEnabled = true
            passwordtext.isEnabled = true
            login.isClickable = true
            forgotpassword.isClickable = true
            registerbutton.isClickable = true
            rightturn.isLongClickable = true
            leftturn.isLongClickable = true
            rightturn.isClickable = true
            leftturn.isClickable = true
        }
        forgotpassword.setOnClickListener{
            forgotpassword.paintFlags = forgotpassword.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            registerfail.visibility = View.VISIBLE
            registerfailbutton.visibility = View.VISIBLE
            registerbackground.visibility = View.VISIBLE
            registerfail.text = ("Change close. Knight minus 7 and 8. Wear collar.")
            usernametext.isEnabled = false
            passwordtext.isEnabled = false
            login.isClickable = false
            forgotpassword.isClickable = false
            registerbutton.isClickable = false
            rightturn.isLongClickable = false
            leftturn.isLongClickable = false
            rightturn.isClickable = false
            leftturn.isClickable = false
        }
        login.setOnClickListener {
                if (TextUtils.isEmpty(usernametext.text.toString()) || TextUtils.isEmpty(passwordtext.text.toString())) {
                    registerfail.text = ("Invalid Username or Password. Please try again.")
                    registerfail.visibility = View.VISIBLE
                    registerfailbutton.visibility = View.VISIBLE
                    registerbackground.visibility = View.VISIBLE
                    usernametext.isEnabled = false
                    passwordtext.isEnabled = false
                    login.isClickable = false
                    forgotpassword.isClickable = false
                    registerbutton.isClickable = false
                    rightturn.isLongClickable = false
                    leftturn.isLongClickable = false
                    rightturn.isClickable = false
                    leftturn.isClickable = false
                } else {
                    if (usernametext.text.contains("Marco") || usernametext.text.contains("marco")
                        || usernametext.text.contains("Octeq") || usernametext.text.contains("octeq")) {
                        if ((usernametext.text.contains("Marco") || usernametext.text.contains("marco"))
                            && (passwordtext.text.contains("Polo") || passwordtext.text.contains("polo"))
                        ) {
                            val twoint = Intent(this@MainActivity, Main2Activity::class.java)
                            this@MainActivity.startActivity(twoint)
                        } else {
                            registerfail.text = ("Invalid Username or Password. Please try again.")
                            registerfail.visibility = View.VISIBLE
                            registerfailbutton.visibility = View.VISIBLE
                            registerbackground.visibility = View.VISIBLE
                            usernametext.isEnabled = false
                            passwordtext.isEnabled = false
                            login.isClickable = false
                            forgotpassword.isClickable = false
                            registerbutton.isClickable = false
                            rightturn.isLongClickable = false
                            leftturn.isLongClickable = false
                            rightturn.isClickable = false
                            leftturn.isClickable = false
                        }
                        if (usernametext.text.contains("Octeq") || usernametext.text.contains("octeq")) {
                            registerfail.text =
                                ("Did you think it would be that easy? Think again. Try moving back two spaces.")
                            registerfail.visibility = View.VISIBLE
                            registerfailbutton.visibility = View.VISIBLE
                            registerbackground.visibility = View.VISIBLE
                            usernametext.isEnabled = false
                            passwordtext.isEnabled = false
                            login.isClickable = false
                            forgotpassword.isClickable = false
                            registerbutton.isClickable = false
                            rightturn.isLongClickable = false
                            leftturn.isLongClickable = false
                            rightturn.isClickable = false
                            leftturn.isClickable = false
                        }
                    } else {
                        registerfail.text = ("Invalid Username or Password. Please try again.")
                        registerfail.visibility = View.VISIBLE
                        registerfailbutton.visibility = View.VISIBLE
                        registerbackground.visibility = View.VISIBLE
                        usernametext.isEnabled = false
                        passwordtext.isEnabled = false
                        login.isClickable = false
                        forgotpassword.isClickable = false
                        registerbutton.isClickable = false
                        rightturn.isLongClickable = false
                        leftturn.isLongClickable = false
                        rightturn.isClickable = false
                        leftturn.isClickable = false
                    }
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
