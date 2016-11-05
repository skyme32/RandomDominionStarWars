package com.wordpress.actualizateya.randomdominionstarwars;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.wordpress.actualizateya.randomdominionstarwars.Cards.Card;
import com.wordpress.actualizateya.randomdominionstarwars.Tags.InteractiveArrayAdapter;
import com.wordpress.actualizateya.randomdominionstarwars.Tags.Model;

import java.util.ArrayList;

public class PrincipalTab extends AppCompatActivity implements OnTabSelectListener{

    //Constants
    private static final String URI = "http://labsk.net/index.php?PHPSESSID=rrvn4kqr0687vftuura39rpdi1&topic=25630.0";

    //Varibles
    ArrayList<Card> arrayCards = new ArrayList();
    ListView lv;
    InteractiveArrayAdapter plAdapter;
    ArrayList<Model> tagList;
    String[] an;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_tab);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);






        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_play) {


                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(R.string.title_dialog)
                .setMessage(R.string.desc_dialog)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton(R.string.no, null)
                .show();
    }

    @Override
    public void onTabSelected(@IdRes int tabId) {

        if (tabId == R.id.tab_play) {
            Toast.makeText(getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT).show();
        }

    }
}
