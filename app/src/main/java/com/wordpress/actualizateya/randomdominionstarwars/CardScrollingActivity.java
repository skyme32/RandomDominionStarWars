package com.wordpress.actualizateya.randomdominionstarwars;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wordpress.actualizateya.randomdominionstarwars.Cards.Card;

public class CardScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_scrolling);
        Card card = (Card)getIntent().getExtras().getSerializable("card");

        setToolbar();// Añadir action bar

        CollapsingToolbarLayout collapser =
                (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapser.setTitle(card.getTitle()); // Cambiar título

        // Add image in the toolbar
        loadImageParallax(card.getDrawableImageID(),R.id.image_paralax);

        // Implement the Floating button
        loadImageParallax(card.getDrawableImageIDcost(),R.id.detailItemfab);

        // Add the description
        TextView desc = (TextView) findViewById(R.id.content_card);
        desc.setText(card.getDescriptions());
    }

    private void setToolbar() {
        // Añadir la Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    /**
     * Se carga una imagen aleatoria para el detalle
     */
    private void loadImageParallax(int id, int view) {
        ImageView image = (ImageView) findViewById(view);
        // Usando Glide para la carga asíncrona
        Glide.with(this)
                .load(id)
                .centerCrop()
                .into(image);
    }
}
