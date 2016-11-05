package com.wordpress.actualizateya.randomdominionstarwars.Layouts;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wordpress.actualizateya.randomdominionstarwars.Cards.Card;
import com.wordpress.actualizateya.randomdominionstarwars.R;


public class CardActivity extends ActionBarActivity {

    private ImageView img;
    private TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        Card card = (Card)getIntent().getExtras().getSerializable("card");

        // Personalizar el navigation bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(card.getTitle());
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        img = (ImageView) findViewById(R.id.imageCard);
        img.setImageResource(card.getDrawableImageID());
        desc = (TextView) findViewById(R.id.desc);
        desc.setText(card.getDescriptions());


    }

}
