package com.example.demo.Repositories;

import com.example.demo.models.Meme;
import org.springframework.data.repository.CrudRepository;

public interface MemesRepository extends CrudRepository<Meme, Integer> {

}
