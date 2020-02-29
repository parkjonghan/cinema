package com.kptech.cinema

import android.content.Context
import android.content.SharedPreferences

object MySharedPref {


    val PREFS_FILENAME = "prefs"
    val PREFS_LIKE_CNT = "likeCnt"
    val PREFS_DISLIKE_CNT = "dislikeCnt"
    val PREFS_LIKE_BTN_STATUS = "likeBtnStatus"


    private fun getPref(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)
    }

    //For LikeCntText
    fun SavePrefLikeCntText(context: Context, value: String?) {
        getPref(context).edit().putString(PREFS_LIKE_CNT, value).apply()
    }

    fun LoadPrefLikeCntText(context: Context): String? {
        return getPref(context).getString(PREFS_LIKE_CNT, "  50")
    }

    //For DislikeCntText
    fun LoadPrefDislikeCntText(context: Context): String? {
        return getPref(context).getString(PREFS_DISLIKE_CNT, "  50")
    }

    fun SavePrefDislikeCntText(context: Context, value: String?) {
        getPref(context).edit().putString(PREFS_DISLIKE_CNT, value).apply()
    }

    //For LikeButtonStatus
    fun LoadPrefLikeBtnStatus(context: Context): Int {
        return getPref(context).getInt(PREFS_LIKE_BTN_STATUS, -1)
    }

    fun SavePrefLikeBtnStatus(context: Context, value: Int) {
        getPref(context).edit().putInt(PREFS_LIKE_BTN_STATUS, value).apply()
    }
}