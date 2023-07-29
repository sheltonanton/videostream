package com.folkscube.videostream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.folkscube.videostream.repositories.FileRepository;
import com.folkscube.videostream.repositories.VideoRepository;

@Component
public class TestCommandLineRunner implements CommandLineRunner {
	@Autowired
	private FileRepository repository;
	@Autowired
	private VideoRepository videoRepository;
	@Override
	public void run(String... args) throws Exception {
//		Optional<File> file = this.repository.findById(new ObjectId("64c44009fa56fa43a04bd990"));
//		if(file.isPresent()) {
//			System.out.println(file.get());
//		}else {
//			System.out.println("Empty file found");
//		}
//		
//		Optional<Video> video = this.videoRepository.findById(new ObjectId("64c43f83fa56fa43a04bd98b"));
//		if(video.isPresent()) {
//			System.out.println(video.get());
//		}else {
//			System.out.println("Blank video");
//		}
//		
//		this.videoRepository.findAll().forEach(v -> { System.out.println(v.getId()); });
	}
}
