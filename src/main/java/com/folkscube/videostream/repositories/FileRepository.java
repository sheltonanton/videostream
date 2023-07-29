package com.folkscube.videostream.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.folkscube.videostream.entities.File;

public interface FileRepository extends MongoRepository<File, ObjectId>{

}
