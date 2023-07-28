package com.folkscube.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.folkscube.entities.Video;
import com.folkscube.repositories.VideoRepository;

@RestController
public class StreamController {
	private VideoRepository videoRepository;
	
	@Autowired
	StreamController(VideoRepository videoRepository) {
		this.videoRepository = videoRepository;
	}
	
	@PostMapping
	public void saveVideo(@ModelAttribute Video video) {
		this.videoRepository.save(video);
	}
	
	@GetMapping("/videos/all")
	public List<Video> getAllVideos() {
		return this.videoRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<Video> getVideo(@RequestParam Long id) {
		return this.videoRepository.findById(id);
	}
}
