package com.example.examprojectapp.utils

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Preferences @Inject constructor(@ApplicationContext context: Context) {
    private val sharedPref: SharedPreferences = context.getSharedPreferences(
        "pr",
        Context.MODE_PRIVATE
    )

    fun isBoardingShow(): Boolean {
        return sharedPref.getBoolean("boarding_show", false)
    }

    fun setBoardingShow(isShown: Boolean) {
        sharedPref.edit().putBoolean("boarding_show", isShown).apply()
    }
}

//Для сохранения онбоардинга
// был ли показан если был то больше не
// будет показан если
// не был то будет показыватся
//надо всегда использовать другие методы надо изучитьь авы авы