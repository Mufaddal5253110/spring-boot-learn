package com.jetbrains.mufaddal.springlearn.service;

import com.jetbrains.mufaddal.springlearn.model.Photo;
import com.jetbrains.mufaddal.springlearn.repository.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotoService {
    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Iterable<Photo> get(){
        return photoRepository.findAll();
    }

    public Photo get(Integer id) {
        return photoRepository.findById(id).orElse(null);
    }

    public Photo save(String fileName,String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setFileName(fileName);
        photo.setContentType(contentType);
        photo.setData(data);
        photoRepository.save(photo);
        return photo;
    }

    public void delete(Integer id) {
        photoRepository.deleteById(id);
    }


}
