package com.example.motivation.infra

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class SecurityPreferences(applicationContext: Context) {
    val security: SharedPreferences =
        applicationContext.getSharedPreferences("", Context.MODE_PRIVATE)

    fun storeString(key: String, str: String) {
        security.edit { putString(key, str) }
    }

    fun getString(key: String): String {
        return security.getString(key, "") ?: ""
    }
}