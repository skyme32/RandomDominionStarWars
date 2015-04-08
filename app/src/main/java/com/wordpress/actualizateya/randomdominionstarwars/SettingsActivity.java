package com.wordpress.actualizateya.randomdominionstarwars;

import android.annotation.TargetApi;
import android.os.Build;
import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;


public class SettingsActivity extends PreferenceActivity {
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prepareLayout();
    }

    private void prepareLayout() {
        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
        View content = root.getChildAt(0);
        LinearLayout toolbarContainer = (LinearLayout) View.inflate(this, R.layout.activity_prefs, null);

        root.removeAllViews();
        toolbarContainer.addView(content);
        root.addView(toolbarContainer);

        mToolBar = (Toolbar) toolbarContainer.findViewById(R.id.toolbar);
        mToolBar.setTitle(getTitle());
        mToolBar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onBuildHeaders(List<Header> target) {
        super.onBuildHeaders(target);
        loadHeadersFromResource(R.xml.headers, target);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected boolean isValidFragment(String fragmentName) {
        return fragmentName.equals(PrefsFragment.class.getName());
    }
}
