package com.harnet69.letsexploreit.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.core.content.edit

class PrefsHelper {
    companion object {
        private const val UPD_TIME = "Update time"
        private const val IS_ABOUT_SHOWED = "Is about showed"
        private var prefs: SharedPreferences? = null

        @Volatile
        private var instance: PrefsHelper? = null
        private val LOCK = Any()

        operator fun invoke(context: Context): PrefsHelper = instance ?: synchronized(
            LOCK
        ) {
            instance ?: buildHelper(context).also {
                instance = it
            }
        }

        private fun buildHelper(context: Context): PrefsHelper {
            prefs = PreferenceManager.getDefaultSharedPreferences(context)

            return PrefsHelper()
        }
    }

    // save current time to SharedPreferences
    fun saveTimeOfUpd(time: Long) {
        /** requires to add to the app gradle file
         * kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
         */
        prefs?.edit(commit = true) {
            putLong(UPD_TIME, time)
        }
    }

    //getLastUpdateTime
    fun getLastUpdateTime(): Long? {
        return prefs?.getLong(UPD_TIME, 0)
    }

    // set is About app was showed
    fun setIsAboutShowed(isShowed: Boolean) {
        prefs?.edit(commit = true) {
            putBoolean(IS_ABOUT_SHOWED, isShowed)
        }
    }

    // get is About app was showed
    fun getIsAboutShowed() = prefs?.getBoolean(IS_ABOUT_SHOWED, false)

    // get a value of paid_version settings
    fun getIsPaidVersion() = prefs?.getString("paid_version", "")

    // get a value of api_parse_delaying settings
    fun getApiParseDelaying() = prefs?.getString("api_parse_delaying", "")

    // get a value of quantity day of history storing settings
    fun getHistoryKeepingDays() = prefs?.getString("storing_history_days", "")

    // get is new group member notification On/Off
    fun getIsNewMemberNotification() = prefs?.getBoolean("new_member_notification_preference", true)

    // get is SMS sending On/Off
    fun getIsSmsSendingAllowed() = prefs?.getBoolean("sms_sending", false)
}