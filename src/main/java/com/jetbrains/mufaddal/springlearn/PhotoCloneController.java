package com.jetbrains.mufaddal.springlearn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhotoCloneController {

    private List<Photo> db = List.of(new Photo("1", "firstImage.jpg"));

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/photos")
    public List<Photo> getPhotos() {
        return db;
    }
}
