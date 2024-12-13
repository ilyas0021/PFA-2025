package com.example.demo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {

    @Bean
    public GridFSBucket gridFSBucket() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017"); // URL de connexion
        return GridFSBuckets.create(mongoClient.getDatabase("fileservice"));
    }
}
