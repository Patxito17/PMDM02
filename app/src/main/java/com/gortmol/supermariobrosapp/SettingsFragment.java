package com.gortmol.supermariobrosapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreferenceCompat;

import java.util.Locale;


public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.fragment_settings, rootKey);

        SwitchPreferenceCompat languageSwitch = findPreference("language_switch");

        if (languageSwitch != null) {
            languageSwitch.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    boolean isSpanish = (Boolean) newValue;

                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
                    sharedPreferences.edit().putBoolean("language_is_spanish", isSpanish).apply();

                    changeLanguage(isSpanish ? "es" : "en");
                    return true;
                }
            });
        }

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        boolean isSpanish = sharedPreferences.getBoolean("language_is_spanish", false);
        languageSwitch.setChecked(isSpanish);
    }

    private void changeLanguage(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.setLocale(locale);

        Context context = requireContext().createConfigurationContext(config);

        requireActivity().applyOverrideConfiguration(config);
        requireActivity().recreate();
    }
}

