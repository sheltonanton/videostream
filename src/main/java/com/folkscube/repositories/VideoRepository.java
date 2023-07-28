package com.folkscube.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.folkscube.entities.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
