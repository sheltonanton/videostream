package com.folkscube.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="video")
public class Video {
	@Id
	private Long id;
	private String title;
	private String description;
	private String filepath;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	
}
