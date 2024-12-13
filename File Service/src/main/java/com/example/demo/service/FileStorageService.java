package com.example.demo.service;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

    @Autowired
    private GridFSBucket gridFSBucket;

    public String storeFile(MultipartFile file) throws Exception {
        GridFSUploadOptions options = new GridFSUploadOptions().chunkSizeBytes(1024).metadata(null);
        ObjectId fileId = gridFSBucket.uploadFromStream(file.getOriginalFilename(), file.getInputStream(), options);
        return fileId.toHexString();
    }
}
