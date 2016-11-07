package com.wordpress.actualizateya.randomdominionstarwars.Layouts;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wordpress.actualizateya.randomdominionstarwars.Cards.Card;
import com.wordpress.actualizateya.randomdominionstarwars.Cards.ImageDownloaderTask;
import com.wordpress.actualizateya.randomdominionstarwars.R;

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
        ImageView image = (ImageView) findViewById(R.id.image_paralax);
        new ImageDownloaderTask(image).execute(card.getDrawableImageID());

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
