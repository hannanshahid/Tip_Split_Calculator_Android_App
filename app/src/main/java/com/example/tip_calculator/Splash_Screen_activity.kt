package com.example.tip_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.tip_calculator.prefrences.currency_pref

class Splash_Screen_activity : AppCompatActivity() {
    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 3000 //6 seconds

    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            var info_pref_obj=currency_pref(this)
            var status=info_pref_obj.getstartinfostatus()
            if(!status)
            {
                var i: Intent = Intent(this, startinfoactivity::class.java)
                startActivity(i)
                finish()
            }
            else
            {
                var i: Intent = Intent(this, Main_screen_activity::class.java)
                startActivity(i)
                finish()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Initialize the Handler
        mDelayHandler = Handler()

        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
    }
    public override fun onDestroy() {

        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }

        super.onDestroy()
    }
}