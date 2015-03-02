package com.wordpress.actualizateya.randomdominionstarwars;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.wordpress.actualizateya.randomdominionstarwars.Cards.Card;


public class CardActivity extends ActionBarActivity {

    private ImageView img;
    private TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Card card = (Card)getIntent().getExtras().getSerializable("card");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(card.getTitle());
        //actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#dcdcdc")));
        setContentView(R.layout.activity_card);

        img = (ImageView) findViewById(R.id.imageCard);
        img.setImageResource(card.getDrawableImageID());
        desc = (TextView) findViewById(R.id.desc);
        desc.setText(card.getDescriptions());


    }

}
