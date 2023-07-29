package com.folkscube.videostream.services;

import java.io.InputStream;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.folkscube.videostream.fs.GridFileSystem;
import com.folkscube.videostream.repositories.FileRepository;

@Service
public class FileService {
	private GridFileSystem fileSystem;
	private FileRepository fileRepository;
	
	public FileService(GridFileSystem fileSystem, FileRepository fileRepository) {
		this.fileSystem = fileSystem;
		this.fileRepository = fileRepository;
	}
	
	public com.folkscube.videostream.entities.File store(String filename, InputStream stream) {
		Optional<com.folkscube.videostream.entities.File> file = this.fileRepository.findById(fileSystem.store(filename, stream));
		if(file.isPresent()) {
			return file.get();
		}else {
			return null;
		}
	}
	
	public InputStream retrieve(String fileId) {
		return this.fileSystem.retrieve(fileId);
	}
}
