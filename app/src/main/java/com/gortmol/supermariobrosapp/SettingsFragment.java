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

/**
 * Fragment that manages the settings of the app, particularly the language switch functionality.
 */
public class SettingsFragment extends PreferenceFragmentCompat implements Preference.OnPreferenceChangeListener {

    /**
     * Initializes the preferences from the specified XML resource file.
     *
     * @param savedInstanceState If the fragment is being re-created from a previous saved state, this is the state.
     * @param rootKey            The preference hierarchy root key.
     */
    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        // Load preferences from the XML resource
        setPreferencesFromResource(R.xml.fragment_settings, rootKey);

        // Get reference to the language switch preference
        SwitchPreferenceCompat switchPreference = findPreference("language_switch");

        // Ensure that the preference is not null before setting the listener
        assert switchPreference != null;

        // Set the onPreferenceChangeListener to detect changes in switch preference
        switchPreference.setOnPreferenceChangeListener(this);
    }

    /**
     * Called when a preference is changed by the user.
     *
     * @param preference The preference that was changed.
     * @param newValue   The new value of the preference.
     * @return true to update the state of the preference with the new value.
     */
    @Override
    public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
        // Check if the changed preference is the language switch
        if (preference.getKey().equals("language_switch")) {
            boolean languageSwitch = (boolean) newValue;  // Cast newValue to boolean

            LocaleListCompat appLocales;
            if (languageSwitch) {
                // Set application locale to English if switch is turned on
                appLocales = LocaleListCompat.forLanguageTags("en");
                // Show a success Toast for language change
            } else {
                // Set application locale to Spanish if switch is turned off
                appLocales = LocaleListCompat.forLanguageTags("es");
                // Show a success Toast for language change
            }
            AppCompatDelegate.setApplicationLocales(appLocales);
            Toast.makeText(getActivity(), R.string.language_changed_successfully, Toast.LENGTH_SHORT).show();
            return true;  // Indicate that the preference value was updated
        }
        return false;  // Preference change was not handled
    }
}
