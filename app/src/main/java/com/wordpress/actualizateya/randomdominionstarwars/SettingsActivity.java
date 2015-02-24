package com.wordpress.actualizateya.randomdominionstarwars;

import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


public class SettingsActivity extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.opciones);
    }
}
