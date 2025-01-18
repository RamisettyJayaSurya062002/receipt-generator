package com.example.ReceiptGenerator.model;

public class Item {

    private String shortDescription;
    private String price;

    public Item(String s, String s1) {
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
