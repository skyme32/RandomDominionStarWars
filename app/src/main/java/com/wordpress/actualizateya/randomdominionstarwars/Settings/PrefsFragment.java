package com.wordpress.actualizateya.randomdominionstarwars.Settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import com.wordpress.actualizateya.randomdominionstarwars.R;

/**
 *
 */
public class PrefsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.opciones);
    }

}