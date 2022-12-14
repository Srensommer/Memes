package com.example.demo;


import com.example.demo.Repositories.MemesRepository;
import com.example.demo.models.Meme;
import com.example.demo.models.MemeGenerationQuery;
import com.example.demo.services.MemeFinderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/meme")
@RestController
public class memeController {

    private final MemesRepository memesRepository;
    private final MemeFinderService memeFinderService;

    memeController(MemesRepository memesRepository, MemeFinderService memeFinderService){
        this.memesRepository = memesRepository;
        this.memeFinderService = memeFinderService;
    }
    @PostMapping("/generateMemeByQuery")
    public Meme funny(@RequestBody MemeGenerationQuery memeGenerationQuery) throws IOException, InterruptedException {
        String foundURL = memeFinderService.findMemeURL(memeGenerationQuery.getUrl());
        Meme meme = new Meme(memeGenerationQuery.getName(), foundURL, memeGenerationQuery.getTopText(), memeGenerationQuery.getBottomText());
        return memesRepository.save(meme);
    }

    public MemeFinderService getMemeFinderService() {
        return memeFinderService;
    }
}
