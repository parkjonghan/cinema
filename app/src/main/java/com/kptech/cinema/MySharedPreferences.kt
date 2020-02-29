package com.kptech.cinema

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(context: Context) {

    val PREFS_FILENAME = "prefs"
    val PREFS_LIKE_CNT = "likeCnt"
    val PREFS_DISLIKE_CNT = "dislikeCnt"
    val PREFS_LIKE_BTN_STATUS ="likeBtnStatus"

    val prefs : SharedPreferences = context.getSharedPreferences(PREFS_FILENAME,Context.MODE_PRIVATE)

    var myLikeCntText  : String?
        get() = prefs.getString(PREFS_LIKE_CNT,"  50")
        set(value) = prefs.edit().putString(PREFS_LIKE_CNT,value).apply()

    var myDislikeCntText  : String?
        get() = prefs.getString(PREFS_DISLIKE_CNT,"  50")
        set(value) = prefs.edit().putString(PREFS_DISLIKE_CNT,value).apply()

    var myLikeBntStatus  : Int
        get() = prefs.getInt(PREFS_LIKE_BTN_STATUS,-1)
        set(value) = prefs.edit().putInt(PREFS_LIKE_BTN_STATUS,value).apply()
}