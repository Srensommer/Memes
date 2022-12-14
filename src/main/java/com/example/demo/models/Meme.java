package com.example.demo.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Meme {
    public Meme(String name) {
        this.name = name;
    }

    public Meme(String TopText, String BottomText, String URL, String name) {
        this.TopText = TopText;
        this.BottomText = BottomText;
        this.URL = URL;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private @Setter(AccessLevel.PROTECTED) Integer id;
    @Column(nullable = false)
    private String name;
    private String URL;
    private String TopText;
    private String BottomText;
}