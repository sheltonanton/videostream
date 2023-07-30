package com.folkscube.videostream.fs;

import java.io.InputStream;

public interface FileSystem<T> {
	public T store(String filename, InputStream stream);
	public InputStream retrieve(String filename);
}
