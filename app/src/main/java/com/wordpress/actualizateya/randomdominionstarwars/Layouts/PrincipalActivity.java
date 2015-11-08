package com.wordpress.actualizateya.randomdominionstarwars.Layouts;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

import com.wordpress.actualizateya.randomdominionstarwars.R;
import com.wordpress.actualizateya.randomdominionstarwars.Settings.Settings;
import com.wordpress.actualizateya.randomdominionstarwars.Tags.InteractiveArrayAdapter;
import com.wordpress.actualizateya.randomdominionstarwars.Tags.Model;
import com.wordpress.actualizateya.randomdominionstarwars.Cards.Card;

;


public class PrincipalActivity extends ActionBarActivity implements View.OnClickListener {

    //Constants
    private static final String URI = "http://labsk.net/index.php?PHPSESSID=rrvn4kqr0687vftuura39rpdi1&topic=25630.0";

    //Varibles
    ArrayList<Card> arrayCards = new ArrayList();
    ListView lv;
    InteractiveArrayAdapter plAdapter;
    ArrayList<Model> tagList;
    String[] an;
    Button btnAllList;
    Button btnTagList;
    Button btnRandomList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Inicializar la lista y añadir el adaptador
        lv = (ListView) findViewById(R.id.listview);
        plAdapter = new InteractiveArrayAdapter(this, displayPlanetList());
        lv.setAdapter(plAdapter);

        //Inicializar botones y darles accion
        btnAllList = (Button) findViewById(R.id.buttonAllList);
        btnAllList.setOnClickListener(this);
        btnTagList = (Button) findViewById(R.id.buttonTagList);
        btnTagList.setOnClickListener(this);
        btnRandomList = (Button) findViewById(R.id.buttonRandomList);
        btnRandomList.setOnClickListener(this);
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
            startActivity(new Intent(PrincipalActivity.this, Settings.class));
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

    private ArrayList<Model> displayPlanetList() {

        tagList = new ArrayList<Model>();
        an = getResources().getStringArray(R.array.tags);

        //Recorrer la lista de array y añadirla al a una arraylist
        for (int y = 0; y < an.length; y++) {
            tagList.add(new Model(an[y]));
        }

        //Marcar la primera de basico
        tagList.get(0).setSelected(true);
        return tagList;
    }

    @Override
    public void onClick(View v) {
        Integer id = v.getId();
        Integer mark = 0;
        String random = "";
        ArrayList<String> tags = new ArrayList();

        if (id == btnAllList.getId()) {
            mark = 1;
            tags = ArrayTags(mark);
        } else if (id == btnTagList.getId()) {
            tags = ArrayTags(mark);
        } else if (id == btnRandomList.getId()) {
            tags = ArrayTags(mark);
            random = "R";
        }

        if (tags.size() == 0) {
            Toast.makeText(getApplication(), R.string.error_expansion, Toast.LENGTH_SHORT).show();
        }else{
            // Start main activity
            Intent intent = new Intent(PrincipalActivity.this, ListActivity.class);
            intent.putExtra("tags", tags);
            intent.putExtra("random", random);
            PrincipalActivity.this.startActivity(intent);
        }

    }

    //Array para mirar que tags ponemos y cules no
    public ArrayList<String> ArrayTags(Integer mark) {
        ArrayList<String> tags = new ArrayList();

        //Recorrer la lista de array y añadirla al a una arraylist
        for (int i = 0; i < tagList.size(); i++) {

            if (mark == 1) {
                tags.add(tagList.get(i).getName());
            }else{
                if (tagList.get(i).isSelected()) {
                    tags.add(tagList.get(i).getName());
                }
            }
        }

        return tags;
    }
}
