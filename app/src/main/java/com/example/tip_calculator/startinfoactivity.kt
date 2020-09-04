package com.example.tip_calculator

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tip_calculator.prefrences.currency_pref
import kotlinx.android.synthetic.main.activity_startinfoactivity.*
import kotlinx.android.synthetic.main.fragment_tip_fragment.view.*

class startinfoactivity : AppCompatActivity() {
    var currency=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startinfoactivity)
        var pref=currency_pref(this)
        dollarcardviewdis.setOnClickListener {
            dollarcardviewdis.background.setTint(Color.parseColor("#13B167"))
            dollarcardviewtextdis.setTextColor(resources.getColor(R.color.white))

            poundcardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            poundcardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            eurocardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            eurocardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            pakistanicardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            pakistanicardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            chinescardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            chinescardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            currency="$"
        }
        poundcardviewdis.setOnClickListener {
            poundcardviewdis.background.setTint(Color.parseColor("#13B167"))
            poundcardviewtextdis.setTextColor(resources.getColor(R.color.white))

            dollarcardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            dollarcardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            eurocardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            eurocardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            pakistanicardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            pakistanicardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            chinescardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            chinescardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            currency="£"

        }
        eurocardviewdis.setOnClickListener {
            eurocardviewdis.background.setTint(Color.parseColor("#13B167"))
           eurocardviewtextdis.setTextColor(resources.getColor(R.color.white))

            poundcardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            poundcardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            dollarcardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            dollarcardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            pakistanicardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            pakistanicardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            chinescardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            chinescardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            currency="€"

        }
        pakistanicardviewdis.setOnClickListener {
            pakistanicardviewdis.background.setTint(Color.parseColor("#13B167"))
            pakistanicardviewtextdis.setTextColor(resources.getColor(R.color.white))

            poundcardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            poundcardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            eurocardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            eurocardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            dollarcardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
           dollarcardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            chinescardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            chinescardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            currency="Rs"
        }
        chinescardviewdis.setOnClickListener {
           chinescardviewdis.background.setTint(Color.parseColor("#13B167"))
            chinescardviewtextdis.setTextColor(resources.getColor(R.color.white))

            poundcardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            poundcardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            eurocardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            eurocardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            dollarcardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            dollarcardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            pakistanicardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            pakistanicardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            currency="¥"
        }
        nextbutton.setOnClickListener {

            if(editTextTextPersonName.text.toString().isEmpty())
            {
                editTextTextPersonName.setError("Enter Your Name Please")
            }
            else if(currency=="")
            {
                Toast.makeText(this,"Please Select Currency type",Toast.LENGTH_LONG).show()
            }
            else
            {
                pref.setcurrecnyinfo(currency)
                pref.setname(editTextTextPersonName.text.toString())
                pref.setstartinfostatus(true)
                var i: Intent = Intent(this,Main_screen_activity::class.java)
                startActivity(i)
                finish()
            }
        }
    }
}