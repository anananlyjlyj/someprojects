package com.eugenebrusov.cards;

import org.json.JSONException;
import org.json.JSONObject;

public class Event {

    private String title;
    private String place;
    private int price;
    private String time;
    private int image;
    private String desc;

    public Event(String title, String place, int price, String time, int image) {
        this.title = title;
        this.place = place;
        this.price = price;
        this.time = time;
        this.image = image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getPlace() {
        return place;
    }

    public int getPrice() {
        return price;
    }

    public String getTime() {
        return time;
    }

    public int getImage() {
        return image;
    }
}
