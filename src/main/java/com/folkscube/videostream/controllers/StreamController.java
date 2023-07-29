package com.folkscube.videostream.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.folkscube.videostream.entities.File;
import com.folkscube.videostream.entities.Video;
import com.folkscube.videostream.repositories.VideoRepository;
import com.folkscube.videostream.services.FileService;

@RestController
@RequestMapping("videos")
public class StreamController {
	private VideoRepository repository;
	private FileService service;
	private Logger logger;
	
	StreamController(VideoRepository repository, FileService service) {
		this.repository = repository;
		this.service = service;
		this.logger = LoggerFactory.getLogger(StreamController.class);
	}
	
	@PostMapping
	public Video saveVideo(@RequestParam("upload_file") MultipartFile file, @ModelAttribute Video video) {
		try {
			System.out.println(file.getContentType());
			File uploadedFile = this.service.store(file.getOriginalFilename(), file.getInputStream());
			video.setFile(uploadedFile);
			this.repository.save(video);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return video;
	}
	
	@GetMapping
	public List<Video> getAllVideos() {
		return this.repository.findAll();
	}
	
	@GetMapping("{id}")
	public Video getVideo(@PathVariable("id") String id) {
		Optional<Video> video = this.repository.findById(new ObjectId(id));
		if(video.isPresent()) {
			return video.get();
		}else {
			return null;
		}
	}
	
	@GetMapping(
		value="/{fileId}/stream"
//		produces=MediaType.APPLICATION_OCTET_STREAM_VALUE
	)
	public ResponseEntity<InputStreamResource> stream(@PathVariable("fileId") String fileId) {
		this.logger.info("Fething stream for video: " + fileId);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		
		InputStreamResource inputStreamResource = new InputStreamResource(this.service.retrieve(fileId));
		return ResponseEntity.ok().headers(headers).body(inputStreamResource);
	}
}
