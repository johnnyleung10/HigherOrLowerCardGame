package com.example.higherorlowercards

import android.content.Context


class MyPreference(context : Context) {

    val PREFERENCE_NAME = "CardGameSave"
    val PREFERENCE_BANK_BALANCE = "BankBalance"
    val PREFERENCE_LAST_USED = "LastUsed"

    val preference = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun getBankBal() : Int{
        return preference.getInt(PREFERENCE_BANK_BALANCE, 100)
    }

    fun changeBankBal(balance: Int){
        val editor = preference.edit()
        editor.putInt(PREFERENCE_BANK_BALANCE, 100)
        editor.apply()
    }

    fun getLastUsed() : String?{
        return preference.getString(PREFERENCE_LAST_USED,"none")
    }

    fun changeLastUsed(date : String){
        val editor = preference.edit()
        editor.putString(PREFERENCE_LAST_USED, date)
        editor.apply()
    }

}