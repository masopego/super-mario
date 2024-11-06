package com.penagomez.supermario.data.store;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

import com.penagomez.supermario.R;

import java.util.Locale;

public class PreferencesFragment extends PreferenceFragmentCompat {
    private final String SPANISH_LOCALE = "es";
    private final String ENGLISH_LOCALE = "en";


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootkey) {
        setPreferencesFromResource(R.xml.preferences, rootkey);

        SwitchPreferenceCompat languagePreference = findPreference("language_preference");

        if (languagePreference != null) {
            languagePreference.setOnPreferenceChangeListener((preference, newValue) -> {
                System.out.println(newValue);
                boolean isEnglish = (Boolean) newValue;
                setLocale(isEnglish ? ENGLISH_LOCALE : SPANISH_LOCALE);
                return true;
            });
        }

    }


    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);

        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());

        // Recargar la actividad principal para aplicar el cambio de idioma
        requireActivity().recreate();
    }


}
