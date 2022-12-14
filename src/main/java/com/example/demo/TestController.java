package com.example.demo;

import com.example.demo.Repositories.MemesRepository;
import com.example.demo.models.Meme;
import com.example.demo.models.MemeDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/penis")
@RestController
public class TestController {
    private final MemesRepository memesRepository;

    TestController(MemesRepository memesRepository){
        this.memesRepository = memesRepository;
    }

    @GetMapping("/pumpe")
    public Iterable<Meme> funny() {
        return memesRepository.findAll();
    }

    @GetMapping("/pumpe/{Id}")
    public Optional<Meme> funny(@PathVariable Integer Id) {
        return memesRepository.findById(Id);
    }

    @PostMapping("/pumpe")
    public Meme funny(@RequestBody MemeDTO memeContent) {
        System.out.print("yo dog");
        Meme meme = new Meme(memeContent.getMemeContent());
        return memesRepository.save(meme);
    }
}
