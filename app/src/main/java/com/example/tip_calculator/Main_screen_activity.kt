package com.example.tip_calculator

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.tip_calculator.adapters.Menuadapter
import com.example.tip_calculator.fragment.aboutus_fragment
import com.example.tip_calculator.fragment.discountfragment
import com.example.tip_calculator.fragment.setting_fragment
import com.example.tip_calculator.fragment.tip_fragment
import com.example.tip_calculator.prefrences.currency_pref
import kotlinx.android.synthetic.main.activity_main_screen_activity.*
import kotlinx.android.synthetic.main.duo_view_footer.*
import kotlinx.android.synthetic.main.duo_view_header.view.*
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle
import java.util.*
import kotlin.collections.ArrayList

class Main_screen_activity : AppCompatActivity(), DuoMenuView.OnMenuClickListener {
    lateinit var tollbar: Toolbar
    lateinit var duomenuadpater:Menuadapter
    lateinit var  dlayout: DuoDrawerLayout
    lateinit var dtoggle: DuoDrawerToggle
    lateinit var currentfrag: Fragment
     var tipfrag= tip_fragment()
      var disfrag=discountfragment()
    var setingfrag=setting_fragment()
    var aboutusfrag=aboutus_fragment()
    public val mTitles: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen_activity)
        mTitles.add("Tip & Split")
        mTitles.add("Discount")
        mTitles.add("Setting's")
        mTitles.add("About us")

        // set drawe
        dlayout=findViewById(R.id.drawer)
        dtoggle= DuoDrawerToggle(this,dlayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        dlayout.setDrawerListener(dtoggle)
        dtoggle.syncState()
        ////////////


        var fm=supportFragmentManager
        fm.beginTransaction().add(R.id.containers,aboutusfrag,"4").commit()
        fm.beginTransaction().hide(aboutusfrag).commit()
        fm.beginTransaction().add(R.id.containers,setingfrag,"3").commit()
        fm.beginTransaction().hide(setingfrag).commit()
        fm.beginTransaction().add(R.id.containers,disfrag,"2").commit()
        fm.beginTransaction().hide(disfrag).commit()
        fm.beginTransaction().add(R.id.containers,tipfrag,"1").commit()
        currentfrag=tipfrag

        handleMenu()
        duomenuadpater.setViewSelected(0,true)
        setheadername()
        textViewtoolbar.setText("Tipsy")
        imageViewfacebook.setOnClickListener {
            openfacebook()

        }
        imageViewwhatsapp.setOnClickListener {
            openwhatsapp()
        }
        imageViewinsta.setOnClickListener {
            openinsta()
        }
        imageViewlinkdin.setOnClickListener {
            oopenlinkdin()
        }

    }

    override fun onBackPressed() {
        val transaction =
            supportFragmentManager.beginTransaction().hide(currentfrag).show(tipfrag).commit()
        currentfrag = tipfrag
        textViewtoolbar.setText("Tipsy")
        duomenuadpater.setViewSelected(0, true)
        setheadername()
        dlayout.closeDrawer()
    }
    private fun setheadername() {

        var pref_obj= currency_pref(this)
        dlayout.duo_view_header_text_title.text = pref_obj.getname().toString().toUpperCase(Locale.ROOT)
        dlayout.duo_view_header_text_title_currency.text="Currency: "+pref_obj.getcurrencyinfo().toString()
    }
    private fun handleMenu()
    {
        duomenuadpater = Menuadapter(mTitles)
        duomenu.setOnMenuClickListener(this)
        duomenu.adapter = duomenuadpater
    }
    private fun goToFragment(fragment: Fragment) {

        val transaction =
            supportFragmentManager.beginTransaction().hide(currentfrag).show(fragment).commit()
        currentfrag=fragment

    }

    private fun oopenlinkdin() {
        var intent = Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://hannan-shahid-a67798161"))
        val packageManager: PackageManager = getPackageManager()
        val list =
            packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
        if (list.isEmpty()) {
            intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://www.linkedin.com/profile/view?id=hannan-shahid-a67798161")
            )
        }
        startActivity(intent)
    }

    private fun openinsta() {
        try {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://instagram.com/_u/hannan.shahid0/")
            intent.setPackage("com.instagram.android")
            startActivity(intent)
        } catch (anfe: ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/hannan.shahid0/")
                )
            )
        }
    }

    private fun openwhatsapp() {
        val url = "https://api.whatsapp.com/send?phone=$+923341617255"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    private fun openfacebook() {
        val facebookUrl = "www.facebook.com/hannan.shahid.73/"
        val facebookID = "2816510415142341"

        try {
            val versionCode: Int = getApplicationContext().getPackageManager()
                .getPackageInfo("com.facebook.katana", 0).versionCode
            if (!facebookID.isEmpty()) {
                // open the Facebook app using facebookID (fb://profile/facebookID or fb://page/facebookID)
                val uri = Uri.parse("fb://page/$facebookID")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            } else if (versionCode >= 3002850 && !facebookUrl.isEmpty()) {
                // open Facebook app using facebook url
                val uri =
                    Uri.parse("fb://facewebmodal/f?href=$facebookUrl")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            } else {
                // Facebook is not installed. Open the browser
                val uri = Uri.parse(facebookUrl)
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
        } catch (e: PackageManager.NameNotFoundException) {
            // Facebook is not installed. Open the browser
            val uri = Uri.parse(facebookUrl)
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

    }

    override fun onOptionClicked(position: Int, objectClicked: Any?) {
        duomenuadpater.setViewSelected(position, true);
        if(position==0) {
            textViewtoolbar.setText("Tipsy")
        }
        else
        {
            textViewtoolbar.setText(mTitles[position])
        }
        // Navigate to the right fragment
        when (position) {
            0-> {
               goToFragment(tipfrag)

            }
            1->
            {
               goToFragment(disfrag)
            }
            2->
            {
                goToFragment(setingfrag)
            }
            3->
            {
                 goToFragment(aboutusfrag)
            }

        }

        // Close the drawer
        dlayout.closeDrawer()
    }

    override fun onHeaderClicked() {

    }

    override fun onFooterClicked() {
    }
}