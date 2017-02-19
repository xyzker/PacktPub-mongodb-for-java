package com.packtpub.mongo.chapter2;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class HelloMongo {

    private final static int PORT = 49161;
    private final static String HOST = "200.200.200.204";
 

    public static void main(String args[]) {
        try {
            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient(HOST, PORT);

            DB db = mongoClient.getDB("sampledb");

            System.out.println("Successfully connected to MongoDB");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
