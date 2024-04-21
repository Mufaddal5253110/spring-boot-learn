package com.jetbrains.mufaddal.springlearn.controller;

import com.jetbrains.mufaddal.springlearn.service.PhotoService;
import com.jetbrains.mufaddal.springlearn.model.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotoCloneController {

    @Autowired
    private PhotoService photoService;


    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/photos")
    public Iterable<Photo> get() {
        return photoService.get();
    }

    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable Integer id) {
        Photo photo = photoService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable Integer id) {
        photoService.delete(id);
    }

    @PostMapping("/photo")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = photoService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        return photo;
    }
}
