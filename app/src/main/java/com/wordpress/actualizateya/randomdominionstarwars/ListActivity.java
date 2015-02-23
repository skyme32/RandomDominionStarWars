package com.wordpress.actualizateya.randomdominionstarwars;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListActivity extends ActionBarActivity {

    ArrayList<String> arrayTags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_list);

        //Recibir parametros de la activity anterior
        arrayTags = (ArrayList<String>) getIntent().getExtras().get("tags");
        //Toast.makeText(this, "ParametrosActivity devolvió: " + l.get(0), Toast.LENGTH_LONG).show();

        TextView tx = (TextView) findViewById(R.id.tx);
        tx.setText("hhh");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Array que mete todas las cartas
    public void ArrayCards() {

        String [] title = getResources().getStringArray(R.array.title);
        String [] desc = getResources().getStringArray(R.array.desc);
        String [] cost = getResources().getStringArray(R.array.cost);
        String [] image = getResources().getStringArray(R.array.image);
        String [] exp = getResources().getStringArray(R.array.expansion);

        //Toast.makeText(getApplication(),title[y]+","+desc[y]+","+cost[y]+","+image[y]+","+exp[y],Toast.LENGTH_LONG).show();
        //arrayCards.add(new Card(title[y], exp[y], getResources().getIdentifier(image[y], "drawable", getPackageName()), getResources().getIdentifier("money" + cost[y], "drawable", getPackageName()), desc[y]));
    }
}
