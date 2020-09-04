package com.example.tip_calculator.fragment

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.tip_calculator.R
import com.example.tip_calculator.prefrences.currency_pref
import kotlinx.android.synthetic.main.custom_discount_layout.view.*
import kotlinx.android.synthetic.main.cutom_tip_layout.view.*
import kotlinx.android.synthetic.main.fragment_discountfragment.*
import kotlinx.android.synthetic.main.fragment_discountfragment.view.*
import kotlinx.android.synthetic.main.fragment_tip_fragment.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [discountfragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class discountfragment : Fragment() {
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
    var dispercent:Int=0
    var amount:Double=0.0
    var currency=""
    @SuppressLint("NewApi")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v=inflater.inflate(R.layout.fragment_discountfragment, container, false)

            setcurrency(v!!)


        v.fivecardviewdis.setOnClickListener {
           dispercent=5
            v.fivecardviewdis.background.setTint(Color.parseColor("#13B167"))
            v.fivecardviewtextdis.setTextColor(resources.getColor(R.color.white))

            v.tencardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.tencardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            v.fiftencardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.fiftencardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            v.twintycardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.twintycardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            v.customcardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.customcardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            if(amount>0.0)
            {
                calculate(amount,dispercent)
            }
        }
        v.tencardviewdis.setOnClickListener {
           dispercent=10
            v.tencardviewdis.background.setTint(Color.parseColor("#13B167"))
            v.tencardviewtextdis.setTextColor(resources.getColor(R.color.white))

            v.fivecardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.fivecardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            v.fiftencardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.fiftencardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            v.twintycardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.twintycardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            v.customcardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.customcardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            if(amount>0.0)
            {
                calculate(amount,dispercent)
            }
        }
        v.fiftencardviewdis.setOnClickListener {
            dispercent=15
            v.fiftencardviewdis.background.setTint(Color.parseColor("#13B167"))
            v.fiftencardviewtextdis.setTextColor(resources.getColor(R.color.white))

            v.tencardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.tencardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            v.fivecardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.fivecardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            v.twintycardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.twintycardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            v.customcardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.customcardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            if(amount>0.0)
            {
                calculate(amount,dispercent)
            }
        }
        v.twintycardviewdis.setOnClickListener {
            dispercent=20
            v.twintycardviewdis.background.setTint(Color.parseColor("#13B167"))
            v.twintycardviewtextdis.setTextColor(resources.getColor(R.color.white))

            v.tencardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.tencardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            v.fiftencardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.fiftencardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            v.fivecardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.fivecardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            v.customcardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.customcardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            if(amount>0.0)
            {
                calculate(amount,dispercent)
            }
        }
        v.customcardviewdis.setOnClickListener {
            v.customcardviewdis.background.setTint(Color.parseColor("#13B167"))
            v.customcardviewtextdis.setTextColor(resources.getColor(R.color.white))

            v.tencardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.tencardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            v.fiftencardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.fiftencardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            v.twintycardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.twintycardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            v.fivecardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
            v.fivecardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))

            val builder = AlertDialog.Builder(context,R.style.tipDialog)
            builder.setTitle("Custom Discount Percentage")
            builder.setCancelable(false)

            val l = LayoutInflater.from(context)
            val x = l.inflate(R.layout.custom_discount_layout, null)
            builder.setView(x)
            builder.setPositiveButton("Ok", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {}
            })
            builder.setNegativeButton("Cancel", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {}
            })


            val a = builder.create()
            a.show()
            if(dispercent>0)
            {
                x.customdiscount.setText("$dispercent")
            }

            a.setCanceledOnTouchOutside(false)
            var bp: Button = a.getButton(AlertDialog.BUTTON_POSITIVE)
            var bn: Button = a.getButton(AlertDialog.BUTTON_NEGATIVE)
            bp.setOnClickListener {
                if(x.customdiscount.text.toString().toInt()>100)
                {
                    x.customdiscount.setError("Percentage Always Less Then 100")
                    x.customdiscount.requestFocus()
                }
                else
                {
                    dispercent = x.customdiscount.text.toString().toInt()
                    if (amount > 0.0) {
                        calculate(amount,dispercent)
                    }
                    a.dismiss()
                }

            }
            bn.setOnClickListener {
                a.dismiss()
                v.customcardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
                v.customcardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
                v.tencardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
                v.tencardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
                v.fiftencardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
                v.fiftencardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
                v.twintycardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
                v.twintycardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
                v.fivecardviewdis.background.setTint(Color.parseColor("#FFFFFF"))
                v.fivecardviewtextdis.setTextColor(resources.getColor(R.color.colorAccent))
            }


        }
        v.editTextbillamountdis.addTextChangedListener(object : TextWatcher
        {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.toString().length!=0)
                {

                    try {
                        var price = s.toString()
                        amount = price.toDouble()
                        calculate(amount,dispercent)
                    } catch (e: Exception) {
                        Toast.makeText(context, "Bill Amount format incorrect", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
                else
                {
                    amount=0.0
                    calculate(amount,dispercent)
                }


            }

        })
        return v
    }

    private fun setcurrency(v: View) {
        var pref_object= currency_pref(context!!)
        currency=pref_object.getcurrencyinfo()!!
        v.textViewrupeelogodis.text=currency
        v.discountedamout.text="${currency}0.00"

    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if(hidden)
        {

        }
        else
        {
            var pref_object= currency_pref(context!!)
            currency=pref_object.getcurrencyinfo()!!
            textViewrupeelogodis.text=currency
            discountedamout.text="${currency}0.00"
        }
    }

    override fun onResume() {
        super.onResume()
        var pref_object= currency_pref(context!!)
        currency=pref_object.getcurrencyinfo()!!
        textViewrupeelogodis.text=currency
        discountedamout.text="${currency}0.00"
    }

    private fun calculate(amount: Double, dispercent: Int) {
        try {
            if(amount>0.0) {
                var discount = amount * dispercent.toString().toDouble()
                var divid = discount / 100.0
                var discamount = amount - divid
                discountedamout.text = "$currency${String.format("%.2f", discamount)}"
            }
            else
            {
                discountedamout.text="${currency}0.00"
            }
        }
        catch (e:Exception)
        {
            Toast.makeText(context,"Something went wrong..Try again please!", Toast.LENGTH_LONG).show()
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment discountfragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            discountfragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}