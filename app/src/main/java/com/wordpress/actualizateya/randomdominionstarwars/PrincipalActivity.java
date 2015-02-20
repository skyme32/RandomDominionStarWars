package com.wordpress.actualizateya.randomdominionstarwars;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;


public class PrincipalActivity extends ActionBarActivity {

    ListView lv;
    PlanetAdapter plAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Inicializar la lista y añadir el adaptador
        lv = (ListView) findViewById(R.id.listview);
        plAdapter = new PlanetAdapter(displayPlanetList(), this);
        lv.setAdapter(plAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
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

    private ArrayList<Tag> displayPlanetList() {

        ArrayList<Tag> tagtList = new ArrayList<Tag>();
        String[] an = getResources().getStringArray(R.array.tags);

        //Recorrer la lista de array y añadirla al a una arraylist
        for (int y = 0; y < an.length; y++) {
            System.out.printf(an[y]);
            tagtList.add(new Tag(an[y]));
        }

        //Marcar la primera de basico
        tagtList.get(0).setSelected(true);

        return tagtList;
    }
}
