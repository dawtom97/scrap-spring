package com.example.scrap_app.repository;

import com.example.scrap_app.model.ScrapModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScrapRepository extends MongoRepository <ScrapModel,String>{
    boolean existsByTitle(String title);
}