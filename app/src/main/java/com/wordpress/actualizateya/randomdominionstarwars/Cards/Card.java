package com.wordpress.actualizateya.randomdominionstarwars.Cards;

import java.io.Serializable;

/**
 * Created by skyme on 20/02/15.
 */
@SuppressWarnings("serial")
public class Card implements Serializable {

    private String title;
    private String descriptions;
    private String uriImageID;
    private int drawableImageID;
    private int drawableImageIDcost;
    private String expansion;

    public Card(String title, String expansion, int drawableImageIDcost, int drawableImageID, String descriptions) {
        this.title = title;
        this.expansion = expansion;
        this.drawableImageIDcost = drawableImageIDcost;
        this.drawableImageID = drawableImageID;
        this.descriptions = descriptions;
    }

    public String getUriImageID() {
        return uriImageID;
    }

    public void setUriImageID(String uriImageID) {
        this.uriImageID = uriImageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpansion() {
        return expansion;
    }

    public void setExpansion(String expansion) {
        this.expansion = expansion;
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

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
