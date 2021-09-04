package com.man.medhindustan;

public class TopSelling {
    int img;
    String title;
    Double price;

    public TopSelling(int img, String title, Double price) {
        this.img = img;
        this.title = title;
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
