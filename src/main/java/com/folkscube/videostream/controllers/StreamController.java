package com.folkscube.videostream.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.folkscube.videostream.entities.Video;
import com.folkscube.videostream.repositories.VideoJpaRepository;

@RestController
@RequestMapping("videos")
public class StreamController {
	private VideoJpaRepository repository;
	
	@Autowired
	StreamController(VideoJpaRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	public void saveVideo(@RequestBody Video video) {
		this.repository.save(video);
	}
	
	@GetMapping("all")
	public List<Video> getAllVideos() {
		return this.repository.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<Video> getVideo(@RequestParam String id) {
		return this.repository.findById(id);
	}
}
