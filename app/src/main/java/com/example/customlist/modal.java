package com.example.customlist;

public class modal {
    int image;
    String langName;

    public modal() {
    }

    public modal(int image,String langName) {
        super();
        this.image = image;
        this.langName=langName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName;
    }
}
