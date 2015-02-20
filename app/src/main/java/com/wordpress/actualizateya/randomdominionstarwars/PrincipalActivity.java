package com.wordpress.actualizateya.randomdominionstarwars;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;

import android.widget.ListView;


import java.util.ArrayList;


public class PrincipalActivity extends ActionBarActivity implements View.OnClickListener {

    ListView lv;
    InteractiveArrayAdapter plAdapter;
    String[] an;
    Button btnAllList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Inicializar la lista y añadir el adaptador
        lv = (ListView) findViewById(R.id.listview);
        plAdapter = new InteractiveArrayAdapter(this, displayPlanetList());
        lv.setAdapter(plAdapter);

        //Inicializar botones y darles accion
        btnAllList = (Button) findViewById(R.id.buttonAllList);
        btnAllList.setOnClickListener(this);

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

    private ArrayList<Model> displayPlanetList() {

        ArrayList<Model> tagtList = new ArrayList<Model>();
        an = getResources().getStringArray(R.array.tags);

        //Recorrer la lista de array y añadirla al a una arraylist
        for (int y = 0; y < an.length; y++) {
            System.out.printf(an[y]);
            tagtList.add(new Model(an[y]));
        }

        //Marcar la primera de basico
        tagtList.get(0).setSelected(true);

        return tagtList;
    }

    @Override
    public void onClick(View v) {
        // Start main activity
        Intent intent = new Intent(PrincipalActivity.this, ListActivity.class);
        PrincipalActivity.this.startActivity(intent);

    }
}
