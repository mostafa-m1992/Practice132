package com.shia.practice128.Models;

public class ModelFree {

    int id;
    int image;
    String title;
    String visit;
    String price;
    String free;

    public ModelFree(int id, int image, String title, String visit, String price, String free) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.visit = visit;
        this.price = price;
        this.free = free;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVisit() {
        return visit;
    }

    public void setVisit(String visit) {
        this.visit = visit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }
}
