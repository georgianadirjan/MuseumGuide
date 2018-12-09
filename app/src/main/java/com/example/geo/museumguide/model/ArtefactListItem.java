package com.example.geo.museumguide.model;

/**
 * Created by Geo on 1/6/2017.
 */

public class ArtefactListItem  {

    private String itemTitle;

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public ArtefactListItem(String title){
        this.itemTitle = title;
    }
}
