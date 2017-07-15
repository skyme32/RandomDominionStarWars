package com.wordpress.actualizateya.randomdominionstarwars.Layouts;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.wordpress.actualizateya.randomdominionstarwars.Cards.Card;
import com.wordpress.actualizateya.randomdominionstarwars.Cards.CardListAdapter;
import com.wordpress.actualizateya.randomdominionstarwars.R;
import com.wordpress.actualizateya.randomdominionstarwars.Settings.SettingsActivity;

import java.util.ArrayList;

public class PrincipalTab extends AppCompatActivity implements OnTabSelectListener, AdapterView.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    //Constants
    private static final String URI = "http://labsk.net/index.php?PHPSESSID=rrvn4kqr0687vftuura39rpdi1&topic=25630.0";

    private ListView lvCards;
    private CardListAdapter adapter;
    private ArrayList<Card> cards;
    private ArrayList<Card> play_cards;
    private ArrayList<Card> category_cards;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private BottomBar bottomBar;
    private Integer sizeRandom;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_tab);

        arrayOfCards();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvCards = (ListView) findViewById(R.id.listCard);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_main_swipe_refresh_layout);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.bb_darkBackgroundColor, R.color.green);

        // Asignamos el Adapter al ListView, en este punto hacemos que el
        // ListView muestre los datos que queremos.
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                lvCards.setAdapter(new CardListAdapter(PrincipalTab.this, cards));
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 50);

        // Asignamos el Listener al ListView para cuando pulsamos sobre uno de
        // sus items.
        lvCards.setOnItemClickListener(this);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        // Bottom tab
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_card, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(PrincipalTab.this, SettingsActivity.class));
            return true;
        }else if (id == R.id.action_about) {
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(URI)));
            return true;
        }else if (id == R.id.action_help) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
    protected void onResume() {
        super.onResume();
        //Sharedpreferences
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(PrincipalTab.this);
        sizeRandom = Integer.parseInt(pref.getString("ncartas", "10"));
    }

    @Override
    public void onTabSelected(@IdRes int tabId) {

        if (tabId == R.id.tab_play) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    lvCards.setAdapter(new CardListAdapter(PrincipalTab.this, getArrayPlayOfCards()));
                    mSwipeRefreshLayout.setRefreshing(false);
                    toolbar.setTitle(R.string.play_cat_string);
                    toolbar.setLogo(R.drawable.ic_play);
                }
            }, 10);
        } else if (tabId == R.id.tab_category) {
            Toast.makeText(getApplicationContext(), "I'm a categary, working NOW.", Toast.LENGTH_SHORT).show();
            toolbar.setTitle(R.string.cat_tab_string);
            toolbar.setLogo(R.drawable.ic_category);
        }else {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    lvCards.setAdapter(new CardListAdapter(PrincipalTab.this, cards));
                    mSwipeRefreshLayout.setRefreshing(false);
                    toolbar.setTitle(R.string.all_tab_string);
                    toolbar.setLogo(R.drawable.ic_cards);
                }
            }, 10);
        }

    }

    @Override
    public void onRefresh() {
        if (bottomBar.getCurrentTabId() == R.id.tab_play) {
            refreshContentPlay();
        } else if (bottomBar.getCurrentTabId() == R.id.tab_category) {
            mSwipeRefreshLayout.setRefreshing(false);
        }else {
            refreshContentAll();
        }
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent = new Intent(PrincipalTab.this, CardScrollingActivity.class);

        if (bottomBar.getCurrentTabId() == R.id.tab_play) {
            intent.putExtra("card", play_cards.get(i));
        } else if (bottomBar.getCurrentTabId() == R.id.tab_category) {

        }else {
            intent.putExtra("card", cards.get(i));
        }

        startActivity(intent);

    }

    // this is just for demonstration, not real code!
    private void refreshContentPlay() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                lvCards.setAdapter(new CardListAdapter(PrincipalTab.this, getArrayPlayOfCards()));
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 1000);
    }

    // this is just for demonstration, not real code!
    private void refreshContentAll() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                lvCards.setAdapter(new CardListAdapter(PrincipalTab.this, cards));
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 1000);
    }


    /**
     * Array que mete todas las cartas
     * @return void
     */
    public void arrayOfCards () {
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
    }

    /**
     *
     * @return
     */
    public ArrayList<Card> getArrayPlayOfCards () {
        play_cards = new ArrayList<Card>();
        //function that create arraylist with 10 numbers
        ArrayList<Integer> randomNumbers = RandomToTenNumbers(cards.size());

        for (int i = 0; i < randomNumbers.size() ; i++) {
            play_cards.add(cards.get(randomNumbers.get(i)));
        }
        return play_cards;
    }

    /**
     *
     * @param size
     * @return
     */
    public ArrayList<Integer> RandomToTenNumbers ( int size){
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
