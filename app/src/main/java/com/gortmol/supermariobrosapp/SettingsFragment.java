package com.gortmol.supermariobrosapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;


public class SettingsFragment extends PreferenceFragmentCompat implements Preference.OnPreferenceChangeListener {

    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.fragment_settings, rootKey);
        SwitchPreferenceCompat switchPreference = findPreference("language_switch");

        assert switchPreference != null;
        switchPreference.setOnPreferenceChangeListener(this);

    }

    @Override
    public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
        if (preference.getKey().equals("language_switch")) {
            boolean languageSwitch = (boolean) newValue;

            if (languageSwitch) {
                LocaleListCompat appLocales = LocaleListCompat.forLanguageTags("en");
                AppCompatDelegate.setApplicationLocales(appLocales);
                Toast.makeText(getActivity(), R.string.language_changed_successfully, Toast.LENGTH_SHORT).show();
            } else {
                LocaleListCompat appLocales = LocaleListCompat.forLanguageTags("es");
                AppCompatDelegate.setApplicationLocales(appLocales);
                Toast.makeText(getActivity(), R.string.language_changed_successfully, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return false;
    }
}


