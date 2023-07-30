package com.folkscube.videostream.fs;

import java.io.InputStream;

import org.bson.types.ObjectId;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.stereotype.Component;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;

@Component
@Primary
public class GridFileSystem implements FileSystem<ObjectId> {
	private MongoDatabaseFactory mongodbFactory;
	private GridFSBucket bucket;
	
	public GridFileSystem(MongoDatabaseFactory mongodbFactory) {
		this.mongodbFactory = mongodbFactory;
		this.bucket = GridFSBuckets.create(this.mongodbFactory.getMongoDatabase(), "demo");
	}

	@Override
	public ObjectId store(String filename, InputStream stream) {
		GridFSUploadOptions options = new GridFSUploadOptions().chunkSizeBytes(1048576);
		ObjectId id = this.bucket.uploadFromStream(filename, stream, options); //this needs to happen in a separate thread
		return id;
	}

	@Override
	public InputStream retrieve(String fileId) {
		return this.bucket.openDownloadStream(new ObjectId(fileId));
	}
}
