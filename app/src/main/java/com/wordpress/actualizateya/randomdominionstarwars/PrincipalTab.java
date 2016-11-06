package com.wordpress.actualizateya.randomdominionstarwars;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.wordpress.actualizateya.randomdominionstarwars.Cards.Card;
import com.wordpress.actualizateya.randomdominionstarwars.Cards.CardsAdapter;
import com.wordpress.actualizateya.randomdominionstarwars.Layouts.CardActivity;

import java.util.ArrayList;

public class PrincipalTab extends AppCompatActivity implements OnTabSelectListener, AdapterView.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    //Constants
    private static final String URI = "http://labsk.net/index.php?PHPSESSID=rrvn4kqr0687vftuura39rpdi1&topic=25630.0";

    private ListView lvCards;
    private CardsAdapter adapter;
    private String random;
    private ArrayList<Card> cards;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_tab);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Inicializamos las variables.
        adapter = new CardsAdapter(this, arrayOfCards());

        lvCards = (ListView) findViewById(R.id.listCard);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_main_swipe_refresh_layout);
        // Asignamos el Adapter al ListView, en este punto hacemos que el
        // ListView muestre los datos que queremos.
        lvCards.setAdapter(adapter);
        // Asignamos el Listener al ListView para cuando pulsamos sobre uno de
        // sus items.
        lvCards.setOnItemClickListener(this);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        // Bottom tab
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(this);
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(R.string.title_dialog)
                .setMessage(R.string.desc_dialog)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
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
            Toast.makeText(getApplicationContext(), "Play play", Toast.LENGTH_SHORT).show();
        } else {
            //∫Toast.makeText(getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRefresh() {
        if (bottomBar.getCurrentTabId() == R.id.tab_play) {
            refreshContent();
        }else {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(PrincipalTab.this, CardActivity.class);
        intent.putExtra("card", cards.get(i));
        startActivity(intent);
    }

    // this is just for demonstration, not real code!
    private void refreshContent() {

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                lvCards.setAdapter(adapter);
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 1500);
    }

    //Array que mete todas las cartas
    public ArrayList<Card> arrayOfCards () {
        //Recibir parametros de la activity anterior
        cards = new ArrayList<Card>();
        //Toast.makeText(this, "ParametrosActivity devolvió: " + l.get(0), Toast.LENGTH_LONG).show();

        String[] title = getResources().getStringArray(R.array.title);
        String[] desc = getResources().getStringArray(R.array.desc);
        String[] cost = getResources().getStringArray(R.array.cost);
        String[] image = getResources().getStringArray(R.array.image);
        String[] exp = getResources().getStringArray(R.array.expansion);

        //Toast.makeText(getApplication(),title[y]+","+desc[y]+","+cost[y]+","+image[y]+","+exp[y],Toast.LENGTH_LONG).show();
        for (int y = 0; y < title.length; y++) {
            cards.add(new Card(title[y],
                    exp[y],
                    getResources().getIdentifier("money" + cost[y], "drawable", getPackageName()),
                    getResources().getIdentifier(image[y], "drawable", getPackageName()),
                    desc[y]));

        }
        System.out.println(cards);
        return cards;
        //cards.add(new Card(title[y], exp[y], getResources().getIdentifier(image[y], "drawable", getPackageName()), getResources().getIdentifier("money" + cost[y], "drawable", getPackageName()), desc[y]));
    }

    public ArrayList<Integer> RandomToTenNumbers ( int size){
        //Sharedpreferences
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(PrincipalTab.this);
        Integer sizeRandom = Integer.parseInt(pref.getString("ncartas", "10"));
        //bucle trought all numbers
        int pos;
        int nCartas = size;
        ArrayList<Integer> arrNumbers = new ArrayList<>();
        for (int i = 0; i < sizeRandom; i++) {
            pos = (int) Math.floor(Math.random() * nCartas);
            while (arrNumbers.contains(pos)) {
                pos = (int) Math.floor(Math.random() * nCartas);
            }
            arrNumbers.add(pos);
        }
        return arrNumbers;
    }


    }
