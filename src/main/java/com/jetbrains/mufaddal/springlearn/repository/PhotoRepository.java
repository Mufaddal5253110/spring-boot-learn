package com.jetbrains.mufaddal.springlearn.repository;

import com.jetbrains.mufaddal.springlearn.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo,Integer> {
    
}
