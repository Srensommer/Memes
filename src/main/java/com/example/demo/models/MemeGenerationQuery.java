package com.example.demo.models;

public class MemeGenerationQuery {
    private String url;
    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url = url;
    }
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    private String TopText;
    public String getTopText(){
        return TopText;
    }
    public void setTopText(String topText){
        TopText = topText;
    }
    private String BottomText;

    public void setBottomText(String bottomText) {
        BottomText = bottomText;
    }

    public String getBottomText() {
        return BottomText;
    }
}
