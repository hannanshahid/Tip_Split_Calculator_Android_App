package com.example.tip_calculator.prefrences

import android.content.Context

class currency_pref(context:Context) {
    val PREFERENCE_NAME="currencyprefrence"
    val currencyinfo="currencyinfo"
    val startinfo="startinfo"
    val name="name"

    val p=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)

    fun getstartinfostatus():Boolean
    {
        return p.getBoolean(startinfo,false)
    }
    fun setstartinfostatus(status:Boolean)
    {
        val e=p.edit()
        e.putBoolean(startinfo,status)
        e.apply()
    }

    fun getcurrencyinfo(): String?
    {
        return p.getString(currencyinfo,"$")
    }
    fun setcurrecnyinfo(Pname:String)
    {
        val e=p.edit()
        e.putString(currencyinfo,Pname)
        e.apply()
    }
    fun getname(): String?
    {
        return p.getString(name,"")
    }
    fun setname(Pname:String)
    {
        val e=p.edit()
        e.putString(name,Pname)
        e.apply()
    }


}