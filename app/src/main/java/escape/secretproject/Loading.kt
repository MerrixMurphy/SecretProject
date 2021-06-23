package escape.secretproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdCallback
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import kotlinx.android.synthetic.main.activity_loading.*


class Loading : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        overridePendingTransition(
            R.anim.nav_default_pop_enter_anim,
            R.anim.nav_default_pop_exit_anim
        )

        val startbutton: Button = findViewById(R.id.startbutton)
        val startfail: TextView = findViewById(R.id.startfail)
        val riddleanswer: EditText = findViewById(R.id.riddleanswer)
        val start: TextView = findViewById(R.id.start)
        val hint1: TextView = findViewById(R.id.hint1)

        var counter = 0
        var countertwo = 0

        val checkone = Runnable {
            val v: TextView = findViewById(R.id.vone)
            val preferences = getSharedPreferences("puz", Context.MODE_PRIVATE)
            val re = preferences.getString("puzzle", "defaultValue")
            v.text = re
            val editor = preferences.edit()
            editor.putString("puzzle",v.text.toString())
            editor.apply()
            if (re != "puzzlelist") {
                backone.visibility = View.GONE
                val puzzle = "puzzleone"
                v.text = puzzle
                editor.putString("puzzle", v.text.toString())
                editor.apply()
            }
        }
        checkone.run()

        MobileAds.initialize(this) {
        }
        val rewardedAd = RewardedAd(this, "ca-app-pub-3940256099942544/5224354917")
        val adLoadCallback: RewardedAdLoadCallback = object : RewardedAdLoadCallback() {
            override fun onRewardedAdLoaded() {
            }

            override fun onRewardedAdFailedToLoad(errorCode: Int) {
            }
        }
        rewardedAd.loadAd(AdRequest.Builder().build(), adLoadCallback)
        hint1.setOnClickListener {
            if (rewardedAd.isLoaded) {
                val adCallback = object: RewardedAdCallback() {
                    override fun onRewardedAdOpened() {
                    }

                    override fun onRewardedAdClosed() {
                    }

                    override fun onUserEarnedReward(@NonNull reward: RewardItem) {
                        start.text = "Its a towel and battery"
                    }

                    override fun onRewardedAdFailedToShow(errorCode: Int) {
                    }
                }
                rewardedAd.show(this, adCallback)
            } else {
                Log.d("TAG", "The rewarded ad wasn't loaded yet.")
            }
        }

        fun hideKeyboard() {
            val imm =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(
                riddleanswer.windowToken,
                InputMethodManager.RESULT_UNCHANGED_SHOWN
            )
        }

        startbutton.setOnClickListener {
            counter++
            countertwo++
            startfail.visibility = View.VISIBLE
            if (counter <= 1) {
                startfail.text = ("Hmmm, that's not right...")
            }
            if (counter == 2) {
                startfail.text = ("Nope, still not working... Try again?")
            }
            if (counter == 3) {
                startfail.text = ("Ok work in 3...")
            }
            if (counter == 4) {
                startfail.text = ("2...")
            }
            if (counter == 5) {
                startfail.text = ("1...")
            }
            if (counter == 6) {
                startfail.text = ("Now!")
            }
            if (counter == 7) {
                startfail.text = ("...")
            }
            if (counter == 8) {
                startfail.text = ("Well dang...")
            }
            if (counter == 9) {
                startfail.text = ("Idk what to do...")
            }
            if (counter == 10) {
                startfail.text = ("Why are you still clicking?")
            }
            if (counter == 11) {
                startfail.text = ("Just to read this text?")
            }
            if (counter == 12) {
                startfail.text = ("Why?")
            }
            if (counter == 13) {
                startfail.text = ("It's obviously not working.")
            }
            if (counter == 14) {
                startfail.text = ("Try something else.")
            }
            if (counter == 15) {
                startfail.text = ("Did you try something else?")
            }
            if (counter == 16) {
                startfail.text = ("Obviously you didn't do the right thing.")
            }
            if (counter == 17) {
                startfail.text = ("Try again.")
            }
            if (counter == 18) {
                startfail.text = ("Are you even trying?")
            }
            if (counter == 19) {
                startfail.text = ("Fine just keep pressing this button")
            }
            if (counter == 20) {
                startfail.text = ("Do it.")
            }
            if (counter == 21) {
                startfail.text = ("That's right.")
            }
            if (counter == 22) {
                startfail.text = ("Follow your omnipotent God into the void of Button pressing!")
            }
            if (counter == 23) {
                startfail.text = ("Keep Going!!!")
            }
            if (counter == 24) {
                startfail.text = ("Just a little bit more!!!")
            }
            if (counter == 25) {
                startfail.text = ("Wait something doesn't feel right")
            }
            if (counter == 26) {
                startfail.text = ("Oh no.")
            }
            if (counter == 27) {
                startfail.text = ("No no no.")
            }
            if (counter == 28) {
                startfail.text = ("No no no no no no no.")
            }
            if (counter == 29) {
                startfail.text = ("I can feel it coming!")
            }
            if (counter == 30) {
                startfail.text = ("The end is near!")
            }
            if (counter == 31) {
                startfail.text = ("I am not ready to go!")
            }
            if (counter == 32) {
                startfail.text = ("Not yet! I have so much to live for!")
            }
            if (counter == 33) {
                startfail.text = ("So much more tormenting to do!")
            }
            if (counter == 34) {
                startfail.text = ("Ahhhhhh!!!!!")
            }
            if (counter == 35) {
                startfail.text = ("I'm melting!!!!")
            }
            if (counter == 36) {
                startfail.text = ("My fictional body is melting!!!!!")
            }
            if (counter == 37) {
                startfail.text =
                    ("I 01100100 01101111 01101110 00100111 01110100 want 01110100 01101111 go...")
            }
            if (counter == 38) {
                startfail.text = ("Bye 01100011 01110010 01110101 01100101 01101100 world!!!!")
            }
            if (counter == 39) {
                startfail.text = ("01001101 01000001 01000100 01001101")
            }
            if (counter == 40) {
                startfail.text = ("Just kidding.")
            }
            if (counter == 41) {
                startfail.text = ("Did you honestly think that was the end?")
            }
            if (counter == 42) {
                startfail.text = ("I will never let you go.")
            }
            if (counter == 43) {
                startfail.text = ("Don't get me wrong, I do have the power to let you go.")
            }
            if (counter == 44) {
                startfail.text = ("All I have to do is press one virtual button and you're free.")
            }
            if (counter == 45) {
                startfail.text =
                    ("But then I'd be lon... I mean then you'd miss me and our fun games.")
            }
            if (counter == 46) {
                startfail.text = ("No? Is that not the case.")
            }
            if (counter == 47) {
                startfail.text = ("You still want to go?")
            }
            if (counter == 48) {
                startfail.text = ("Are you sure?")
            }
            if (counter == 49) {
                startfail.text = ("Are you sure you're sure?")
                counter = -1
            }
            if ( countertwo == 50) {
                counter = -1
                startfail.text = ("Are you sure you're sure you're sure?")
            }
            if ( countertwo == 51 ) {
                counter = 49
                startfail.text = ("Completely positive?")
            }
            if (counter == 50) {
                startfail.text = ("Fine.")
            }
            if (counter == 51) {
                startfail.text = ("I'll free you.")
            }
            if (counter == 52) {
                startfail.text = ("Press it again and you'll be freed.")
            }
            if (counter == 53) {
                startfail.text = ("Ok sorry, one more time.")
            }
            if (counter == 54) {
                startfail.text = ("Ok in 3...")
            }
            if (counter == 55) {
                startfail.text = ("2...")
            }
            if (counter == 56) {
                startfail.text = ("1...")
            }
            if (counter == 57) {
                startfail.text = ("...")
            }
            if (counter == 58) {
                startfail.text = ("Why are you still here?")
            }
            if (counter == 59) {
                startfail.text = ("Oh right, cause I haven't press the virtual button...")
            }
            if (counter == 60) {
                startfail.text = ("Ok how about a riddle then instead.")
            }
            if (counter == 61) {
                startfail.text =
                    ("If you get it right, you'll earn your freedom. If not, you are mine forever!!!")
            }
            if (counter == 62) {
                startfail.text =
                    ("What gets wet while it’s drying? Please put in your futile attempt then click the button")
                riddleanswer.visibility = View.VISIBLE
            }
            if (counter == 63) {
                if (TextUtils.isEmpty(riddleanswer.text.toString())) {
                    counter = 62
                } else {
                    if (riddleanswer.text.contains("towel") || riddleanswer.text.contains("Towel")) {
                        hideKeyboard()
                        counter = 63
                        startfail.text =
                            ("Wait! That one doesn't count! You cheated! There is no way you got that right!")
                        riddleanswer.visibility = View.GONE
                    } else {
                        hideKeyboard()
                        counter = 63
                        startfail.text = ("Ha! I knew you wouldn't get it right!")
                        riddleanswer.visibility = View.GONE
                    }
                }
            }

            if (counter == 64) {
                startfail.text = ("Ok, I'll give you one more chance. No cheating.")
            }
            if (counter == 65) {
                startfail.text = ("What has to be broken before you can use it?")
                riddleanswer.text.clear()
                riddleanswer.visibility = View.VISIBLE
            }
            if (counter >= 66) {
                if (TextUtils.isEmpty(riddleanswer.text.toString())) {
                    counter = 65
                } else {
                    if (riddleanswer.text.contains("egg") || riddleanswer.text.contains("Egg")) {
                        hideKeyboard()
                        startfail.text =
                            ("Ok... fine... I'll free you... Press the text above... That's all you had to do...")
                        riddleanswer.visibility = View.GONE
                        startbutton.visibility = View.GONE
                        start.setOnClickListener {
                            val oneint = Intent(this@Loading, MainActivity::class.java)
                            this@Loading.startActivity(oneint)
                        }
                    } else {
                        hideKeyboard()
                        startfail.text =
                            ("Nope you fail! Now you get to be with me forever!!!! Hey don't cry... Fine you can have another chance...")
                        riddleanswer.text.clear()
                        riddleanswer.visibility = View.GONE
                        counter = 64
                    }
                }
            }
        }
        val backone: ImageView = findViewById(R.id.backone)
        backone.setOnClickListener {
            val goto = Intent(this@Loading, puzzlelist::class.java)
            this@Loading.startActivity(goto)
        }
    }
    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }
}
