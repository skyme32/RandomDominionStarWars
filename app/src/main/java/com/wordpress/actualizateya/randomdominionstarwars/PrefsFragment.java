package com.wordpress.actualizateya.randomdominionstarwars;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by xisberto on 08/11/14.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class PrefsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String category = getArguments().getString("category");
        if (category != null) {
            if (category.equals(getString(R.string.category_general))) {
                addPreferencesFromResource(R.xml.opciones);
            } else if (category.equals(getString(R.string.category_advanced))) {
                //addPreferencesFromResource(R.xml.prefs_advanced);
            }
        }
    }
}
