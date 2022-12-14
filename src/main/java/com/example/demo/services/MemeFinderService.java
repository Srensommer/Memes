package com.example.demo.services;

import java.awt.*;
import java.io.IOException;

public interface MemeFinderService {

    String findMemeURL(String query) throws IOException, InterruptedException;

    Image getPicture(String URL) throws IOException;
}