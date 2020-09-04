package com.example.tip_calculator.fragment

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.tip_calculator.R
import com.example.tip_calculator.prefrences.currency_pref
import kotlinx.android.synthetic.main.cutom_tip_layout.*
import kotlinx.android.synthetic.main.cutom_tip_layout.view.*
import kotlinx.android.synthetic.main.fragment_tip_fragment.*
import kotlinx.android.synthetic.main.fragment_tip_fragment.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [tip_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class tip_fragment : Fragment() {
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
  var splitnum:Int=1
    var tippercent:Int=0
    var bill:Double=0.0
    var currency=""
    @SuppressLint("NewApi")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v= inflater.inflate(R.layout.fragment_tip_fragment, container, false)
        setcurrency(v!!)

     v.editTextbillamount.addTextChangedListener(object : TextWatcher
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
                     bill = price.toDouble()
                     calculate(bill, tippercent, splitnum)
                 } catch (e: Exception) {
                     Toast.makeText(context, "Bill Amount format incorrect", Toast.LENGTH_SHORT)
                         .show()
                 }
             }
             else
             {
                 bill=0.0
                 calculate(bill,tippercent,splitnum)
             }


         }

     })
        v.plusbutton.setOnClickListener {
            splitnum++
            v.splitnumber.text = splitnum.toString()
            if(bill>0.0)
            {
                calculate(bill, tippercent, splitnum)
            }
        }
        v.minusbutton.setOnClickListener {
            if (splitnum>1)
            {
                splitnum--
                v.splitnumber.text=splitnum.toString()
                if(bill>0.0)
                {
                    calculate(bill,tippercent,splitnum)
                }
            }
        }
        v.fivecardview.setOnClickListener {
            tippercent=5
          v.fivecardview.background.setTint(Color.parseColor("#13B167"))
            v.fivecardviewtext.setTextColor(resources.getColor(R.color.white))

            v.tencardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.tencardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            v.fiftencardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.fiftencardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            v.twintycardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.twintycardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            v.customcardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.customcardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            if(bill>0.0)
            {
                calculate(bill,tippercent,splitnum)
            }
        }
        v.tencardview.setOnClickListener {
            tippercent=10
            v.tencardview.background.setTint(Color.parseColor("#13B167"))
            v.tencardviewtext.setTextColor(resources.getColor(R.color.white))

            v.fivecardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.fivecardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            v.fiftencardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.fiftencardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            v.twintycardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.twintycardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            v.customcardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.customcardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            if(bill>0.0)
            {
                calculate(bill,tippercent,splitnum)
            }
        }
        v.fiftencardview.setOnClickListener {
            tippercent=15
            v.fiftencardview.background.setTint(Color.parseColor("#13B167"))
            v.fiftencardviewtext.setTextColor(resources.getColor(R.color.white))

            v.tencardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.tencardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            v.fivecardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.fivecardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            v.twintycardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.twintycardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            v.customcardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.customcardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            if(bill>0.0)
            {
                calculate(bill,tippercent,splitnum)
            }
        }
        v.twintycardview.setOnClickListener {
            tippercent=20
            v.twintycardview.background.setTint(Color.parseColor("#13B167"))
            v.twintycardviewtext.setTextColor(resources.getColor(R.color.white))

            v.tencardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.tencardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            v.fiftencardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.fiftencardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            v.fivecardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.fivecardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            v.customcardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.customcardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            if(bill>0.0)
            {
                calculate(bill,tippercent,splitnum)
            }
        }
        v.customcardview.setOnClickListener {
            v.customcardview.background.setTint(Color.parseColor("#13B167"))
            v.customcardviewtext.setTextColor(resources.getColor(R.color.white))

            v.tencardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.tencardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            v.fiftencardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.fiftencardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            v.twintycardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.twintycardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            v.fivecardview.background.setTint(Color.parseColor("#FFFFFF"))
            v.fivecardviewtext.setTextColor(resources.getColor(R.color.colorAccent))

            val builder = AlertDialog.Builder(context,R.style.tipDialog)
            builder.setTitle("Custom Tip Percentage")
            builder.setCancelable(false)

            val l = LayoutInflater.from(context)
            val x = l.inflate(R.layout.cutom_tip_layout, null)
            builder.setView(x)
            builder.setPositiveButton("Ok", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {}
            })
            builder.setNegativeButton("Cancel", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {}
            })


            val a = builder.create()
            a.show()
            if(tippercent>0)
            {
                x.customtip.setText("$tippercent")
            }

            a.setCanceledOnTouchOutside(false)
            var bp: Button = a.getButton(AlertDialog.BUTTON_POSITIVE)
            var bn: Button = a.getButton(AlertDialog.BUTTON_NEGATIVE)
            bp.setOnClickListener {
                if(x.customtip.text.toString().toInt()>100)
                {
                    x.customtip.setError("Percentage Always Less Then 100")
                    x.customtip.requestFocus()
                }
                else
                {
                    tippercent = x.customtip.text.toString().toInt()
                    if (bill > 0.0) {
                        calculate(bill, tippercent, splitnum)
                    }
                    a.dismiss()
                }

            }
            bn.setOnClickListener {
               a.dismiss()
                v.customcardview.background.setTint(Color.parseColor("#FFFFFF"))
                v.customcardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
                v.tencardview.background.setTint(Color.parseColor("#FFFFFF"))
                v.tencardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
                v.fiftencardview.background.setTint(Color.parseColor("#FFFFFF"))
                v.fiftencardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
                v.twintycardview.background.setTint(Color.parseColor("#FFFFFF"))
                v.twintycardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
                v.fivecardview.background.setTint(Color.parseColor("#FFFFFF"))
                v.fivecardviewtext.setTextColor(resources.getColor(R.color.colorAccent))
            }


        }

         return v
    }

    private fun setcurrency(v: View) {
        var pref_object=currency_pref(context!!)
        currency=pref_object.getcurrencyinfo()!!
        v.totalperpersontextview.text = "${currency}0.0"
        v.billtextview.text = "${currency}0.0"
        v.tiptextview.text = "${currency}0.0"
        v.textViewrupeelogo.text="$currency"

    }

    override fun onResume() {
        super.onResume()
        var pref_object=currency_pref(context!!)
        currency=pref_object.getcurrencyinfo()!!
        totalperpersontextview.text = "${currency}0.0"
        billtextview.text = "${currency}0.0"
        tiptextview.text = "${currency}0.0"
        textViewrupeelogo.text="$currency"
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if(hidden)
        {}
        else
        {
            var pref_object=currency_pref(context!!)
            currency=pref_object.getcurrencyinfo()!!
            totalperpersontextview.text = "${currency}0.0"
            billtextview.text = "${currency}0.0"
            tiptextview.text = "${currency}0.0"
            textViewrupeelogo.text="$currency"
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calculate(bi: Double, tip: Int, spnum: Int)
    {
        try {
            if (bi > 0)
            {
                if (tip > 0)
                {
                    var totalExpense = (100 + tip) / 100.toDouble()
                    totalExpense = totalExpense * bi
                    var individualExpense = totalExpense / spnum
                    //Toast.makeText(context,"bill:$bi,tippercent$tip,split$spnum....total$totalExpense\n\nindividual$individualExpense",Toast.LENGTH_LONG).show()

                    totalperpersontextview.text = "$currency${String.format("%.2f", individualExpense)}"
                    var tipamount = totalExpense - bi
                    var perpersontip = tipamount / spnum
                    tiptextview.text = "$currency${String.format("%.2f", perpersontip)}"
                    var perpersonbill = bill / spnum
                    billtextview.text = "$currency${String.format("%.2f", perpersonbill)}"
                }
                else
                {
                    var totalperperson=bi/spnum
                    totalperpersontextview.text = "${currency}${String.format("%.2f", totalperperson)}"
                    billtextview.text = "${currency}${String.format("%.2f", totalperperson)}"
                    tiptextview.text = "${currency}0.0"
                }
            }
            else
            {
                totalperpersontextview.text = "${currency}0.0"
                billtextview.text = "${currency}0.0"
                tiptextview.text = "${currency}0.0"
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
         * @return A new instance of fragment tip_fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            tip_fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}