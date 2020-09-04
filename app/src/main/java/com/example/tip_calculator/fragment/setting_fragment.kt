package com.example.tip_calculator.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.example.tip_calculator.R
import com.example.tip_calculator.prefrences.currency_pref
import kotlinx.android.synthetic.main.activity_startinfoactivity.*
import kotlinx.android.synthetic.main.activity_startinfoactivity.view.*
import kotlinx.android.synthetic.main.fragment_setting_fragment.*
import kotlinx.android.synthetic.main.fragment_setting_fragment.view.*
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [setting_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class setting_fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    var currency:String=""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v=inflater.inflate(R.layout.fragment_setting_fragment, container, false)
        var pref_object=currency_pref(context!!)
        currency=pref_object.getcurrencyinfo()!!
        setcurrency(v!!)
        var intro_pref= context?.let { currency_pref(it) }
        v?.setting_name_textview?.text=intro_pref?.getname()?.toUpperCase(Locale.ROOT)
        v.pakistanicardviewsi.setOnClickListener {
            v.pakistanicardviewsi.background.setTint(Color.parseColor("#13B167"))
            v.pakistanicardviewtextsi.setTextColor(resources.getColor(R.color.white))

            v.poundcardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.poundcardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            v.eurocardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.eurocardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            v.dollarcardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.dollarcardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            v.chinescardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.chinescardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            currency="Rs"
            pref_object.setcurrecnyinfo(currency)
        }
        v.poundcardviewsi.setOnClickListener {
            v.poundcardviewsi.background.setTint(Color.parseColor("#13B167"))
            v.poundcardviewtextsi.setTextColor(resources.getColor(R.color.white))

            v.eurocardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.eurocardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            v.dollarcardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.dollarcardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            v.pakistanicardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.pakistanicardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            v.chinescardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.chinescardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            currency="£"
            pref_object.setcurrecnyinfo(currency)
        }
        v.dollarcardviewsi.setOnClickListener {
            v.dollarcardviewsi.background.setTint(Color.parseColor("#13B167"))
            v.dollarcardviewtextsi.setTextColor(resources.getColor(R.color.white))

            v.poundcardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.poundcardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            v.eurocardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.eurocardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            v.pakistanicardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.pakistanicardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            v.chinescardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.chinescardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            currency="$"
            pref_object.setcurrecnyinfo(currency)
        }
        v.eurocardviewsi.setOnClickListener {
            v.eurocardviewsi.background.setTint(Color.parseColor("#13B167"))
            v.eurocardviewtextsi.setTextColor(resources.getColor(R.color.white))

            v.poundcardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.poundcardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            v.dollarcardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.dollarcardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            v.pakistanicardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.pakistanicardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            v.chinescardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.chinescardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            currency="€"
            pref_object.setcurrecnyinfo(currency)
        }
        v.chinescardviewsi.setOnClickListener {
            v.chinescardviewsi.background.setTint(Color.parseColor("#13B167"))
            v.chinescardviewtextsi.setTextColor(resources.getColor(R.color.white))

            v.poundcardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.poundcardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            v.dollarcardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.dollarcardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            v.pakistanicardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.pakistanicardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            v.eurocardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
            v.eurocardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            currency="¥"
            pref_object.setcurrecnyinfo(currency)
        }
        return v
    }

    private fun setcurrency(v: View) {
        when(currency)
        {
            "Rs"->
            {
                v.pakistanicardviewsi.background.setTint(Color.parseColor("#13B167"))
                v.pakistanicardviewtextsi.setTextColor(resources.getColor(R.color.white))

                v.poundcardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.poundcardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
                v.eurocardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.eurocardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
                v.dollarcardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.dollarcardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
                v.chinescardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.chinescardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            }
            "$"->
            {
                v.dollarcardviewsi.background.setTint(Color.parseColor("#13B167"))
                v.dollarcardviewtextsi.setTextColor(resources.getColor(R.color.white))

                v.poundcardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.poundcardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
                v.eurocardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.eurocardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
                v.pakistanicardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.pakistanicardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
                v.chinescardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.chinescardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            }
            "€"->
            {
                v.eurocardviewsi.background.setTint(Color.parseColor("#13B167"))
                v.eurocardviewtextsi.setTextColor(resources.getColor(R.color.white))

                v.poundcardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.poundcardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
                v.dollarcardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.dollarcardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
                v.pakistanicardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.pakistanicardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
                v.chinescardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.chinescardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))

            }
            "£"->
            {
                v.poundcardviewsi.background.setTint(Color.parseColor("#13B167"))
                v.poundcardviewtextsi.setTextColor(resources.getColor(R.color.white))

                v.eurocardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.eurocardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
                v.dollarcardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.dollarcardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
                v.pakistanicardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.pakistanicardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
                v.chinescardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.chinescardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))

            }
            "¥"->
            {
                v.chinescardviewsi.background.setTint(Color.parseColor("#13B167"))
                v.chinescardviewtextsi.setTextColor(resources.getColor(R.color.white))

                v.poundcardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.poundcardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
                v.dollarcardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.dollarcardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
                v.pakistanicardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.pakistanicardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
                v.eurocardviewsi.background.setTint(Color.parseColor("#FFFFFF"))
                v.eurocardviewtextsi.setTextColor(resources.getColor(R.color.colorAccent))
            }
        }

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment setting_fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            setting_fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}