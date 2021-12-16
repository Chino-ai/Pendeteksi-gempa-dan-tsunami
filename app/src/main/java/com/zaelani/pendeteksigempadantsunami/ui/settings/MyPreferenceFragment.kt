package com.zaelani.pendeteksigempadantsunami.ui.settings

import android.content.SharedPreferences
import android.os.Bundle
import androidx.preference.CheckBoxPreference
import androidx.preference.EditTextPreference

import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import androidx.work.*
import com.mapbox.mapboxsdk.style.expressions.Expression.string
import com.zaelani.pendeteksigempadantsunami.R
import com.zaelani.pendeteksigempadantsunami.utils.NOTIFICATION_CHANNEL_ID
import java.util.concurrent.TimeUnit

class MyPreferenceFragment : PreferenceFragmentCompat(),SharedPreferences.OnSharedPreferenceChangeListener {
    private lateinit var notif : String
    private lateinit var notifGempa : CheckBoxPreference
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences,rootKey)
        val prefNotification = findPreference<CheckBoxPreference>(getString(R.string.pref_key_notify))
        prefNotification?.setOnPreferenceChangeListener { _, newValue ->
            val channelName = getString(R.string.pref_key_notify)
            if (newValue as Boolean) {
                val data = Data.Builder()
                    .putString(NOTIFICATION_CHANNEL_ID, channelName)
                    .build()

                val periodicTimeWorkRequest =
                    PeriodicWorkRequest.Builder(NotificationTerkiniWorker::class.java,
                        30,
                        TimeUnit.SECONDS,
                    )

                        .setInputData(data)
                        .build()
                WorkManager.getInstance(requireContext())
                    .enqueue(periodicTimeWorkRequest)

            }

            true

        }
        init()
        setSummaries()

    }

    private fun setSummaries() {
        val sh = preferenceManager.sharedPreferences

        notifGempa.isChecked = sh.getBoolean(notif, false)
    }

    private fun init() {

        notif = resources.getString(R.string.pref_key_notify)


        notifGempa = findPreference<CheckBoxPreference>(notif) as CheckBoxPreference
    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {

        if (key == notif) {
            notifGempa.isChecked = sharedPreferences.getBoolean(notif, false)
        }
    }

}