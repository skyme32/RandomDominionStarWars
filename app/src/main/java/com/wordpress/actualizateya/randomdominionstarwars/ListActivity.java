package com.wordpress.actualizateya.randomdominionstarwars;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.wordpress.actualizateya.randomdominionstarwars.Cards.CardsAdapter;
import com.wordpress.actualizateya.randomdominionstarwars.Cards.Card;

import java.util.ArrayList;


public class ListActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private ListView lvCards;
    private CardsAdapter adapter;
    private String random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_list);


        // Inicializamos las variables.
        adapter = new CardsAdapter(this, arrayOfCards());

        lvCards = (ListView) findViewById(R.id.listCard);
        // Asignamos el Adapter al ListView, en este punto hacemos que el
        // ListView muestre los datos que queremos.
        lvCards.setAdapter(adapter);
        // Asignamos el Listener al ListView para cuando pulsamos sobre uno de
        // sus items.
        lvCards.setOnItemClickListener(this);
    }

    //Array que mete todas las cartas
    public ArrayList<Card> arrayOfCards() {

        //Recibir parametros de la activity anterior
        ArrayList<String> arrayTags = (ArrayList<String>) getIntent().getExtras().get("tags");
        random = (String) getIntent().getExtras().get("random");
        ArrayList<Card> cards = new ArrayList<Card>();
        //Toast.makeText(this, "ParametrosActivity devolvió: " + l.get(0), Toast.LENGTH_LONG).show();

        String [] title = getResources().getStringArray(R.array.title);
        String [] desc = getResources().getStringArray(R.array.desc);
        String [] cost = getResources().getStringArray(R.array.cost);
        String [] image = getResources().getStringArray(R.array.image);
        String [] exp = getResources().getStringArray(R.array.expansion);

        //Toast.makeText(getApplication(),title[y]+","+desc[y]+","+cost[y]+","+image[y]+","+exp[y],Toast.LENGTH_LONG).show();
        for (int y = 0; y < title.length; y++) {
            for (int i = 0; i < arrayTags.size(); i++) {
                if (arrayTags.get(i).equals(exp[y])) {
                    cards.add(new Card(title[y],
                            exp[y],
                            getResources().getIdentifier("money" + cost[y], "drawable", getPackageName()),
                            getResources().getIdentifier(image[y], "drawable", getPackageName()),
                            desc[y]));
                }
            }
        }

        //Si queremos que sea random pasamos por aqui
        if (random.equals("R")) {
            ArrayList<Card> cardsRandom = cards;
            cards = new ArrayList<Card>();
            //function that create arraylist with 10 numbers
            ArrayList<Integer> arra = RandomToTenNumbers(cardsRandom.size());

            for (int i = 0; i < arra.size() ; i++) {
                cards.add(cardsRandom.get(arra.get(i)));
            }
        }


        return cards;
        //cards.add(new Card(title[y], exp[y], getResources().getIdentifier(image[y], "drawable", getPackageName()), getResources().getIdentifier("money" + cost[y], "drawable", getPackageName()), desc[y]));
    }

    public ArrayList<Integer> RandomToTenNumbers(int size) {
        //Sharedpreferences
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ListActivity.this);
        Integer sizeRandom = Integer.parseInt(pref.getString("ncartas","10"));
        //bucle trought all numbers
        int pos;
        int nCartas = size;
        ArrayList<Integer> arrNumbers = new ArrayList<>();
        for (int i = 0; i < sizeRandom ; i++) {
            pos = (int) Math.floor(Math.random() * nCartas );
            while (arrNumbers.contains(pos)) {
                pos = (int) Math.floor(Math.random() * nCartas );
            }
            arrNumbers.add(pos);
        }
        return arrNumbers;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
