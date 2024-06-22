package com.example.faculdade.repository;

import com.example.faculdade.model.MaterialDidatico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialDidaticoRepository extends MongoRepository<MaterialDidatico, String> {
}