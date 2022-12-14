package com.example.demo.services;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class MemeFinderServiceImpl implements MemeFinderService{

    public HttpClient httpClient;
    private final String memeApiURL;

    public MemeFinderServiceImpl(){
        httpClient = HttpClient.newHttpClient();
        memeApiURL = "https://rkgk.api.searchify.com/v1/indexes/kym_production/instantlinks?query=param&fetch=name%2Curl%2Cicon_url";
    }

    public String findMemeURL(String query) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(memeApiURL.replace("param", query)))
                .build();
        HttpResponse<String> response = httpClient.send(request,
                HttpResponse.BodyHandlers.ofString());
        JsonObject convertedObject = new Gson().fromJson(response.body(), JsonObject.class);
        JsonArray objs = convertedObject.getAsJsonArray("results");
        String temp = objs.get(0).toString();
        JsonObject firstRes = new Gson().fromJson(temp, JsonObject.class);
        return firstRes.get("icon_url").toString();
    }

    public Image getPicture(String ImageUrl) throws IOException {
        checkURL(ImageUrl);
        URL url = new URL(ImageUrl);
        return ImageIO.read(url);
    }

    private Boolean checkURL(String imageUrl) {
        //TODO: Add verification of URL
        return true;
    }

}

