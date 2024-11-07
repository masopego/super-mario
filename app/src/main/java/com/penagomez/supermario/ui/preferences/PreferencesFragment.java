package com.penagomez.supermario.ui.preferences;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

import com.penagomez.supermario.R;

import java.util.Locale;

/**
 * PreferencesFragment is a fragment responsible for displaying and handling user preferences.
 * It allows users to change language settings within the application.
 */
public class PreferencesFragment extends PreferenceFragmentCompat {
    // Constants for language codes
    private final String SPANISH_LOCALE = "es";
    private final String ENGLISH_LOCALE = "en";

    /**
     * Called when the fragment is created and preferences need to be loaded.
     * This method sets up the preferences from the XML file and sets up the language change listener.
     *
     * @param savedInstanceState The saved instance state, if any.
     * @param rootKey            The root key for the preferences (used for setting preferences in nested screens).
     */
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        // Load preferences from XML file
        setPreferencesFromResource(R.xml.preferences, rootKey);

        // Find the language preference switch
        SwitchPreferenceCompat languagePreference = findPreference("language_preference");

        if (languagePreference != null) {
            // Set listener to handle language change
            languagePreference.setOnPreferenceChangeListener((preference, newValue) -> {
                System.out.println(newValue);
                boolean isEnglish = (Boolean) newValue;
                setLocale(isEnglish ? ENGLISH_LOCALE : SPANISH_LOCALE);
                return true;
            });
        }
    }

    /**
     * Changes the app's locale and reloads the activity to apply the new language setting.
     *
     * @param languageCode The language code (either "es" for Spanish or "en" for English).
     */
    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);

        // Update the application's configuration with the new locale
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());

        // Reload the activity to apply the new language setting
        requireActivity().recreate();
    }

    /**
     * Called when the fragment starts. Sets the title of the action bar to "Character Detail".
     */
    @Override
    public void onStart() {
        super.onStart();
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.preferences);
        }
    }
}