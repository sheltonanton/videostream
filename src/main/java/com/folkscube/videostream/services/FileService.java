package com.folkscube.videostream.services;

import java.io.InputStream;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.folkscube.videostream.fs.FileSystem;
import com.folkscube.videostream.repositories.FileRepository;

@Service
public class FileService {
	private FileSystem<ObjectId> fileSystem;
	private FileRepository fileRepository;
	
	public FileService(FileSystem<ObjectId> fileSystem, FileRepository fileRepository) {
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
