package com.folkscube.videostream.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.folkscube.videostream.entities.Video;

@Repository
public interface VideoJpaRepository extends MongoRepository<Video, String> {

}
