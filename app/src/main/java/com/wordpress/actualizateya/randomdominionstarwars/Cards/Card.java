package com.wordpress.actualizateya.randomdominionstarwars.Cards;

/**
 * Created by skyme on 20/02/15.
 */
public class Card {

    private String title;
    private String descriptions;
    private int drawableImageID;
    private int drawableImageIDcost;

    public Card(String title, String descriptions, int drawableImageID, int cost) {
        this.title = title;
        this.descriptions = descriptions;
        this.drawableImageID = drawableImageID;
        this.drawableImageIDcost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getDrawableImageIDcost() {
        return drawableImageIDcost;
    }

    public void setDrawableImageIDcost(int drawableImageIDcost) {
        this.drawableImageIDcost = drawableImageIDcost;
    }

    public int getDrawableImageID() {
        return drawableImageID;
    }

    public void setDrawableImageID(int drawableImageID) {
        this.drawableImageID = drawableImageID;
    }
}
